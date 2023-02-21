package top.dreamcenter.qbot.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 将kv值转换成 ,a=b,c=d...的字符串或者JSONObject
 * @param <T> value类型
 */
public class KVString<T> {

    private final Map<String, T> kvs;

    private KVString(){
        kvs = new HashMap<>();
    }

    /**
     * 创建构造器
     * @param <T> v类型
     * @return this
     */
    public static <T> KVString<T> builder() {
        return new KVString<>();
    }

    /**
     * 添加kv
     * @param k k
     * @param v v
     * @return this
     */
    public KVString<T> put(String k, T v) {
        kvs.put(k, v);
        return this;
    }

    /**
     * 构建字符串
     * @return 如果空，则返回""，否则返回 ",a=b,c=d..."
     */
    public String build(){
        //
        if (kvs.size() == 0) return "";

        StringBuilder sb = new StringBuilder();
        // ,a=b,c=d,...
        for (Map.Entry<String, T> next : kvs.entrySet()) {
            if (next.getValue() != null)
                sb.append(",").append(next.getKey()).append("=").append(next.getValue());
        }

        return sb.toString();
    }

    /**
     * 构建json
     * @return JSONObject，去除null
     */
    public JSONObject pack() {
        // ,a=b,c=d,...
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, T> next : kvs.entrySet()) {
            if (next.getValue() != null)
                jsonObject.put(next.getKey(),next.getValue());
        }

        return jsonObject;
    }

    public String toQRCode(String type) {
        return CQCodeFormat.format(type, build());
    }
}

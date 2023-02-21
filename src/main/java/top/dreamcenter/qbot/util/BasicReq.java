package top.dreamcenter.qbot.util;


import com.alibaba.fastjson.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import top.dreamcenter.qbot.entity.PackServer;
import top.dreamcenter.qbot.entity.RetResult;

/**
 * 基本请求方式
 * <p>配合类型参考工具类 {@link PTR} 来为 typeReference 传参以实现快速使用 </p>
 * @param <T> RetResult的body类型
 */
public class BasicReq <T> {

    private final PackServer packServer;

    public BasicReq(PackServer packServer) {
        this.packServer = packServer;
    }

    /**
     * post请求
     * @param uri uri，以/打头
     * @param body body 实际要发送的数据
     * @param typeReference 类型参考转化
     * @return RetResult
     */
    public RetResult<T> post(String uri, JSONObject body, ParameterizedTypeReference<RetResult<T>> typeReference){
        return packServer.getTemplate().exchange(
                packServer.getServer()+ uri, HttpMethod.POST, new HttpEntity<>(body), typeReference)
                .getBody();
    }

    /**
     * post请求，直接返回data结果
     * @param uri uri，以/打头
     * @param body body 实际要发送的数据
     * @param typeReference 类型参考转化
     * @return data
     */
    public T postForData(String uri, JSONObject body, ParameterizedTypeReference<RetResult<T>> typeReference) {
        return post(uri, body, typeReference).getData();
    }

}

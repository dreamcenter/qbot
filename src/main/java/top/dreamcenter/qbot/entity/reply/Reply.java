package top.dreamcenter.qbot.entity.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用回复结构
 * <p> 如果Reply或者reply为null，则不做回复。
 * <p> 如果reply内容为""，也不做回复。
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    /**
     * 回复的内容整合
     */
    private String reply;

    /**
     * 注意，在获取reply时候，都是直接获取的toString，
     * 所以如果要做子类实现，也一定要注意重写toString才能实现。
     * @return str
     */
    public final String getReply() {
        return toString();
    }

    /**
     * 转化器，用于解析CQ码
     * @param raw 原始CQ码字符串
     */
    public void transform(String raw){
        reply = raw;
    }

    @Override
    public String toString(){
        return reply;
    }
}

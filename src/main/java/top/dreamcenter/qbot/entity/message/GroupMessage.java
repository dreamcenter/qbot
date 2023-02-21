package top.dreamcenter.qbot.entity.message;

import lombok.Data;
import lombok.ToString;
import top.dreamcenter.qbot.entity.Anonymous;
import top.dreamcenter.qbot.entity.message.Message;

/**
 * 群组消息
 */
@Data
@ToString
public class GroupMessage extends Message {
    /**
     * 匿名情况，如果没有匿名为null
     */
    private Anonymous anonymous;
    /**
     * 群号
     */
    private Long group_id;
}

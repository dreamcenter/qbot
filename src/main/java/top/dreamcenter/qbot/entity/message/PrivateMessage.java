package top.dreamcenter.qbot.entity.message;

import lombok.Data;
import lombok.ToString;

/**
 * 私发消息
 */
@Data
@ToString
public class PrivateMessage extends Message {
    /**
     * 收消息的人的账号
     */
    private Long target_id;
}

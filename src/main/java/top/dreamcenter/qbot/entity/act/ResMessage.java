package top.dreamcenter.qbot.entity.act;

import lombok.Data;
import top.dreamcenter.qbot.entity.account.Account;

/**
 * 获取到的消息
 */
@Data
public class ResMessage {
    /**
     * 时间戳，10位数
     */
    private Long time;
    /**
     * 真实id
     */
    private Long real_id;
    /**
     * 消息id
     */
    private Integer message_id;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 原始消息内容
     */
    private String raw_message;
    /**
     * 发送消息人的详细消息
     */
    private Account sender;
}

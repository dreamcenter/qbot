package top.dreamcenter.qbot.entity.message;

import lombok.Data;
import lombok.ToString;
import top.dreamcenter.qbot.entity.account.Account;

/**
 * 通用消息模型
 */
@Data
@ToString
public class Message {
    /**
     * 时间戳，10位数
     */
    private Long time;
    /**
     * 机器人账号
     */
    private Long self_id;
    /**
     * 两者关系
     */
    private String sub_type;
    /**
     * 消息id
     */
    private Integer message_id;
    /**
     * 发送消息的人的账号
     */
    private Long user_id;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 原始消息内容
     */
    private String raw_message;
    /**
     * 字体，暂且没发现有什么用
     */
    private Integer font;
    /**
     * 发送消息人的详细消息
     */
    private Account sender;
}

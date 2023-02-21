package top.dreamcenter.qbot.entity.act;

import lombok.Data;
import lombok.ToString;
import top.dreamcenter.qbot.entity.account.Account;

/**
 * forward合并消息的基础消息结构
 */
@Data
@ToString
public class BasicMsg {

    /**
     * 内容
     */
    private String content;

    /**
     * 发送者
     */
    private Account sender;

    /**
     * 发送时间
     */
    private Long time;
}

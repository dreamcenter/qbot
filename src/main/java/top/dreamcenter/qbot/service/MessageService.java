package top.dreamcenter.qbot.service;

import top.dreamcenter.qbot.entity.message.GroupMessage;
import top.dreamcenter.qbot.entity.message.PrivateMessage;
import top.dreamcenter.qbot.entity.reply.Reply;

/**
 * 消息处理业务
 */
public interface MessageService {

    /**
     *
     * @param message 得到的消息实体
     * @return 回复的消息实体
     */
    Reply handleGroupMsg(GroupMessage message);

    /**
     *
     * @param message 得到的消息实体
     * @return 回复的消息实体
     */
    Reply handlePrivateMsg(PrivateMessage message);
}

package top.dreamcenter.qbot.service.impl;

import top.dreamcenter.qbot.active.AccountManageACT;
import top.dreamcenter.qbot.entity.message.GroupMessage;
import top.dreamcenter.qbot.entity.message.PrivateMessage;
import top.dreamcenter.qbot.entity.reply.AtReply;
import top.dreamcenter.qbot.entity.reply.Reply;
import top.dreamcenter.qbot.entity.reply.TTSReply;
import top.dreamcenter.qbot.service.MessageService;
import top.dreamcenter.qbot.util.ReplyLink;

/**
 * 这是一个示例实现方案，很简单的实现了
 * <p> 建议重新实现一个 MessageService 进行编写。
 * <p> 注意自己的实现类要加 @Service注解，我这里没有加因为在config中条件注入了！
 */
public class MessageServiceExampleImpl implements MessageService {

    private final AccountManageACT accountManageACT;

    public MessageServiceExampleImpl(AccountManageACT accountManageACT) {
        this.accountManageACT = accountManageACT;
    }

    @Override
    public Reply handleGroupMsg(GroupMessage message) {
        if (!message.getMessage().contains("秘书")) return null;
        // @xxx 你好啊！
        return ReplyLink.getInstance()
                .append(new AtReply(message.getUser_id()))
                .append(new Reply(" 你好啊!"))
                .link();
    }

    @Override
    public Reply handlePrivateMsg(PrivateMessage message) {
        // 通过 AccountManageACT 类的 getLoginInfo() 方法 获取当前登录用户的信息
        System.out.println(accountManageACT.getLoginInfo());
        // 返回 tts 文字语音
        return new TTSReply("你好");
    }
}

package top.dreamcenter.qbot.util;

import top.dreamcenter.qbot.entity.reply.Reply;

/**
 * 多个reply样式链接形成一句话发出
 */
public class ReplyLink {

    private final StringBuilder sb;

    private ReplyLink() {
        sb = new StringBuilder();
    }

    public static ReplyLink getInstance() {
        return new ReplyLink();
    }

    public ReplyLink append(Reply reply) {
        sb.append(reply);
        return this;
    }

    public Reply link() {
        return new Reply(sb.toString());
    }

}

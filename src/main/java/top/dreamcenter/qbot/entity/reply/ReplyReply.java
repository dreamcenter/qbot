package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 回复消息 TODO
 * <p>范围: 发送/接收</p>
 */
@Data
public class ReplyReply extends Reply{

    /**
     * 回复时所引用的消息id, 必须为本群消息.
     */
    private Integer id;

    /**
     * 自定义回复的信息
     */
    private String text;

    /**
     * 自定义回复时的自定义QQ, 如果使用自定义信息必须指定
     */
    private Long qq;

    /**
     * 自定义回复时的时间, 格式为Unix时间
     */
    private Long time;

    /**
     * TODO 起始消息序号, 可通过 get_msg 获得
     */
    private Long seq;

    public ReplyReply(Integer id) {
        this.id = id;
    }

    /**
     * TODO 自定义回复
     * @param text /
     * @param qq /
     * @param time /
     * @param seq /
     */
    public ReplyReply(String text, Long qq, Long time, Long seq) {
        this.text = text;
        this.qq = qq;
        this.time = time;
        this.seq = seq;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("id", id).put("text", text)
                .put("qq", qq).put("time", time)
                .put("seq", seq)
                .toQRCode("reply");
    }
}

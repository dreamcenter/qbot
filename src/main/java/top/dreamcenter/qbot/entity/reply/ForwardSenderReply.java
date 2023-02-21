package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 合并消息，将得到的合并消息CQ码原始字符串解析成该对象
 * <p> 可以获得CQ码中的合并转发消息ID </p>
 */
@Data
public class ForwardSenderReply extends Reply{

    /**
     * 合并转发ID, 需要通过 {@link top.dreamcenter.qbot.active.MsgACT#getForwardMsg(String)} 获取转发的具体内容
     */
    private String id;

    /**
     *
     * @param raw 原始CQ码
     */
    public ForwardSenderReply(String raw) {
        transform(raw);
    }

    @Override
    public void transform(String raw) {
        // [CQ:forward,id=+EnPOUKQw1jlbbqynKX8Td8L1kyJkP2QQq4RxADWivFRzNRCyXGa9zmQkuPcHHpX]
        int from = raw.indexOf("id=") + 3;
        int end = raw.length() - 1;
        this.id = raw.substring(from, end);
    }

    @Override
    public String toString(){
        return KVString.builder().put("id", id).toQRCode("forward");
    }
}

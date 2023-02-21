package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 戳一戳
 * <p> 发送戳一戳消息无法撤回, 返回的 message id 恒定为 0 </p>
 * 范围: 仅群聊
 */
@Data
public class PokeReply extends Reply{
    /**
     * qq
     */
    private Long qq;

    public PokeReply(Long qq) {
        this.qq = qq;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("qq", qq)
                .toQRCode("poke");
    }
}

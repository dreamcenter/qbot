package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 红包（好像没用）
 */
@Data
@Deprecated
public class RedBegReply extends Reply{

    /**
     * 祝福语/口令
     */
    private String title;

    public RedBegReply(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("title", title)
                .toQRCode("redbag");
    }
}

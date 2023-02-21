package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 群内@某人
 */
@Data
public class AtReply extends Reply{

    /**
     * 该人qq号
     * <p>如果设置为all表示全体成员</p>
     */
    private Long qq;

    /**
     * 当在群中找不到上述QQ号的名称时才会生效
     */
    private String name = null;

    public AtReply(Long qq) {
        this.qq = qq;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("qq", qq).put("name", name)
                .toQRCode("at");
    }

}

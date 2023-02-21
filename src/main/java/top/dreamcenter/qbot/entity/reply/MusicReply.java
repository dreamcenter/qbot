package top.dreamcenter.qbot.entity.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 分享音乐
 */
@Data
@AllArgsConstructor
public class MusicReply extends Reply{

    /**
     * 分享类别
     * <p>- qq  (qq音乐)
     * <p>- 163 (网易音乐)
     * <p>- xm  (虾米音乐)
     */
    private String type;

    /**
     * 音乐id
     */
    private String id;

    @Override
    public String toString(){
        return KVString.builder()
                .put("type", type)
                .put("id", id)
                .toQRCode("music");
    }
}

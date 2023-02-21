package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 链接分享
 */
@Data
public class ShareReply extends Reply{

    /**
     * URL
     */
    private String url;

    /**
     * 标题
     */
    private String title;

    /**
     * 发送时可选, 内容描述
     */
    private String content = null;

    /**
     * 发送时可选, 图片 URL
     */
    private String image = null;

    public ShareReply(String url, String title) {
        this.url = url;
        this.title = title;
    }

    @Override
    public String toString(){
        return KVString.builder()
                        .put("url", url).put("title", title)
                        .put("content", content).put("image", image)
                .toQRCode("share");
    }
}

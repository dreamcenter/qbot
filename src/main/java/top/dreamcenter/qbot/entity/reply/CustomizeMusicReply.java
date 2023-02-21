package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 自定义音乐分享（好像没用）
 */
@Data
@Deprecated
public class CustomizeMusicReply extends Reply{
    /**
     * 表示音乐自定义分享
     */
    private final String type = "custom";

    /**
     * 点击后跳转目标 URL
     */
    private String url;

    /**
     * 音乐资源 URL
     */
    private String audio;

    /**
     * 标题
     */
    private String title;

    /**
     * 发送时可选, 内容描述
     */
    private String content;

    /**
     * 发送时可选, 图片 URL
     */
    private String image;

    public CustomizeMusicReply(String url, String audio, String title) {
        this.url = url;
        this.audio = audio;
        this.title = title;
    }

    public String toString(){
        return KVString.builder()
                .put("type", type)
                .put("url", url)
                .put("audio", url)
                .put("title", url)
                .put("content", url)
                .put("image", url)
                .toQRCode("music");
    }
}

package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 视频回复，go-cqhttp-v0.9.38 起开始支持发送，需要依赖ffmpeg
 * TODO 待测试可行性
 */
@Data
public class VideoReply extends Reply{

    /**
     * 视频地址, 支持http和file发送
     */
    private String file;

    /**
     * 视频封面, 支持http, file和base64发送, 格式必须为jpg
     */
    private String cover;

    /**
     * 通过网络下载视频时的线程数, 默认单线程. (在资源不支持并发时会自动处理)
     * <p>可能的值2，3</p>
     */
    private Integer c;

    public VideoReply(String file, String cover) {
        this.file = file;
        this.cover = cover;
    }

    @Override
    public String toString() {
        return KVString.builder()
                .put("file", file)
                .put("cover", cover)
                .put("c", c)
                .toQRCode("video");
    }
}

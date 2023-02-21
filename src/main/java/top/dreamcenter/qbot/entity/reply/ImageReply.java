package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 发送图片
 *
 * <p> 图片最大不能超过30MB
 *
 * <p> PNG格式不会被压缩, JPG可能不会二次压缩, GIF非动图转成PNG
 *
 * <p> GIF动图原样发送(总帧数最大300张, 超过无法发出, 无论循不循环)
 */
@Data
public class ImageReply extends Reply{

    /**
     * 图片文件名
     */
    private String file;

    /**
     * 图片类型, flash 表示闪照, show 表示秀图, 默认普通图片
     */
    private String type;

    /**
     * 图片子类型, 只出现在群聊.
     * <p> - 0	正常图片
     * <p> - 1	表情包, 在客户端会被分类到表情包图片并缩放显示
     * <p> - 2	热图
     * <p> - 3	斗图
     * <p> - 4	智图?
     * <p> - 7	贴图
     * <p> - 8	自拍
     * <p> - 9	贴图广告?
     * <p> - 10	有待测试
     * <p> - 13	热搜图
     */
    private String subType;

    /**
     * 图片 URL
     */
    private String url;

    /**
     * 只在通过网络 URL 发送时有效, 表示是否使用已缓存的文件, 默认 1
     */
    private Byte cache = 1;

    /**
     * 发送秀图时的特效id, 默认为40000
     * <p> - 40000	普通
     * <p> - 40001	幻影
     * <p> - 40002	抖动
     * <p> - 40003	生日
     * <p> - 40004	爱你
     * <p> - 40005	征友
     */
    private Integer id = 40000;

    /**
     * 通过网络下载图片时的线程数, 默认单线程. (在资源不支持并发时会自动处理)
     */
    private Byte c;

    public ImageReply(String file, String url) {
        this.file = file;
        this.url = url;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("file", file).put("type", type)
                .put("subType", subType).put("url", url)
                .put("cache", cache).put("id", id)
                .put("c", c)
                .toQRCode("image");
    }
}

package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 卡片消息
 * <p>xml 接口的消息都存在风控风险, 请自行兼容发送失败后的处理 ( 可以失败后走普通图片模式 )</p>
 */
@Data
public class CardImageReply extends Reply{

    /**
     * 和image的file字段对齐, 支持也是一样的
     */
    private String file;

    /**
     * 默认不填为400, 最小width
     */
    private Long minwidth = 400L;

    /**
     * 默认不填为400, 最小height
     */
    private Long minheight = 400L;

    /**
     * 默认不填为500, 最大width
     */
    private Long maxwidth = 500L;

    /**
     * 默认不填为1000, 最大height
     */
    private Long maxheight = 1000L;

    /**
     * 分享来源的名称, 可以留空
     */
    private String source;

    /**
     * 分享来源的icon图标url, 可以留空
     */
    private String icon;

    /**
     * 创建卡片消息
     * @param file 卡片图片地址
     */
    public CardImageReply(String file) {
        this.file = file;
    }

    @Override
    public String toString(){
        return KVString.builder().put("file", file)
                .put("minwidth", minwidth).put("minheight", minheight)
                .put("maxwidth", maxwidth).put("maxheight", maxheight)
                .put("source", source).put("icon", icon)
                .toQRCode("cardimage");
    }

}

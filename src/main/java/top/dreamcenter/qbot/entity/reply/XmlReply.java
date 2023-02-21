package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * xml内容发送
 * <p> 我尝试了几次，每次一发就账号风控的说 </p>
 * <p> 官方: xml 接口的消息都存在风控风险, 请自行兼容发送失败后的处理 ( 可以失败后走普通图片模式 )</p>
 */
@Data
public class XmlReply extends Reply{

    /**
     * xml内容, xml，结果已经实体化处理
     */
    private String data;

    /**
     * 可以不填. 默认不填为0, 走小程序通道, 填了走富文本通道发送
     */
    private Integer resid = 0;

    public XmlReply(String data) {
        data.replace(",","&#44;")
                .replace("&","&amp;")
                .replace("[","&#91;")
                .replace("]","&#93;");
        this.data = data;
    }

    public XmlReply(String data, Integer resid) {
        this(data);
        this.resid = resid;
    }

    @Override
    public String toString(){
        return KVString.builder().put("data", data).put("resid", resid).toQRCode("xml");
    }
}

package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 发送json数据
 */
@Data
public class JsonReply extends Reply{

    /**
     * json内容, 传递原始json即可，结果已经实体化处理
     */
    private String data;

    /**
     * 默认不填为0, 走小程序通道, 填了走富文本通道发送
     */
    private Integer resid = 0;

    public JsonReply(String data) {
        data.replace(",","&#44;")
                .replace("&","&amp;")
                .replace("[","&#91;")
                .replace("]","&#93;");
        this.data = data;
    }

    @Override
    public String toString(){
        return KVString.builder().put("data", data).put("resid", resid).toQRCode("json");
    }

}

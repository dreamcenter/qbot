package top.dreamcenter.qbot.entity.reply;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表情回复
 * <p> 表情对应id详情见如下链接
 * <p> https://github.com/kyubotics/coolq-http-api/wiki/表情-CQ-码-ID-表
 */
@Data
@AllArgsConstructor
public class FaceReply extends Reply{

    /**
     * 表情id
     */
    private Integer id;

    @Override
    public String toString(){
        // [CQ:face,id=123]
        return "[CQ:face,id=" + id + "]";
    }
}

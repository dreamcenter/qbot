package top.dreamcenter.qbot.entity.reply;

import lombok.Data;
import top.dreamcenter.qbot.util.KVString;

/**
 * 礼物（好像没用）
 * <p>仅支持免费礼物, 发送群礼物消息 无法撤回, 返回的 message id 恒定为 0</p>
 * <p>范围: 仅群聊,接收的时候不是 CQ 码</p>
 */
@Data
@Deprecated
public class GiftReply extends Reply{

    /**
     * 接受礼物的成员
     */
    private Long qq;

    /**
     * 礼物id
     * <p> - 0	甜 Wink
     * <p> - 1	快乐肥宅水
     * <p> - 2	幸运手链
     * <p> - 3	卡布奇诺
     * <p> - 4	猫咪手表
     * <p> - 5	绒绒手套
     * <p> - 6	彩虹糖果
     * <p> - 7	坚强
     * <p> - 8	告白话筒
     * <p> - 9	牵你的手
     * <p> - 10	可爱猫咪
     * <p> - 11	神秘面具
     * <p> - 12	我超忙的
     * <p> - 13	爱心口罩
     */
    private Integer id;

    public GiftReply(Long qq, Integer id) {
        this.qq = qq;
        this.id = id;
    }

    @Override
    public String toString(){
        return KVString.builder()
                .put("qq", qq).put("id", id)
                .toQRCode("gift");
    }
}

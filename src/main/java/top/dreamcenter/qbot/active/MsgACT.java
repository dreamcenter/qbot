package top.dreamcenter.qbot.active;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.dreamcenter.qbot.entity.PackServer;
import top.dreamcenter.qbot.entity.act.ForwardMsg;
import top.dreamcenter.qbot.entity.act.MessageID;
import top.dreamcenter.qbot.entity.act.ResImage;
import top.dreamcenter.qbot.entity.act.ResMessage;
import top.dreamcenter.qbot.entity.reply.ForwardReceiverReply;
import top.dreamcenter.qbot.entity.reply.ForwardSenderReply;
import top.dreamcenter.qbot.util.BasicReq;
import top.dreamcenter.qbot.util.KVString;
import top.dreamcenter.qbot.util.PTR;

import java.util.ArrayList;
import java.util.List;

/**
 * 主动向go-cqhttp调用消息相关api
 */
@Component
public class MsgACT {

    @Autowired
    private PackServer packServer;

    /**
     * 发送私信消息
     * @param userID 对方 QQ 号
     * @param groupID 主动发起临时会话群号(机器人本身必须是管理员/群主)
     * @param msg 要发送的内容
     * @param autoEscape 推荐false, 消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
     * @return message_id，如果调用出现错误，返回null
     */
    public Integer sendPrivateMsg(long userID, long groupID, String msg, boolean autoEscape) {
        JSONObject pack = KVString.builder()
                .put("user_id", userID).put("group_id", groupID)
                .put("message", msg).put("auto_escape", autoEscape)
                .pack();
        return new BasicReq<MessageID>(packServer)
                .postForData("/send_private_msg", pack, PTR.messageID())
                .getMessage_id();
    }

    /**
     * 发送群消息
     * @param groupID 群号
     * @param msg 要发送的内容
     * @param autoEscape 推荐false, 消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
     * @return message_id，如果调用出现错误，返回null
     */
    public Integer sendGroupMsg(Long groupID, String msg, boolean autoEscape) {
        JSONObject pack = KVString.builder()
                .put("group_id", groupID).put("message", msg).put("auto_escape", autoEscape)
                .pack();
        return new BasicReq<MessageID>(packServer)
                .postForData("/send_group_msg", pack, PTR.messageID())
                .getMessage_id();
    }

    /**
     * 发送消息
     * @param isGroup 是否为群消息，true群消息，false私发消息
     * @param id 目标群号或者qq号
     * @param msg 要发送的内容
     * @param autoEscape 推荐false, 消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
     * @return message_id，如果调用出现错误，返回null
     */
    public Integer sendMsg(boolean isGroup, long id, String msg, boolean autoEscape) {
        JSONObject pack = KVString.builder()
                .put(isGroup?"group_id":"user_id", id).put("message", msg).put("auto_escape", autoEscape)
                .pack();
        return new BasicReq<MessageID>(packServer)
                .postForData("/send_msg", pack, PTR.messageID())
                .getMessage_id();
    }

    /**
     * 撤回消息
     * <p>注意，只能撤回群消息!</p>
     * @param msgID 消息 ID
     */
    public void deleteMsg(Integer msgID) {
        JSONObject pack = KVString.builder().put("message_id", msgID).pack();
        new BasicReq<>(packServer).post("/delete_msg", pack, PTR.empty());
    }

    /**
     * 获取消息相关信息
     * @param msgID 消息 ID
     * @return ResMessage
     */
    public ResMessage getMsg(Integer msgID){
        JSONObject pack = KVString.builder().put("message_id", msgID).pack();
        return new BasicReq<ResMessage>(packServer)
                .postForData("/get_msg", pack, PTR.resMessage());
    }

    /**
     * 获取图片相关信息
     * @param file 图片缓存文件名
     * @return ResImage
     */
    public ResImage getImage(String file){
        JSONObject pack = KVString.builder().put("file", file).pack();
        return new BasicReq<ResImage>(packServer)
                .postForData("/get_image", pack, PTR.resImage());
    }

    /**
     * 标记消息已读
     * @param msgID 消息ID
     */
    public void markMsgAsRead(Integer msgID) {
        JSONObject pack = KVString.builder().put("message_id", msgID).pack();
        new BasicReq<>(packServer)
                .post("/get_msg", pack, PTR.empty());
    }

    /**
     * 发送合并消息
     * @param groupID 群号
     * @param replyList  合并消息列表
     */
    public void sendGroupForwardMsg(Long groupID, List<ForwardReceiverReply> replyList) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", groupID);

        List<JSONObject> nodes = new ArrayList<>();
        for (ForwardReceiverReply reply:replyList) {
            JSONObject node = new JSONObject();
            node.put("type", "node");
            node.put("data", reply.getJSONObjectWithNoNull());
            nodes.add(node);
        }

        jsonObject.put("messages", nodes);

        new BasicReq<>(packServer).post("/send_group_forward_msg", jsonObject, PTR.empty());
    }

    /**
     * 获取合并转发的消息
     * @param msgID 合并消息 ID，注意不是通常的ID，
     *              需要通过{@link ForwardSenderReply}
     *              解析获得该id
     * @return ForwardMsg
     */
    public ForwardMsg getForwardMsg(String msgID){
        JSONObject pack = KVString.builder().put("message_id", msgID).pack();
        return new BasicReq<ForwardMsg>(packServer)
                .postForData("/get_forward_msg", pack, PTR.forwardMsg());
    }

}

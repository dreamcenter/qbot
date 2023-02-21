package top.dreamcenter.qbot.active;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.dreamcenter.qbot.entity.PackServer;
import top.dreamcenter.qbot.entity.act.Group;
import top.dreamcenter.qbot.entity.act.GroupMember;
import top.dreamcenter.qbot.util.BasicReq;
import top.dreamcenter.qbot.util.KVString;
import top.dreamcenter.qbot.util.PTR;

import java.util.List;

/**
 * 一些群组相关的管理
 * TODO 待测试
 */
@Component
public class GroupManageACT {

    @Autowired
    private PackServer packServer;

    /**
     * 群组踢人
     * @param groupID 群号
     * @param userID 要踢的 QQ 号
     * @param rejectAddRequest 是否拒绝此人的加群请求。推荐false
     */
    public void groupKick(long groupID, long userID, boolean rejectAddRequest) {
        JSONObject pack = KVString.builder()
                .put("group_id", groupID).put("user_id", userID).put("reject_add_request", rejectAddRequest)
                .pack();
        post("/set_group_kick", pack);
    }

    /**
     * 群组单人禁言
     * @param groupID 群号
     * @param userID 要禁言的 QQ 号
     * @param duration 禁言时长, 单位秒, 0 表示取消禁言
     */
    public void groupBan(long groupID, long userID, int duration) {
        post("/set_group_ban",KVString.builder()
                        .put("group_id", groupID).put("user_id", userID).put("duration", duration)
                        .pack());
    }

    // TODO
    public void groupAnonymousBan() {

    }

    /**
     * 群组全员禁言
     * @param groupID 群号
     * @param enable 是否禁言
     */
    public void groupWholeBan(long groupID, boolean enable) {
        post("/set_group_whole_ban", KVString.builder()
                .put("group_id", groupID).put("enable", enable)
                .pack());
    }

    /**
     * 群组设置管理员
     * @param groupID 群号
     * @param userID 要设置管理员的 QQ 号
     * @param enable true 为设置, false 为取消
     */
    public void setGroupAdmin(long groupID, long userID, boolean enable) {
        post("/set_group_admin", KVString.builder()
                .put("group_id", groupID).put("user_id", userID).put("enable", enable)
                .pack());
    }

    /**
     * 启用群组匿名。暂未支持
     */
    @Deprecated
    public void setGroupAnonymous() {

    }

    /**
     * 设置群名片 ( 群备注 )
     * @param groupID 群号
     * @param userID 要设置的 QQ 号
     * @param card 群名片内容, 不填或空字符串表示删除群名片
     */
    public void setGroupCard(long groupID, long userID, String card) {
        post("/set_group_card", KVString.builder()
                .put("group_id", groupID).put("user_id", userID).put("card", card)
                .pack());
    }

    /**
     * 设置群名
     * @param groupID 群号
     * @param groupName 新群名
     */
    public void setGroupName(long groupID, String groupName) {
        post("/set_group_name", KVString.builder()
                .put("group_id", groupID).put("group_name", groupName)
                .pack());
    }

    /**
     * 当前机器人qq退出群组
     * @param groupID 群号
     * @param isDismiss 是否解散, 如果登录号是群主, 则仅在此项为 true 时能够解散
     */
    public void groupLeave(long groupID, boolean isDismiss) {
        post("/set_group_leave", KVString.builder()
                .put("group_id", groupID).put("is_dismiss", isDismiss)
                .pack());
    }

    /**
     * 设置群组专属头衔
     * @param groupID 群号
     * @param userID 要设置的 QQ 号
     * @param specialTitle 专属头衔, 不填或空字符串表示删除专属头衔
     * @param duration 专属头衔有效期, 单位秒, -1 表示永久, 不过此项似乎没有效果, 可能是只有某些特殊的时间长度有效, 有待测试
     */
    public void setGroupSpecialTitle(long groupID, long userID, String specialTitle, int duration) {
        post("/set_group_special_title", KVString.builder()
                .put("group_id", groupID).put("user_id", userID)
                .put("special_title", specialTitle).put("duration", duration)
                .pack());
    }

    /**
     * 当前机器人群打卡群打卡
     * @param groupID 群号
     */
    public void groupSign(long groupID) {
        post("/send_group_sign", KVString.builder()
                .put("group_id", groupID).pack());
    }

    /**
     * 获取群信息
     * <p>提示 : 如果机器人尚未加入群, group_create_time, group_level, max_member_count 和 member_count 将会为0</p>
     * <p>这里提供了一个API用于获取群图片, group_id 为群号 https://p.qlogo.cn/gh/{group_id}/{group_id}/100</p>
     * @param groupID 群号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时, 但响应更快）,通常设置false
     * @return Group
     */
    public Group getGroupInfo(long groupID, boolean noCache) {
        return new BasicReq<Group>(packServer).postForData("/get_group_info",
                KVString.builder().put("group_id", groupID).put("no_cache", noCache).pack(), PTR.group());
    }

    /**
     * 获取群列表
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时, 但响应更快），通常设置为false
     * @return List<Group>
     */
    public List<Group> getGroupList(boolean noCache) {
        return new BasicReq<List<Group>>(packServer).postForData("/get_group_list",
                KVString.builder().put("no_cache", noCache).pack(), PTR.groups());
    }

    /**
     * 获取群成员信息
     * @param groupID 群号
     * @param userID QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时, 但响应更快），通常设为false
     * @return GroupMember
     */
    public GroupMember getGroupMemberInfo(long groupID, long userID, boolean noCache) {
        return new BasicReq<GroupMember>(packServer).postForData(
                "/get_group_member_info",
                KVString.builder().put("group_id", groupID).put("user_id", userID).put("no_cache", noCache).pack(),
                PTR.groupMember());
    }

    /**
     * 获取群成员列表
     * @param groupID 群号
     * @param noCache  是否不使用缓存（使用缓存可能更新不及时, 但响应更快），通常设为false
     * @return List<GroupMember>
     */
    public List<GroupMember> getGroupMemberList(long groupID, boolean noCache) {
        return new BasicReq<List<GroupMember>>(packServer).postForData("/get_group_member_list",
                KVString.builder().put("group_id", groupID).put("no_cache", noCache).pack(),
                PTR.groupMembers());
    }



    /**
     * 无消息返回post，更加简洁
     * @param uri uri
     * @param pack pack
     */
    private void post(String uri, JSONObject pack) {
        new BasicReq<>(packServer).post(uri, pack, PTR.empty());
    }
}

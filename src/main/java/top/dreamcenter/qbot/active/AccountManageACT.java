package top.dreamcenter.qbot.active;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.dreamcenter.qbot.entity.PackServer;
import top.dreamcenter.qbot.entity.account.Account;
import top.dreamcenter.qbot.entity.act.Friend;
import top.dreamcenter.qbot.entity.act.Stranger;
import top.dreamcenter.qbot.util.BasicReq;
import top.dreamcenter.qbot.util.KVString;
import top.dreamcenter.qbot.util.PTR;

import java.util.List;

/**
 * 一些账号相关的管理
 * TODO 待测试
 */
@Component
public class AccountManageACT {
    @Autowired
    private PackServer packServer;

    // TODO
    public void friendAddRequest () {}

    // TODO
    public void groupAddRequest () {}

    /**
     * 获取登录号信息
     * @return Account(user_id, nickname)
     */
    public Account getLoginInfo() {
        return new BasicReq<Account>(packServer).postForData("/get_login_info", null, PTR.account());
    }

    // TODO
    public void qiDianGetLoginInfo() {}

    /**
     * 设置登录号资料
     * @param nickname 名称
     * @param company 公司
     * @param email 邮箱
     * @param college 学校
     * @param personalNote 个人说明
     */
    public void setQQProfile(String nickname, String company, String email, String college, String personalNote) {
        post("/set_qq_profile", KVString.builder()
                .put("nickname", nickname).put("company", company).put("email", email)
                .put("college", college).put("personal_note", personalNote)
                .pack());
    }

    /**
     * 获取陌生人信息
     * @param user_id QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时, 但响应更快），通常设置false
     * @return Stranger
     */
    public Stranger getStrangerInfo(long user_id, boolean noCache) {
        return new BasicReq<Stranger>(packServer).postForData(
                "/get_stranger_info",
                KVString.builder().put("user_id", user_id).put("no_cache", noCache).pack(),
                PTR.stranger());
    }

    /**
     * 获取好友列表
     * @return List<Friend>
     */
    public List<Friend> getFriendList() {
        return new BasicReq<List<Friend>>(packServer).postForData("/get_friend_list",
                null, PTR.friends());
    }

    /**
     * 获取单向好友列表
     * @return List<Friend>
     */
    public List<Friend> getUnidirectionalFriendList() {
        return new BasicReq<List<Friend>>(packServer).postForData("/get_unidirectional_friend_list",
                null, PTR.friends());
    }

    /**
     * 删除好友
     * @param userID 好友 QQ 号
     */
    public void deleteFriend(long userID) {
        post("/delete_friend", KVString.builder().put("user_id", userID).pack());
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

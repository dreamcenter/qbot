package top.dreamcenter.qbot.entity.account;

import lombok.Data;
import lombok.ToString;
import top.dreamcenter.qbot.entity.account.Account;

/**
 * 群组内用户基本信息
 */
@Data
@ToString
public class GroupAccount extends Account {
    /**
     * 地域，通常获取不到，为 “”
     */
    private String area;
    /**
     * 群内备注
     */
    private String card;
    /**
     * 群内等级，通常获取不到，为 “”
     */
    private String level;
    /**
     * 群内角色
     * <p>  - “owner”   群主
     * <p>  - “admin”   管理员
     * <p>  - “member”  成员
     */
    private String role;
    /**
     * 群内个性化头衔
     */
    private String title;

}

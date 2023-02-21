package top.dreamcenter.qbot.entity.act;

import lombok.Data;

/**
 * 群成员
 */
@Data
public class GroupMember {

    /**
     * 群号
     */
    private Long group_id;

    /**
     * QQ 号
     */
    private Long user_id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 群名片／备注
     */
    private String card;

    /**
     * 性别, male 或 female 或 unknown
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地区
     */
    private String area;

    /**
     * 加群时间戳
     */
    private Integer join_time;

    /**
     * 最后发言时间戳
     */
    private Integer last_sent_time;

    /**
     * 成员等级
     */
    private String level;

    /**
     * 角色, owner 或 admin 或 member
     */
    private String role;

    /**
     * 是否不良记录成员
     */
    private Boolean unfriendly;

    /**
     * 专属头衔
     */
    private String title;

    /**
     * 专属头衔过期时间戳
     */
    private Long title_expire_time;

    /**
     * 是否允许修改群名片
     */
    private Boolean card_changeable;

    /**
     * 禁言到期时间
     */
    private Long shut_up_timestamp;
}

package top.dreamcenter.qbot.entity.act;

import lombok.Data;

/**
 * 群
 */
@Data
public class Group {

    /**
     * 群号
     */
    private Long group_id;

    /**
     * 群名称
     */
    private String group_name;

    /**
     * 群备注
     */
    private String group_memo;

    /**
     * 群创建时间
     */
    private Long group_create_time;

    /**
     * 群等级
     */
    private Long group_level;

    /**
     * 成员数
     */
    private Integer member_count;

    /**
     * 最大成员数（群容量）
     */
    private Integer max_member_count;

}

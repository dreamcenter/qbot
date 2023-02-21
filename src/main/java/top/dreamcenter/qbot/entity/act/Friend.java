package top.dreamcenter.qbot.entity.act;

import lombok.Data;

/**
 * 好友
 */
@Data
public class Friend {

    /**
     * QQ 号
     */
    private Long user_id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 备注名
     */
    private String remark;
}

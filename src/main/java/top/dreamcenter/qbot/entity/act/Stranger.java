package top.dreamcenter.qbot.entity.act;

import lombok.Data;

/**
 * 陌生人
 */
@Data
public class Stranger {

    /**
     * QQ 号
     */
    private Long user_id;

    /**
     * 	昵称
     */
    private String nickname;

    /**
     * 性别, male 或 female 或 unknown
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * qid ID身份卡
     */
    private String qid;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 登录天数
     */
    private Integer login_days;

}

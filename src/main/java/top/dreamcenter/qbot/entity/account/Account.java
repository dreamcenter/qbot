package top.dreamcenter.qbot.entity.account;

import lombok.Data;
import lombok.ToString;

/**
 * 用户基本信息
 */
@Data
@ToString
public class Account {
    /**
     * 账号，即QQ号
     */
    private Long user_id;
    /**
     * 年龄，通常获取不到，为0
     */
    private Integer age;
    /**
     * 昵称，用户个性昵称
     */
    private String nickname;
    /**
     * 性别，通常获取不到，为 “unknown”
     */
    private String sex;
}

package top.dreamcenter.qbot.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 匿名身份
 */
// {"flag":"E/K6CHHS4C1d62XhQ3Zl1YRqjGzyCMPgrsLAVjCaPSgtHbxtVJpqig==|狼人","name":"狼人","id":80000000}
@Data
@ToString
public class Anonymous {
    /**
     * id
     */
    private Long id;
    /**
     * flag
     */
    private String flag;
    /**
     * 匿名名称
     */
    private String name;
}

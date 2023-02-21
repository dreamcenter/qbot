package top.dreamcenter.qbot.entity;

import lombok.Data;

import java.util.Map;

@Data
public class RetResult<T> {
    /**
     * 状态, 表示 API 是否调用成功, 如果成功, 则是 OK, 其他的在下面会说明<p>
     * ok	api 调用成功<p>
     * async	api 调用已经提交异步处理, 此时 retcode 为 1, 具体 api 调用是否成功无法得知<p>
     * failed	api 调用失败
     */
    private String status;

    /**
     * 状态码<p>
     * 0	调用成功<p>
     * 1	已提交 async 处理<p>
     * 其他	操作失败, 具体原因可以看响应的 msg 和 wording 字段
     */
    private Integer retcode;

    /**
     * 错误消息, 仅在 API 调用失败时有该字段
     */
    private String msg;

    /**
     * 对错误的详细解释(中文), 仅在 API 调用失败时有该字段
     */
    private String wording;

    /**
     * 结果集
     */
    private T data;

    /**
     * '回声', 如果请求时指定了 echo, 那么响应也会包含 echo
     */
    private String echo;
}

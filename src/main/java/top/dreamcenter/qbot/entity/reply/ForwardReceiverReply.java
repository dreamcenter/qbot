package top.dreamcenter.qbot.entity.reply;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 合并转发消息节点
 *<p>
 * 需要使用单独的API /send_group_forward_msg 发送,
 * 并且由于消息段较为复杂, 仅支持Array形式入参。
 *
 * 如果引用消息和自定义消息同时出现, 实际查看顺序将取消息段顺序.
 *
 * 另外按 Onebot v11 文档说明, data 应全为字符串, 但由于需要接收message 类型的消息,
 * 所以 仅限此Type的content字段 支持Array套娃
 *
 * <p> 更多详情参考 https://docs.go-cqhttp.org/cqcode/#合并转发消息节点 </p>
 */
@Data
public class ForwardReceiverReply extends Reply{

    /**
     * 转发消息id
     * <p> 直接引用他人的消息合并转发, 实际查看顺序为原消息发送顺序 <b>与下面的自定义消息二选一</b> </p>
     */
    private Integer id;

    /**
     * 发送者显示名字
     * <p> 用于自定义消息 (自定义消息并合并转发, 实际查看顺序为自定义消息段顺序) </p>
     */
    private String name;

    /**
     * 发送者QQ号
     * <p> 用于自定义消息 </p>
     */
    private Long uin;

    /**
     * 具体消息
     * <p> 用于自定义消息 不支持转发套娃 </p>
     */
    private String content;

    /**
     * 具体消息
     * <p> 用于自定义消息 </p>
     */
    private String seq;

    /**
     * 对指定id消息合并
     * @param id 消息id
     */
    public ForwardReceiverReply(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param name 昵称
     * @param uin id
     * @param content 内容
     * @param seq 内容？不是很懂。
     */
    public ForwardReceiverReply(String name, Long uin, String content, String seq) {
        this.name = name;
        this.uin = uin;
        this.content = content;
        this.seq = seq;
    }

    /**
     * 自定义合并消息
     * @param name 昵称
     * @param uin qq
     * @param content 内容
     */
    public ForwardReceiverReply(String name, Long uin, String content) {
        this.name = name;
        this.uin = uin;
        this.content = content;
    }

    /**
     * 将该对象转化为json对象，去除null字段
     * @return jsonObject
     */
    public JSONObject getJSONObjectWithNoNull() {
        JSONObject jsonObject = new JSONObject();
        if (id != null) {
            jsonObject.put("id", id);
        } else {
            jsonObject.put("name", name);
            jsonObject.put("uin", uin);
            jsonObject.put("content", content);
            if (seq !=null) jsonObject.put("seq", seq);
        }
        return jsonObject;
    }
}

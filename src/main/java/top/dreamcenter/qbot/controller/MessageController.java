package top.dreamcenter.qbot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dreamcenter.qbot.entity.message.GroupMessage;
import top.dreamcenter.qbot.entity.message.PrivateMessage;
import top.dreamcenter.qbot.entity.reply.Reply;
import top.dreamcenter.qbot.service.MessageService;

/**
 * 详细处理消息
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    /**
     * 群消息
     * @param message 群消息数据
     * @return Reply
     */
    @PostMapping("/group")
    public Reply handleGroupMsg(@RequestBody GroupMessage message){
        return service.handleGroupMsg(message);
    }

    /**
     * 私发消息
     * @param message 私发消息数据
     * @return Reply
     */
    @PostMapping("/private")
    public Reply handlePrivateMsg(@RequestBody PrivateMessage message){
        return service.handlePrivateMsg(message);
    }

}

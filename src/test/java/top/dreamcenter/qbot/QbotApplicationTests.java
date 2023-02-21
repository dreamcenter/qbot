package top.dreamcenter.qbot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dreamcenter.qbot.active.MsgACT;
import top.dreamcenter.qbot.entity.reply.ForwardReceiverReply;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class QbotApplicationTests {

    @Autowired
    private MsgACT act;

    @Test
    void contextLoads() {
    }

    @Test
    void sendMsgACT(){
        // 傻子栖息地 651242913
//        act.sendPrivateMsg(1981669259L,651242913,"act", false);
//        act.sendGroupMsg(651242913L,"act", false);
//        Integer msgID = act.sendMsg(false, 1981669259L, "666", false);
//        act.deleteMsg(msgID);
//        System.out.println(act.getMsg(msgID));
//        System.out.println(act.getImage("d5b8319a72649ed9d34cf3c66221d5cc.image"));
//        System.out.println(act.getMsgs(-31269989));
        List<ForwardReceiverReply> list = new ArrayList<>();
        list.add(new ForwardReceiverReply(10));
        list.add(new ForwardReceiverReply("dai",1981669L,"hi","123"));
        act.sendGroupForwardMsg(123456L, list);
    }


}

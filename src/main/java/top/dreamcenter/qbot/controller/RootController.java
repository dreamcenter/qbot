package top.dreamcenter.qbot.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.dreamcenter.qbot.entity.reply.Reply;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 根路径，对所有反向http的请求数据进行重分发。
 * <p> 对于回复如果为null，或者不是正确的回复格式，都不会触发回复
 */
@RestController
public class RootController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dreamcenter.serverAddr}")
    private String ROOT_URL;

    /**
     * 根，获取所有的与go-cqhttp发来的数据
     * @param request req
     * @return Reply
     */
    @RequestMapping("/")
    public Reply root(HttpServletRequest request) {
        try (BufferedReader reader = request.getReader()) {
            String body = reader.readLine();
            if (body != null) {
                JSONObject raw = JSONObject.parseObject(body);
                return distribute(raw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 原始反向http数据分发
     * @param raw body的json数据，具体的不同json结构参考官方Event事件部分的API
     * @return Reply
     */
    private Reply distribute(JSONObject raw) {
        String post_type = raw.getString("post_type");
        Reply result = null;
        switch (post_type) {
            case "meta_event":
                // 一些元事件上报会在这里，比如心跳情况
                // {"post_type":"meta_event","meta_event_type":"heartbeat","time":1676726616,"self_id":3350214881,"status":{"app_enabled":true,"app_good":true,"app_initialized":true,"good":true,"online":true,"plugins_good":null,"stat":{"packet_received":36,"packet_sent":28,"packet_lost":0,"message_received":0,"message_sent":0,"last_message_time":0,"disconnect_times":0,"lost_times":0}},"interval":5000}
            case "request":
                // 一些请求上报会在这里
            case "notice":
                // 一些通知上报会在这里
                // {"post_type":"notice","notice_type":"group_admin","time":1676728852,"self_id":3350214881,"sub_type":"unset","group_id":651242913,"user_id":1733785008}
                break;
            case "message":{
                // 一些消息上报会在这里
                result = handleMessage(raw);
                break;
            }
            default:
                System.out.println("new type found : " + post_type + "/" + raw);
        }
        return result;
    }

    /**
     * 处理message类别数据
     * @param raw body数据
     * @return Reply
     */
    private Reply handleMessage(JSONObject raw) {
        String messageType = raw.getString("message_type");
        Reply msg = null;

        if ("private".equals(messageType)) {
            msg = restTemplate.postForObject(ROOT_URL + "/message/private",raw,Reply.class);
        } else if ("group".equals(messageType)) {
            msg = restTemplate.postForObject(ROOT_URL + "/message/group",raw,Reply.class);
        } else {
            System.out.println("new type found : " + messageType + "/" + raw);
        }

        return msg;
    }
}

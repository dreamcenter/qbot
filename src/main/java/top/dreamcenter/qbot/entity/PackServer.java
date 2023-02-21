package top.dreamcenter.qbot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

/**
 * 将服务器地址与template绑定，
 * 以便于发送请求
 */
@Data
@AllArgsConstructor
public class PackServer {
    /**
     * restTemplate
     */
    private RestTemplate template;

    /**
     * 服务器地址，例如 http://127.0.0.1:5700
     */
    private String server;
}

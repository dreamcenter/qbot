package top.dreamcenter.qbot.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "dreamcenter")
public class ServerProperties {
    /**
     * 机器人服务器带端口地址，最后不含斜杠
     * <p> 如 http://127.0.0.1:5700 </p>
     */
    private String botServerAddr;

    /**
     * springboot工程的服务器带短裤地址，最后不含斜杠
     * <p> 如 http://127.0.0.1:5701 </p>
     */
    private String serverAddr;
}

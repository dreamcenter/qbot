package top.dreamcenter.qbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.dreamcenter.qbot.entity.ServerProperties;

/**
 * 本项目用于qq机器人脚手架搭建
 *
 * <p> go-cqhttp 原始文档 https://docs.go-cqhttp.org/
 *
 * @author Dai
 *
 */
@SpringBootApplication
@EnableConfigurationProperties({ServerProperties.class})
public class QbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(QbotApplication.class, args);
    }

}

package top.dreamcenter.qbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import top.dreamcenter.qbot.active.AccountManageACT;
import top.dreamcenter.qbot.entity.PackServer;
import top.dreamcenter.qbot.service.MessageService;
import top.dreamcenter.qbot.service.impl.MessageServiceExampleImpl;

@Configuration
public class BeanRegister {

    @Value("${dreamcenter.botServerAddr}")
    private String SERVER;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PackServer packServer(RestTemplate restTemplate) {
        return new PackServer(restTemplate, SERVER);
    }

    @Bean
    @ConditionalOnMissingBean(MessageService.class)
    public MessageServiceExampleImpl messageServiceExampleImpl(AccountManageACT accountManageACT) {
        return new MessageServiceExampleImpl(accountManageACT);
    }

}

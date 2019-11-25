package study.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//该类为Ribbon配置类
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        //负载均衡规则改为随机
        return new RandomRule();
    }
}

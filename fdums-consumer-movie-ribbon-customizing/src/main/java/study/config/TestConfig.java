package study.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

//使用RibbonClient，为特定name的Ribbon Client自定义配置
//使用@RibbonClient的configuration属性指定Ribbon的配置类
@Configuration
@RibbonClient(name = "fdums-provider-user-lfy", configuration = RibbonConfig.class)

public class TestConfig {
}

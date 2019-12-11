package study.feign;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//该类为Feign的配置类
//该类不该在主应用程序上下文的@CompantScan中
@Configuration
public class FeignConfiguration {

    //用feign.Contract.Default替换SpringMvcContract契约
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}

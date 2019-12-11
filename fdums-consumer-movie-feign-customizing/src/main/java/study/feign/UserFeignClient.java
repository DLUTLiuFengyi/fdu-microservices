package study.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.entity.User;

//修改Feign接口
//使用@FeignClient的configuration属性指定配置类
//将findById上的Spring MVC注解修改为Feign自带的注解
@FeignClient(name="fdums-provider-user-lfy", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    //使用feign自带的注解@RequestLine
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}

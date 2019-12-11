package study.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.entity.User;

@FeignClient(name="fdums-provider-user-lfy")
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    User findById(@PathVariable("id") Long id);
}

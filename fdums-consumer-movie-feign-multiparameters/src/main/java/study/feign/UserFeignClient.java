package study.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import study.entity.User;

import java.util.Map;

//使用Feign构造多参数
@FeignClient(name="fdums-provider-user-lfy")
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User get1(@RequestParam("id") Long id,@RequestParam("username") String username);

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User get2(@RequestParam Map<String,Object> map);
}

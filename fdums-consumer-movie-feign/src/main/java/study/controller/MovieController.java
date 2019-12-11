package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.entity.User;
import study.feign.UserFeignClient;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
        //return this.restTemplate.getForObject("http://fdums-provider-user-lfy/" + id, User.class);
        return this.userFeignClient.findById(id);
    }
}

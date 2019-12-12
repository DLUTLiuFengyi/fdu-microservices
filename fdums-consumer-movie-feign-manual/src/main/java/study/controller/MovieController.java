package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.entity.User;
import study.feign.UserFeignClient;
import feign.codec.Decoder;
import feign.codec.Encoder;
//import java.beans.Encoder;

@Import(FeignClientsConfiguration.class)

@RestController
public class MovieController {

    private UserFeignClient userUserFeignClient;
    private UserFeignClient adminUserFeignClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userUserFeignClient = Feign.builder().client(client).encoder((feign.codec.Encoder) encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user","password123"))
                .target(UserFeignClient.class,"http://fdums-provider-user-lfy");
        this.adminUserFeignClient = Feign.builder().client(client).encoder((feign.codec.Encoder) encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","password123"))
                .target(UserFeignClient.class,"http://fdums-provider-user-lfy");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
        //return this.restTemplate.getForObject("http://fdums-provider-user-lfy/" + id, User.class);
        return this.userUserFeignClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
        //return this.restTemplate.getForObject("http://fdums-provider-user-lfy/" + id, User.class);
        return this.adminUserFeignClient.findById(id);
    }
}

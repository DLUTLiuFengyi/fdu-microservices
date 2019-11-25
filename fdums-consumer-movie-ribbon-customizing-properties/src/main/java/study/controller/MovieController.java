package study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.entity.User;

@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
        return this.restTemplate.getForObject("http://fdums-provider-user-lfy/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        MovieController.LOGGER.info("{}","loginfo");
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("fdums-provider-user-lfy");
        //打印当前节点
        MovieController.LOGGER.info("{}","loginfo");
        MovieController.LOGGER.info("{}:{}:{}",
                serviceInstance.getServiceId(),
                serviceInstance.getHost(),
                serviceInstance.getPort());
    }
}

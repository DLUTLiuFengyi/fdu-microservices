package study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.entity.User;
import study.repository.UserRepository;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        //打印当前的用户信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for(GrantedAuthority c : collection){
                //打印当前登陆用户信息
                UserController.LOGGER.info("The current user is {}, his role is {}",user.getUsername(),c.getAuthority());
            }
        }else{
            //do other things
        }
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }
}

package com.example.hroauth.services;

import com.example.hroauth.entities.User;
import com.example.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(user)) {
            logger.warning("Email Not found = " + email);

//            throw new IllegalArgumentException("Email not found");
            throw new UsernameNotFoundException("Email not found");
        }

        logger.info("Email Found = " + user.getEmail());
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.findByEmail(email);
    }
}

package com.cinevibe.configs;

import com.cinevibe.models.supclass.User;
import com.cinevibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputEmail-> {
            User user = userRepository.findByEmail(inputEmail).orElseThrow(() -> new UsernameNotFoundException("Unknown user email: " + inputEmail));

            if (user.getEmail().endsWith("@admin.cinevibe.com")) {
                return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
            } else if (user.getEmail().endsWith("@staff.cinevibe.com")) {
                return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE"));
            } else {
                return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_CUSTOMER"));
            }


        }).passwordEncoder(passwordEncoder());
    }
}
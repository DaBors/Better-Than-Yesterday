package com.base.betterthanyesterday.Configuration;

import com.base.betterthanyesterday.BeanManager.ProfileManager;
import com.base.betterthanyesterday.BeanManager.ProfileRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaRepositories(basePackageClasses = ProfileRepository.class)
public class ApplicationCongifuration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ProfileManager profileManager() {
        return new ProfileManager();
    }
}
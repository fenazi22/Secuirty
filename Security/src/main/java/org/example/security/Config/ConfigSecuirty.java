package org.example.security.Config;

import lombok.RequiredArgsConstructor;
import org.example.security.Service.MyUserDeailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity// اسمح ان يشتغل السكيورتي على الويب
@RequiredArgsConstructor
public class ConfigSecuirty {
    private final MyUserDeailsService myUserDeailsService;

    //DaoAuthentication لتحقق للباسورد  وتحقق عن طريق Service //
    //UserDetailsService يشيك على اليوزر
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDeailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
    return daoAuthenticationProvider;
    }



}

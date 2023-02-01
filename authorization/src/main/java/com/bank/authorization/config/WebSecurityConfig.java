package com.bank.authorization.config;

import com.bank.authorization.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SuccessUserHandler successUserHandler;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfig(SuccessUserHandler successUserHandler, UserDetailsServiceImpl userDetailsService) {
        this.successUserHandler = successUserHandler;
        this.userDetailsService = userDetailsService;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //Отключение csrf-token (cross-site request forgery)
                .authorizeRequests()
//                .antMatchers("/api/auth","/login", "/api/auth/login", "/api/auth/error").permitAll()
//                .antMatchers("/api/auth/users/**").hasRole("ADMIN")
//                .antMatchers("/api/auth/userView/**").hasAnyRole("USER", "ADMIN")
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
//                .and()
//                .formLogin().successHandler(successUserHandler).permitAll()
                .and()
                .logout().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        auth.authenticationProvider(provider);
    }

}

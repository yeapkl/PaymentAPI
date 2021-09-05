package com.yeapkl.config;

/**
 * Created by yeap.kwan.lin on 9/2/2021.
 */
import com.yeapkl.handler.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
            .withUser("yeapkl")
                .password(encoder.encode("yeapkl")).roles("USER")
                .and()
                .withUser("test")
                .password(encoder.encode("test")).roles("TEST");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/getByCustomerId/**").hasRole("USER")
            .antMatchers(HttpMethod.GET, "/getByAccountNumber/**").hasRole("USER")
            .antMatchers(HttpMethod.GET, "/getByDescription/**").hasRole("USER")
            .and()
            .csrf().disable()
            .formLogin().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                ;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}

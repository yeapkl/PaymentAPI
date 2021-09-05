package com.yeapkl.config;

/**
 * Created by yeap.kwan.lin on 9/2/2021.
 */
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
            .withUser("yeapkl")
                .password(encoder.encode("yeapkl")).roles("USER");

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
            .formLogin().disable();
    }
}

package com.example.apiprueba;

import com.example.apiprueba.modelo.servicios.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigureWebSecurity extends WebSecurityConfigurerAdapter {

    private final UserDetailsService elmeuUserDetailsService;
    private final PasswordEncoder xifrat;

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().anyRequest();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(elmeuUserDetailsService).passwordEncoder(xifrat);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //per poder accedir al h2-console
                //  .authorizeRequests().antMatchers("/").permitAll().and()
                //  .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                // .and()
                .csrf().disable()
                // .headers().frameOptions().disable()
                // .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

}

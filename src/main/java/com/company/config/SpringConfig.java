package com.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Authentication
        auth.inMemoryAuthentication()
                .withUser("Ali").password("{bcrypt}$2a$10$V93CWoH3NxAPC7VzPd9ouuU8PWvZWYdoo94H3HOZ8kFSkBAvYssEe").roles("ADMIN")
                .and()
                .withUser("Vali").password("{noop}valish123").roles("PROFILE");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //Authentication
    //super.configure(auth);

    //        auth.inMemoryAuthentication()
//                .withUser("Ali").password("{noop}alish123").roles("ADMIN").and()
//                .withUser("Vali").password("{noop}valish123").roles("USER");
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        http.authorizeRequests()
                .antMatchers("/home", "/home/*").permitAll()
                .antMatchers("/profile", "/profile/*").hasAnyRole("PROFILE", "ADMIN")
                .antMatchers("/admin", "/admin/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}

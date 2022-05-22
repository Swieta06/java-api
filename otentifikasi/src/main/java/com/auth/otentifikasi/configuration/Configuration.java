package com.auth.otentifikasi.configuration;
import com.auth.otentifikasi.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;
    //authentication=for who are u
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          //this code for db (add JpaUserDetailsService on package service and jpausersdetail on package dto)
        auth.userDetailsService(jpaUserDetailsService);

        
        //this code only run in internal memory or on your pc
       /* auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("admin")
                .and()
                .withUser("customer")
                .password("password")
                .roles("customer"); */
    }

    //authorization=what u can access with
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/api/user/getAllAdmin").hasRole("ADMIN")
               .antMatchers("/api/user/getAllCustomer").hasAnyRole("CUSTOMER","ADMIN")
               .anyRequest().permitAll()
               .and().formLogin();
    }
     //harus ada ini
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}

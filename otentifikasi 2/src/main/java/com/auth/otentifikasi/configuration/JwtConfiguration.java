package com.auth.otentifikasi.configuration;
import com.auth.otentifikasi.filter.JwtAuthenticationFilter;
import com.auth.otentifikasi.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;
    //add JwtAuthenticationEntryPoint at configuration
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthEntryPoint;
    //
    @Autowired
    private JwtAuthenticationFilter jwtFilter;

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
    // add http.csrf().disable()
    //               .cors().disable() before authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /* http.csrf().disable()
               .cors().disable()
               .authorizeRequests()
               .antMatchers("/api/user/create").permitAll()
               .antMatchers("/api/user/getAllAdmin").hasRole("ADMIN")
               .antMatchers("/api/user/getAllCustomer").hasAnyRole("CUSTOMER","ADMIN")
               .anyRequest().permitAll();
              // .and().formLogin();*/


        //jwt configure
        http.csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/api/user/login", "/api/user/register").permitAll() // allow this endpoint without authentication
                .anyRequest().authenticated() // for any other request, authentication should be performed
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // every request should be independent of other and server does not have to manage session
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

     //bcryptpass(add some code in userserviceimpl)
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

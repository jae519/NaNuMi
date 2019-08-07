package kr.or.kftc.jaehuyn.Nanumi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 
 @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

     // Users in memory.

     auth.inMemoryAuthentication().withUser("jaehyun").password("jaehyun").roles("USER");
     auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER, ADMIN");

 }

 @Override
 protected void configure(HttpSecurity http) throws Exception {

     http.csrf().disable();

     // The pages does not require login
     http.authorizeRequests().antMatchers("/login", "/logout").permitAll();

     // /board page requires login as USER or ADMIN.
     // If no login, it will redirect to /login page.
     http.authorizeRequests().antMatchers("/","/board").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

     // For ADMIN only.
     //http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

     // When the user has logged in as XX.
     // But access a page that requires role YY,
     // AccessDeniedException will throw.
     http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

     // Config for Login Form
     http.authorizeRequests().and().formLogin()//
             // Submit URL of login page.
             .loginProcessingUrl("/j_spring_security_check") // Submit URL
             .loginPage("/login")//
             .defaultSuccessUrl("/userInfo")//
             .failureUrl("/login?error=true")//
             .usernameParameter("username")//
             .passwordParameter("password")
             // Config for Logout Page
             .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

 }
}

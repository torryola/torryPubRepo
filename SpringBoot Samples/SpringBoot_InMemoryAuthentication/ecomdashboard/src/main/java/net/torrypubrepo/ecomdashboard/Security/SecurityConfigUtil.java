package net.torrypubrepo.ecomdashboard.Security;

import net.torrypubrepo.ecomdashboard.Controller.LoginAccessDeniedHandler;
import net.torrypubrepo.ecomdashboard.Controller.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 Created by Toriola
 Security Configuration for Controlling access to the dashboard.
 There will be 2 categories of Users
 - Admin : for Big Bosses
 - Manager : for branch Managers
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigUtil extends WebSecurityConfigurerAdapter
{
    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    LoginAccessDeniedHandler loginAccessDeniedHandler;
    /*
     This configure is used to create users login details and attached to roles
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        //PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("admin")
                //.password(passwordEncoder.encode("admin01")) // Use Password Encoder for it to work
                .password(passwordEncoder().encode("admin01")) // Without password encoder
                .roles("ADMIN")
                .and()
        .withUser("manager").password(passwordEncoder().encode("manager01")).roles("MANAGER");
    }

    /*
    Configuration for restricting access to each controllers
    E.g. Admin page requires Admin roles otherwise Fail
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**")
                .permitAll()
                //.antMatchers("**/dashboard/**")
                .antMatchers("/", "/index", "/index.html", "/home").hasRole("ADMIN")
                .antMatchers("/branches", "/branches/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(loginSuccessHandler)
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(loginAccessDeniedHandler);
      /* http.csrf().disable()
               .authorizeRequests()
               .anyRequest()
               .authenticated()
               .and()
               .formLogin()
               .and()
               .httpBasic();
        */
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  PasswordEncoderFactories.createDelegatingPasswordEncoder(); //BCryptPasswordEncoder();
    }
}

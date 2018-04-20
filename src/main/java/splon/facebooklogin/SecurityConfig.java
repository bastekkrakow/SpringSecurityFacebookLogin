package splon.facebooklogin;


import splon.facebooklogin.models.SecureUserDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final SecureUserDetailsModel userDetailsModel;

    @Autowired
    public SecurityConfig(SecureUserDetailsModel userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/content")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers("/")
                .permitAll()
                  .and()
                .formLogin()
                .passwordParameter("password")
                .usernameParameter("login")
                .loginPage("/login")
                  .and()
                .csrf().disable()
                .exceptionHandling()
                .accessDeniedPage("/permission");
        //http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        ShaPasswordEncoder encoder  = new ShaPasswordEncoder();
        auth.userDetailsService(userDetailsModel).passwordEncoder(encoder);


    }




}

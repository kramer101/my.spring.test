package my.spring.test.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebSecurity
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Config extends WebSecurityConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.inMemoryAuthentication()
                .withUser("hr").password("hr").roles("hr")
                .and()
                .withUser("admin").password("admin").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //.exceptionHandling()
                //.and()
                .authorizeRequests()
                .antMatchers("/api", "/api/**").authenticated()
                .and()
                .formLogin().loginPage("/web/login.xhtml")
                .defaultSuccessUrl("/api")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/web/login.xhtml").permitAll();;
    }




}

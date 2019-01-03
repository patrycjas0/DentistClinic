package pl.psipko.DentistClinic.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = { SecurityConfig.class })
////@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource= new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        // adjust the following to your environment
//        dataSource.setUrl("jdbc:h2://localhost:8999/h2-console");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//        return dataSource;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    String[] recources={"/resources/**", "/registration/**","/registration/css/**","/registration/js/**","/registration/less/**","/css/**", "/fonts/**","/js/**","/login**","/login/css/**",
            "/login/fonts/**","/login/images/icons/**","/login/vendor/**","/login/css/**","/img/**",
            "/images/**","/h2-console/**"};

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(recources);
    }

    // sample users
    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT user, password, enabled FROM Patient where user=?")
                .authoritiesByUsernameQuery("SELECT user,role, enabled FROM Patient where user=?");

//        auth.inMemoryAuthentication()
//              //  .passwordEncoder(passwordEncoder())
//                .withUser("admin").password("{noop}dupa").roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/registration","/h2-console/**","/h2-console/login/**","/services", "/resources/**", "/about", "/public/**","/doctors","/contact","/lo").permitAll()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .antMatchers("/all-patient/**").hasRole("ADMIN")
                .antMatchers("/userPage","/h2-console/**").hasRole("USER")
                .anyRequest().authenticated()
                  .and()
                  .formLogin()
                .loginPage("/lo")
                .usernameParameter("user")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .permitAll()
                .defaultSuccessUrl("/success", true)
                .and()
                .logout()
                .logoutSuccessUrl("/");

    }
}
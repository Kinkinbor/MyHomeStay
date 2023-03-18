package garlance.front.config.SpringSecurity;

import garlance.front.serve.entity.UserEntity;
import garlance.front.serve.service.Impl.MyUserDetailsServiceImpl;
import garlance.front.serve.service.Impl.UserServiceImpl;
import garlance.front.serve.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/header").permitAll()
                .antMatchers("/footer").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/sms/sendCode").permitAll()
                .antMatchers("/sms/smsLogin").permitAll()
                .antMatchers("/getHouseListToJson").permitAll()
                .anyRequest().authenticated();
        http.formLogin().usernameParameter("fname").passwordParameter("fpassword").loginPage("/login").loginProcessingUrl("/loginHandling").permitAll().defaultSuccessUrl("/",true).permitAll();
        //配置session生成策略，前后端分离的项目使用STATELESS(只生成一次session)，前后端不分离的项目设置ALWAYS(总是生成session)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        //启用注销功能
        http.logout()
                .logoutUrl("/logout")   //设置登出路由
                .invalidateHttpSession(true) //是否使session无效 默认为true
                .clearAuthentication(true)   //是否清楚认证信息，默认为true
                .logoutSuccessUrl("/");      //注销登录之后的跳转地址
        //开启记住我功能
        http.rememberMe()
                .rememberMeParameter("remember"); //记住我的参数是remember，默认有效期是14天
        http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据正常应从数据库中读入
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    //创建BCryptPasswordEncoder注入容器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

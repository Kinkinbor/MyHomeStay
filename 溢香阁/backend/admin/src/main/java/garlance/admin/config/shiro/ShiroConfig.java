package garlance.admin.config.shiro;

import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    //引入之前定义好的域
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    //配置一个安全管理器
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        MyRealm myRealm = myRealm();
        //将我们配置好的密码校验放在域中
        myRealm.setCredentialsMatcher(myRealm.getCredentialsMatcher());
        //将域添加到我们的安全管理器中
        manager.setRealm(myRealm);
        //设置Session管理器，配置shiro中session的持续时间
        manager.setSessionManager(getDefaultWebSessionManager());
        return manager;
    }

    //设置内存层的session
    @Bean
    public MemorySessionDAO getMemorySessionDAO(){
        return new MemorySessionDAO();
    }

    //引入密码校验
    @Bean
    public MyCredentialsMatcher myCredentialsMatcher(){
        return new MyCredentialsMatcher();
    }

    //设置session过期时间
    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager(){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setGlobalSessionTimeout(1000 * 60 * 60);// 会话过期时间，单位：毫秒---> 一小时
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        defaultWebSessionManager.setSessionDAO(getMemorySessionDAO());
        return defaultWebSessionManager;
    }

    //设置访问拦截器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //传入安全管理器
        bean.setSecurityManager(securityManager());
        //传入未登录用户访问登录用户的权限所跳转的页面
        bean.setLoginUrl("/login");
        //设置成功后返回页面
        bean.setSuccessUrl("/index");

   /*
        anon:无需认证可以访问
        authc:必须认证才能访问
        user:必须拥有记住我功能才能访问
        perms:拥有对某个资源的权限才能访问
        role:拥有某个角色权限才能访问
        */

        //访问未授权网页所跳转的页面
//        bean.setUnauthorizedUrl("/unauthorized");
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //允许  需要设置login为anon，否则登录成功以后无法跳转
        map.put("/images/**", "anon");
        map.put("/img/**", "anon");
        map.put("/static/**", "anon");
        map.put("/html/**", "anon");
        map.put("/css/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/js/**", "anon");
        map.put("/lib/**", "anon");
        map.put("/favicon.ico", "anon");

        map.put("/login.html","anon");
        map.put("/login","anon");


        //设置所有的请求未登录不允许进入
        map.put("/**","authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
}

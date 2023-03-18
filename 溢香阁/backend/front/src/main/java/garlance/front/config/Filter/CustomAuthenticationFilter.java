//package garlance.front.config.Filter;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    public CustomAuthenticationFilter(String defaultFilterProcessesUrl) {
//        super(defaultFilterProcessesUrl);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String phoneNumber = request.getParameter("phoneNumber");
//        String smsCode = request.getParameter("smsCode");
//
//        // 判断是用户名密码登录还是手机号验证码登录
//        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
//            return this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } else if (StringUtils.isNotBlank(phoneNumber) && StringUtils.isNotBlank(smsCode)) {
//            return this.getAuthenticationManager().authenticate(new SmsCodeAuthenticationToken(phoneNumber, smsCode));
//        } else {
//            throw new BadCredentialsException("Invalid authentication request");
//        }
//    }
//}
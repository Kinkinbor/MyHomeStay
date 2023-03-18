//package garlance.front.config.SpringSecurity;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.*;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MyLoginUrlAuthenticationEntryPoint implements AuthenticationEntryPoint{
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        httpServletResponse.setStatus(200);
//        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = httpServletResponse.getWriter();
//        Map<String,Object> resultData = new HashMap<>();
//        resultData.put("code","401");
//        resultData.put("msg", "未登陆");
//        out.write(new ObjectMapper().writeValueAsString(resultData));
//        out.flush();
//        out.close();
//    }
//}

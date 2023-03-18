package garlance.front.config.Swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 *
 * @author Garlance
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig extends SuperSwaggerConfig{

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                //设置Swagger扫描的Controller路径，只有扫描到了才会生成接口文档
                .apiBasePackage("com.example.bootswagger.controller")
                .title("swagger测试")
                .description("后台接口文档")
                .contactName("wranglings")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}

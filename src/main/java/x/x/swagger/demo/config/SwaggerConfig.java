package x.x.swagger.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Swagger配置
 */
@Configuration
public class SwaggerConfig {

    /**
     * 配置swagger的Docket bean
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(createApiInfo());
    }

    @Bean
    public ApiInfo createApiInfo() {
        return new ApiInfo(
                "LeDao Swagger3",
                "LeDao Api文档",
                "3.0",
                "https://blog.zoutl.cn",
                new Contact("LeDao", "https://blog.zoutl.cn", "f110@gmail.com"),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
package com.avalon.excelplan.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * swagger 接口文档设置
 */
@Configuration
@EnableKnife4j
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("excel-plan").version("1.0.0").description("excel-plan")
                .contact(new Contact("no", "", "")).build();

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).enable(true).groupName("excel-plan").select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.avalon.excelplan.controller"))
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

}
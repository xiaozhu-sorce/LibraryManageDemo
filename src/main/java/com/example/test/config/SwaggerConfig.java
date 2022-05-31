package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
     * Docket 是 DocumentLet 的缩写, 相当于摘要
     */
    @Bean
    public Docket createRestApi() {
        Docket docklet = new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData())
                .select()
                // apis() 作用是通过 basePackage 或 withClassAnnotation 来指定swagger扫描的类的范围
                .apis(RequestHandlerSelectors.basePackage("com.example.test.controller"))
                // paths() 是通过路径的方式来指定swagger扫描的类的范围
                .paths(PathSelectors.any())
                .build();

        return docklet;
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Library")
                .description("图书管理系统")
                .contact(new Contact("xiaozhu-sorce", "http://about.me", "790362227@qq.com"))
                .version("1.0")
                .build();
    }
}

/*
 *
 * //如果集成了 Spring Security , 需要加一个Spring Security配置类允许访问 swagger 相关资源
 *
 * @Configuration public class SpringSecConfig extends
 * WebSecurityConfigurerAdapter {
 *
 * @Override protected void configure(HttpSecurity httpSecurity) throws
 * Exception {
 * httpSecurity.authorizeRequests().antMatchers("/","/swagger-resources").
 * permitAll(); httpSecurity.csrf().disable();
 * httpSecurity.headers().frameOptions().disable(); } }
 */
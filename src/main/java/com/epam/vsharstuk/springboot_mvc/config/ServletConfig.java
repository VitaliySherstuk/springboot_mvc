package com.epam.vsharstuk.springboot_mvc.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer {

  /*  @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getResourceBundle() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("message");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    /*@Bean(name = "localeResolver")
    public CookieLocaleResolver getLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName("lang");
        localeResolver.setCookieMaxAge(100000);
        return localeResolver;
    }

    @Bean(name = "localeChangeInterceptor")
    public LocaleChangeInterceptor getLocaleChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocaleChangeInterceptor());
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver getMultipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public Validator getValidate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photo/**").addResourceLocations("file:///D:/photo/");
    }
*/
}

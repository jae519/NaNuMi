package kr.or.kftc.jaehuyn.Nanumi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("kr.or.kftc.jaehuyn.Nanumi.*")
public class ApplicationContextConfig {
 

  @Autowired
  private Environment env;
 
  //@Autowired
  //private UserInfoDAO userInfoDAO;
 
  @Bean
  public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
      // Load property in message/validator.properties
      rb.setBasenames(new String[] { "messages/validator" });
      return rb;
  }
 
  @Bean(name = "viewResolver")
  public InternalResourceViewResolver getViewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setPrefix("/WEB-INF/pages/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
  }
 
  
 
}
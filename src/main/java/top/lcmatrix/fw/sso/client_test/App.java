package top.lcmatrix.fw.sso.client_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import top.lcmatrix.fw.sso.client.interceptor.SSOInterceptor;

@Configuration
@EnableAutoConfiguration
@ServletComponentScan({"top.lcmatrix.fw.sso.client_test", "top.lcmatrix.fw.sso.client"})
@ComponentScan({"top.lcmatrix.fw.sso.client_test", "top.lcmatrix.fw.sso.client"})
public class App extends WebMvcConfigurerAdapter {
	
	@Autowired
	private SSOInterceptor ssoInterceptor;
	
    public static void main( String[] args ){
    	SpringApplication.run(App.class, args);
    }
    
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ssoInterceptor).addPathPatterns("/**")
			.excludePathPatterns("/error", "/open/**");
		super.addInterceptors(registry);
	}
}

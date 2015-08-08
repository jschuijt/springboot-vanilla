package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:spring/applicationContext.xml")
public class Application extends SpringBootServletInitializer {
	
	private static final String DEMO_ROOT = "/demo/*";
	final static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
		
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Demo application starting...");
    }
    
    @Override
	public void onStartup(ServletContext container) throws ServletException {
    	super.onStartup(container);
    	Dynamic registration = (Dynamic) container.getServletRegistration(EmbeddedWebApplicationContext.DISPATCHER_SERVLET_NAME);
    	registration.setLoadOnStartup(1);
    	registration.addMapping("/*");
	}
    
    // Override the default URL mapping
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
    	ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
    	registration.addUrlMappings(DEMO_ROOT);
    	logger.info("Demo URL mapping added!");
    	return registration;
    }
    
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
    
    // Register a filter
//    @Bean
//    public FilterRegistrationBean sampleFilter() {
//    	FilterRegistrationBean registration = new FilterRegistrationBean();
//    	registration.setFilter(new SampleFilter());
//    	registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
//    	registration.addUrlPatterns("/*");
//    	logger.info("Sample filter added!");
//    	return registration;
//    }
    
 // Register a listener
//  @Bean
//  public ServletListenerRegistrationBean<EventListener> sampleListener() {
//  	ServletListenerRegistrationBean<EventListener> registration = new ServletListenerRegistrationBean<EventListener>();
//  	registration.setListener(new SampleListener());
//  	logger.info("Sample listener added!");
//  	return registration;
//  }
    
}

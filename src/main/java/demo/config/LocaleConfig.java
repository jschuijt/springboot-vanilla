package demo.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * This class configure the way the application resolves I18N messages.
 *
 */
@Configuration
public class LocaleConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Implementation of LocaleResolver that uses a locale attribute 
	 * in the user’s session in case of a custom setting, with a fallback to
	 * the specified default locale or the request’s accept-header locale.
	 * Another class we can use: {@link AcceptHeaderLocaleResolver}
	 * @return
	 */
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
 
	/**
	 * Configuring an interceptor that is responsible or swapping out the
	 * current locale allows for easy testing by a developer, and also gives
	 * you the option of including a select list in your UI that lets the user 
	 * pick the locale they prefer.
	 * @return
	 */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}

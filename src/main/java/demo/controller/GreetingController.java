package demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Configuration;
import demo.service.ConfigurationService;
import demo.vo.Greeting;

@RestController
public class GreetingController {
	
	@Autowired
	ConfigurationService configService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    @RequestMapping("/config")
    public @ResponseBody List<Configuration> getConfigByProfile(@RequestParam(value="profile", defaultValue="dev") String profile) {
    	List<Configuration> data = configService.getConfigurationsForProfile(profile);
    	return data;
    }
}
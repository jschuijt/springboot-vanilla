package demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import demo.domain.Configuration;
import demo.service.ConfigurationService;
import demo.vo.Greeting;

@Api(value="/demo", description="Simple demo application for Spring boot")
@RestController
public class GreetingController {
	
	@Autowired
	ConfigurationService configService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "See the given name to be welcomed with a nice hello.")
    @RequestMapping("/greeting")
    public Greeting greeting(
    		@ApiParam(name="name", value="The name to be welcomed", required=false)
    		@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @ApiOperation(value = "Retrieve the list of configurations for a given profile.")
    @RequestMapping("/config")
    public @ResponseBody List<Configuration> getConfigByProfile(
    		@ApiParam(name="profile", value="The profile value to be used", required=true)
    		@RequestParam(value="profile", defaultValue="dev") String profile) {
    	List<Configuration> data = configService.getConfigurationsForProfile(profile);
    	return data;
    }
}
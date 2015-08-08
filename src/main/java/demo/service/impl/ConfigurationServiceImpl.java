package demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.domain.Configuration;
import demo.repositories.ConfigRepository;
import demo.service.ConfigurationService;

@Component
public class ConfigurationServiceImpl implements ConfigurationService {
	
	@Autowired
	ConfigRepository configRepo;

	@Override
	public List<Configuration> getConfigurationsForProfile(String profile) {
		// Should return a list of VO object, not domain objects
		return configRepo.findByProfile(profile);
	}

}

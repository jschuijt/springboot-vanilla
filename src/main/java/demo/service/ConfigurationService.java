package demo.service;

import java.util.List;

import demo.domain.Configuration;

public interface ConfigurationService {
	
	List<Configuration> getConfigurationsForProfile(String profile);

}

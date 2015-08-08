package demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.domain.Configuration;

public interface ConfigRepository extends CrudRepository<Configuration, Long> {

	List<Configuration> findByProfile(String profile);
}

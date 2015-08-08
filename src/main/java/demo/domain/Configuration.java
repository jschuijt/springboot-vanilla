package demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Configuration")
public class Configuration implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1527626546346710340L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="config_id")
	private Long id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="profile")
	private String profile;
	
	@Column(name="config_value")
	private String value;
	
	@Column(name="value_type")
	private String type;
	
	public Configuration() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}

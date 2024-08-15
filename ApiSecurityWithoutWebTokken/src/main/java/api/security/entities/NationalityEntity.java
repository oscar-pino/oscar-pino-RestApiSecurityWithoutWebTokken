package api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nationalities")
public class NationalityEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "nationality_id", nullable=false, unique = true)
	private Long nationalityId;	

	@Column(unique = true, nullable = false)
	private String name;	

	@Column(nullable = false)
	private String language;

	public NationalityEntity() {
	}

	public NationalityEntity(String name, String language) {
		this.name = name;
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getNationalityId() {
		return nationalityId;
	}

	@Override
	public String toString() {
		return "Nationality [nationalityId=" + nationalityId + ", name=" + name + ", language=" + language + "]";
	}	
}

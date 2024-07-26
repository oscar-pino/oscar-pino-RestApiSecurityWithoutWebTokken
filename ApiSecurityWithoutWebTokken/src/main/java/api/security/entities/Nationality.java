package api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nationalities")
public class Nationality {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "nationality_id", nullable=false, unique = true)
	private Long nationalityId;
	
	@Column(unique = true)
	private String nation;
	
	@Column(unique = true)
	private String language;

	public Nationality() {
	}

	public Nationality(String nation, String language) {
		this.nation = nation;
		this.language = language;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
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
		return "Nationality [nationalityId=" + nationalityId + ", nation=" + nation + ", language=" + language + "]";
	}	
}

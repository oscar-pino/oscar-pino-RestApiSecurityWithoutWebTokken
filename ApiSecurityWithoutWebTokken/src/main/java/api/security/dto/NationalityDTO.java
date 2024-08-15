package api.security.dto;


public class NationalityDTO {

	private Long nationalityId;	

	private String name;

	private String language;

	public NationalityDTO() {
	}
	
	public NationalityDTO(String name) {
		this.name = name;
	}
	
	public NationalityDTO(String name, String language) {
		this.name = name;
		this.language = language;
	}
	
	public NationalityDTO(Long nationalityId, String name, String language) {
		this.name = name;
		this.language = language;
		this.nationalityId = nationalityId;
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

	public void setNationalityId(Long nationalityId) {
		this.nationalityId = nationalityId;
	}

	@Override
	public String toString() {
		return "Nationality [nationalityId=" + nationalityId + ", name=" + name + ", language=" + language + "]";
	}	
}

package api.security.dto;

import java.util.Date;

public class AuthorDTO {

	private Long authorId;
	
	private String firstName;
	
	private String lastName;	

	private NationalityDTO nationalityDTO;

	private String webSite;
	

	private String email;

	private Date birthDate;

	public AuthorDTO() {
	}	

	public AuthorDTO(String firstName, String lastName, NationalityDTO nationalityDTO, String webSite, String email,
			Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityDTO = nationalityDTO;
		this.webSite = webSite;
		this.email = email;
		this.birthDate = birthDate;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", nationality="
				+ nationalityDTO.getName() + ", webSite=" + webSite + ", email=" + email + ", birthDate=" + birthDate + "]";
	}
	
}

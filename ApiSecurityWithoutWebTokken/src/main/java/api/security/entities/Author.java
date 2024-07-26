package api.security.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	
	// esto es un comentario
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="author_id", nullable=false)
	private Long authorId;
	
	private String firstName;
	
	private String lastName;	
	
	@ManyToOne
	@JoinColumn(name = "nationality_id", nullable = false)
	private Nationality nationality;
	
	@Column(name = "web_site", unique=true)
	private String webSite;
	
	@Column(unique=true)
	private String email;
	
	@Column(name = "birth_date")
	private Date birthDate;

	public Author() {
	}	

	public Author(String firstName, String lastName, Nationality nationality, String webSite, String email,
			Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
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

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", nationality="
				+ nationality + ", webSite=" + webSite + ", email=" + email + ", birthDate=" + birthDate + "]";
	}
	
}

package api.security.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {		

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "publisher_id", nullable=false, unique = true)
	private Long publisherId;
	
	@Column(unique=true)
	private String name;
	
	@Column(unique=true)
	private String address;	
	
	@Column(unique=true)
	private String phone;
	
	@Column(name = "web_site", unique=true)
	private String webSite;
	
	@Column(unique=true)
	private String email;
	
	@Column(name = "founding_date")
	private Date foundingDate;
	
	public Publisher() {
	}

	public Publisher(String name, String address, String phone, String webSite, String email,
			Date foundingDate) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.webSite = webSite;
		this.email = email;
		this.foundingDate = foundingDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Date getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}

	public Long getPublisherId() {
		return publisherId;
	}
	
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", webSite=" + webSite + ", email=" + email + ", foundingDate=" + foundingDate + "]";
	}

}

package api.security.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id", unique = true)
	private Long customerId;
	
	private String firstName;
	
	private String lastName;	
	
	@ManyToOne
	@JoinColumn(name = "nationality_id", nullable = false)
	private Nationality nationality;

	private String address;
	
	@Column(unique=true)
	private String email;
	
	private String phone;

	public Customer() {
	}	

	public Customer(String firstName, String lastName, Nationality nationality, String address, String email,
			String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.address = address;
		this.email = email;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nationality=" + nationality + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ "]";
	}	
}

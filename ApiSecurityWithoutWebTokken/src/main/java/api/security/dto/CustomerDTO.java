package api.security.dto;

public class CustomerDTO {

	private Long customerId;
	
	private String firstName;
	
	private String lastName;	

	private NationalityDTO nationalityDTO;

	private String address;

	private String email;
	
	private String phone;

	public CustomerDTO() {
	}	

	public CustomerDTO(String firstName, String lastName, NationalityDTO nationalityDTO, String address, String email,
			String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityDTO = nationalityDTO;
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

	public NationalityDTO getNationality() {
		return nationalityDTO;
	}

	public void setNationality(NationalityDTO nationalityDTO) {
		this.nationalityDTO = nationalityDTO;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", email=" + email + ", phone=" + phone
				+ "]";
	}	
}

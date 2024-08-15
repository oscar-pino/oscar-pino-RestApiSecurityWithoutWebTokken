package api.security.dto;

import java.util.HashSet;
import java.util.Set;

import api.security.entities.RoleEntity;

public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private boolean isEnabled;

	private boolean accountNoExpired;

	private boolean accountNoLocked;

	private boolean credentialNoExpired;

	private Set<RoleEntity> roles = new HashSet<>();

	public UserDTO() {

	}

	public UserDTO(String username, String password, boolean isEnabled, boolean accountNoExpired,
			boolean accountNoLocked, boolean credentialNoExpired, Set<RoleEntity> roles) {

		this.username = username;
		this.password = password;
		this.isEnabled = isEnabled;
		this.accountNoExpired = accountNoExpired;
		this.accountNoLocked = accountNoLocked;
		this.credentialNoExpired = credentialNoExpired;
		this.roles = roles;
	}

	public UserDTO(Long id, String username, String password, boolean isEnabled, boolean accountNoExpired,
			boolean accountNoLocked, boolean credentialNoExpired, Set<RoleEntity> roles) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.isEnabled = isEnabled;
		this.accountNoExpired = accountNoExpired;
		this.accountNoLocked = accountNoLocked;
		this.credentialNoExpired = credentialNoExpired;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isAccountNoExpired() {
		return accountNoExpired;
	}

	public void setAccountNoExpired(boolean accountNoExpired) {
		this.accountNoExpired = accountNoExpired;
	}

	public boolean isAccountNoLocked() {
		return accountNoLocked;
	}

	public void setAccountNoLocked(boolean accountNoLocked) {
		this.accountNoLocked = accountNoLocked;
	}

	public boolean isCredentialNoExpired() {
		return credentialNoExpired;
	}

	public void setCredentialNoExpired(boolean credentialNoExpired) {
		this.credentialNoExpired = credentialNoExpired;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", isEnabled=" + isEnabled
				+ ", accountNoExpired=" + accountNoExpired + ", accountNoLocked=" + accountNoLocked
				+ ", credentialNoExpired=" + credentialNoExpired + ", rolesCantidad=" + roles.size() + "]";
	}

}

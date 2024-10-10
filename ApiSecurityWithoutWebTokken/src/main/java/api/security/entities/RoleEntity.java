package api.security.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import api.security.entities.enums.RoleEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<PermissionEntity> permissionList;

	public RoleEntity() {
		
	}

	public RoleEntity(RoleEnum roleEnum) {
		this.roleEnum = roleEnum;
	}

	public RoleEntity(RoleEnum roleEnum, ArrayList<PermissionEntity> permissionList) {
		this.roleEnum = roleEnum;
		this.permissionList = permissionList;
	}

	public RoleEntity(Long id, RoleEnum roleEnum, ArrayList<PermissionEntity> permissionList) {
		this.id = id;
		this.roleEnum = roleEnum;
		this.permissionList = permissionList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getRoleEnum() {
		return roleEnum;
	}

	public void setRoleEnum(RoleEnum roleEnum) {
		this.roleEnum = roleEnum;
	}

	public List<PermissionEntity> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<PermissionEntity> permissionList) {
		this.permissionList = permissionList;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleEnum=" + roleEnum + ", permissionListSize=" + permissionList.size() + "]";
	}    
}

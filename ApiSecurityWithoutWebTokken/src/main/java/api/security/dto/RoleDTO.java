package api.security.dto;

import java.util.HashSet;
import java.util.Set;

import api.security.entities.PermissionEntity;
import api.security.entities.enums.RoleEnum;

public class RoleDTO {
	
    private Long id;
    
    private RoleEnum roleEnum;
    
    private Set<PermissionEntity> permissionList = new HashSet<>();

	public RoleDTO() {
		
	}

	public RoleDTO(RoleEnum roleEnum) {
		this.roleEnum = roleEnum;
	}

	public RoleDTO(RoleEnum roleEnum, Set<PermissionEntity> permissionList) {
		this.roleEnum = roleEnum;
		this.permissionList = permissionList;
	}

	public RoleDTO(Long id, RoleEnum roleEnum, Set<PermissionEntity> permissionList) {
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

	public Set<PermissionEntity> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(Set<PermissionEntity> permissionList) {
		this.permissionList = permissionList;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleEnum=" + roleEnum + ", permissionListSize=" + permissionList.size() + "]";
	}    

}

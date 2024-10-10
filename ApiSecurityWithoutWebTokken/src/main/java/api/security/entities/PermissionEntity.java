package api.security.entities;

import api.security.entities.enums.PermissionEnum;
import api.security.entities.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_name")
    @Enumerated(EnumType.STRING)
    private PermissionEnum permissionEnum;

	public PermissionEntity() {
	}

	public PermissionEntity(PermissionEnum permissionEnum) {
		this.permissionEnum = permissionEnum;
	}

	public PermissionEntity(Long id, PermissionEnum permissionEnum) {
		this.id = id;
		this.permissionEnum = permissionEnum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PermissionEnum getPermissionEnum() {
		return permissionEnum;
	}

	public void setPermissionEnum(PermissionEnum permissionEnum) {
		this.permissionEnum = permissionEnum;
	}

	@Override
	public String toString() {
		return "PermissionEntity [id=" + id + ", name=" + permissionEnum.name() + "]";
	}    
}

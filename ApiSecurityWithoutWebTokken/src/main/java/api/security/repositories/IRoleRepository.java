package api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.RoleEntity;
import api.security.entities.RoleEnum;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

	Optional<RoleEntity> findByRoleEnum(RoleEnum roleEnum);
}

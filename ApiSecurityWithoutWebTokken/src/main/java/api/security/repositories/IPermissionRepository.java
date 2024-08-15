package api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.PermissionEntity;

@Repository
public interface IPermissionRepository extends JpaRepository<PermissionEntity, Long> {
	
	Optional<PermissionEntity> findByName(String name);

}

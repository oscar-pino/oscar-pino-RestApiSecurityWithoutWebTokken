package api.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.security.entities.PermissionEntity;

@Repository
public interface IPermissionRepository extends JpaRepository<PermissionEntity, Long> {
	
	/*
	@Query(value = "SELECT * FROM permissions WHERE permission_name = :name", nativeQuery = true)
	List<PermissionEntity> findAllByName(String name); */

}

package api.security.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.security.entities.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

	Optional<RoleEntity> findById(Long id);
	
	@Query(value = "SELECT * FROM roles WHERE role_name = :name", nativeQuery = true)
	List<RoleEntity> findAllByName(String name);

}

package api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.security.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByUsername(String username);

}

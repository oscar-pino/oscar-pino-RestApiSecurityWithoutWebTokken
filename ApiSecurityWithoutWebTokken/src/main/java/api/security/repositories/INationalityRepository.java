package api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.NationalityEntity;


@Repository
public interface INationalityRepository extends JpaRepository<NationalityEntity, Long> {
	
	Optional<NationalityEntity> findByName(String name);

	Optional<NationalityEntity> findByNationalityId(Long nationalityId);
}

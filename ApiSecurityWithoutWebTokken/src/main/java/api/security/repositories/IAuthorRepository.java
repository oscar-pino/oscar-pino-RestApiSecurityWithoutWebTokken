package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.AuthorEntity;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {

}

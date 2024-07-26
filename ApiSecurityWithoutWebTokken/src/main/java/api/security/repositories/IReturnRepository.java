package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.Return;

@Repository
public interface IReturnRepository extends JpaRepository<Return, Long> {

}

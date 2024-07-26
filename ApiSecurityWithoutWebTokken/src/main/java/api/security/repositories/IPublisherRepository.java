package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.Publisher;

@Repository
public interface IPublisherRepository extends JpaRepository<Publisher, Long> {

}

package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}

package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

}

package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.BookEntity;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

	//boolean findBookByIsbm(String isbm);
}

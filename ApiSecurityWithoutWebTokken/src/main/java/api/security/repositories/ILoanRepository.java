package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.LoanEntity;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {

}

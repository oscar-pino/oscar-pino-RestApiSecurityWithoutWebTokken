package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.Loan;

@Repository
public interface ILoanRepository extends JpaRepository<Loan, Long> {

}

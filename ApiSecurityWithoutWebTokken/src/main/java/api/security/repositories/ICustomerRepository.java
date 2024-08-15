package api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.security.entities.CustomerEntity;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

}

package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.security.entities.LoanEntity;
import api.security.entities.UserEntity;

@Service
public class LoanServicesImp implements IDAO<LoanEntity> {

	@Override
	public void create(LoanEntity t) {
		

	}
	
	@Override
	public Optional<LoanEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<LoanEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		

		
	}

	@Override
	public void update(LoanEntity loanEntity) {
		

		
	}
}

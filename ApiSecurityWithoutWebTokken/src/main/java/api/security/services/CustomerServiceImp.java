package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.security.entities.CustomerEntity;
import api.security.entities.UserEntity;

@Service
public class CustomerServiceImp implements IDAO<CustomerEntity> {

	@Override
	public void create(CustomerEntity t) {
		
	
		
	}
	
	@Override
	public Optional<CustomerEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CustomerEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		
	
		
	}

	@Override
	public void update(CustomerEntity customerEntity) {
		

		
	}
}

package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.security.entities.ReturnEntity;

@Service
public class ReturnServiceImp implements IDAO<ReturnEntity> {

	@Override
	public void create(ReturnEntity t) {
		

		
	}

	@Override
	public Optional<ReturnEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<ReturnEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {

		
	}

	@Override
	public void update(ReturnEntity returnEntity) {
		

		
	}
}

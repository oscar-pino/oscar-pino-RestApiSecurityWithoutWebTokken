package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.security.entities.CategoryEntity;
import api.security.entities.UserEntity;

@Service
public class CategoryServiceImp implements IDAO<CategoryEntity> {

	@Override
	public void create(CategoryEntity t) {
		
	
		
	}
	
	@Override
	public Optional<CategoryEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CategoryEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {

	}

	@Override
	public void update(CategoryEntity categoryEntity) {
		
		
		
	}
}

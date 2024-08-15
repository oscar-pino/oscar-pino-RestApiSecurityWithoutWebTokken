package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.security.entities.RoleEntity;
import api.security.repositories.IRoleRepository;

@Service
public class RoleServiceImp implements IDAO<RoleEntity> {
	
	@Autowired
	IRoleRepository roleRepository;

	@Override
	public void create(RoleEntity roleEntity) {
		
		
	}

	@Override
	public Optional<RoleEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<RoleEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		
	
		
	}

	@Override
	public void update(RoleEntity roleEntity) {
		

		
	}
}

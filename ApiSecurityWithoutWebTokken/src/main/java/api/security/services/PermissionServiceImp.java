package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.security.entities.NationalityEntity;
import api.security.entities.PermissionEntity;
import api.security.repositories.IPermissionRepository;

@Service
public class PermissionServiceImp implements IDAO<PermissionEntity> {
	
	@Autowired
	IPermissionRepository permissionRepository;

	@Override
	public void  create(PermissionEntity permissionEntity) {
		
	
	}

	@Override
	public Optional<PermissionEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<PermissionEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		

		
	}

	@Override
	public void update(PermissionEntity permissionEntity) {

	}
}

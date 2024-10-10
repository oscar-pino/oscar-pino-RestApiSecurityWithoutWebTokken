package api.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.security.entities.PermissionEntity;
import api.security.repositories.IPermissionRepository;

@Service
public class PermissionServiceImp implements IDAO<PermissionEntity> {
	

	@Autowired
	IPermissionRepository permissionRepository;

	@Override
	public void create(PermissionEntity permissionEntity) {
		
		permissionRepository.save(permissionEntity);
	}

	@Override
	public Optional<PermissionEntity> readById(Long id) {

		return permissionRepository.findById(id);
	
	}
	/*
	public List<PermissionEntity> readAllByName(String name) {

		return permissionRepository.findAllByName(name);
	} */

	@Override
	public List<PermissionEntity> readAll() {

		return permissionRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		
		permissionRepository.deleteById(id);
	}

	
	public List<PermissionEntity> getOthers(String name){
		
		return (ArrayList<PermissionEntity>)readAll().stream().filter(n -> !n.getPermissionEnum().name().equalsIgnoreCase(name)).collect(Collectors.toList());
	}
}

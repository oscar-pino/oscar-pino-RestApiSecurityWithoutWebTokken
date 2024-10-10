package api.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.security.entities.NationalityEntity;
import api.security.entities.RoleEntity;
import api.security.repositories.INationalityRepository;
import api.security.repositories.IRoleRepository;

@Service
public class RoleServiceImp implements IDAO<RoleEntity> {
	

	@Autowired
	IRoleRepository roleRepository;

	@Override
	public void create(RoleEntity role) {
		
		roleRepository.save(role);
	}

	@Override
	public Optional<RoleEntity> readById(Long id) {

		return roleRepository.findById(id);
	
	}

	public List<RoleEntity> readAllByName(String name) {

		return roleRepository.findAllByName(name);
	}

	@Override
	public List<RoleEntity> readAll() {

		return (ArrayList<RoleEntity>) roleRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		
		roleRepository.deleteById(id);
	}

	
	public List<RoleEntity> getOthers(String name){
		
		return (ArrayList<RoleEntity>)readAll().stream().filter(n -> !n.getRoleEnum().name().equalsIgnoreCase(name)).collect(Collectors.toList());
	}
	
}
	



package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.security.entities.PermissionEntity;
import api.security.entities.UserEntity;
import api.security.repositories.IUserRepository;

@Service
public class UserServiceImp implements IDAO<UserEntity> {
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public void create(UserEntity userEntity) {
	
		userRepository.save(userEntity);
	}

	@Override
	public Optional<UserEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<UserEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		

		
	}

	@Override
	public void update(UserEntity userEntity) {
		

		
	}

	@Override
	public List<UserEntity> getOthers(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

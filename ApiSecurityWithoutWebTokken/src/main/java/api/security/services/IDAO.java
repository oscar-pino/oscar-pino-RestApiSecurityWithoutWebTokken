package api.security.services;

import java.util.List;
import java.util.Optional;

import api.security.entities.UserEntity;

public interface IDAO<T> {
	
	void create(T t);
	
	Optional<T> readById(Long id);

	List<T> readAll();
	
	void deleteById(Long id);
	
	void update(T t);	
}

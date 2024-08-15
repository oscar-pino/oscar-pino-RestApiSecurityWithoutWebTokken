package api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.security.entities.PublisherEntity;

@Service
public class PublisherServiceImp implements IDAO<PublisherEntity> {

	@Override
	public void create(PublisherEntity t) {
		
		
	}

	@Override
	public Optional<PublisherEntity> readById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<PublisherEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		

		
	}

	@Override
	public void update(PublisherEntity publisherEntity) {
		

		
	}
}

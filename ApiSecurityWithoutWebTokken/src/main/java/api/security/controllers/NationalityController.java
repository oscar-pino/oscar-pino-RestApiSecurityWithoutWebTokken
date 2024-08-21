package api.security.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.security.dto.NationalityDTO;
import api.security.entities.NationalityEntity;
import api.security.services.NationalityServiceImp;

@RestController
@RequestMapping("/api/nationalities")
public class NationalityController {

	@Autowired
	private NationalityServiceImp nationalityService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody NationalityDTO nationalityDTO) {

		Optional<NationalityEntity> recovered = nationalityService.readByName(nationalityDTO.getName());

		if (recovered.isPresent() & !nationalityDTO.getLanguage().isEmpty()) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(nationalityDTO.getName() + ", ya existe, pruebe con otro nombre.");
		}

		if (!nationalityDTO.getName().isEmpty() & !nationalityDTO.getLanguage().isEmpty()) {
			nationalityService.create(new NationalityEntity(nationalityDTO.getName(), nationalityDTO.getLanguage()));
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(nationalityDTO.getName() + ", creada sastifactoriamente.");
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("faltan datos.");
	}

	@GetMapping("/read/id/{id}")
	public ResponseEntity<?> readById(@PathVariable Long id) {

		Optional<NationalityEntity> recovered = nationalityService.readById(id);

		if (recovered.isPresent())
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(recovered.get());

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("no se ha encontrado nacionalidad con el id: " + id + ".");
	}

	@GetMapping("/read/name/{name}")
	public ResponseEntity<?> readById(@PathVariable String name) {

		Optional<NationalityEntity> recovered = nationalityService.readByName(name);

		if (recovered.isPresent())
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(recovered.get());

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("no se ha encontrado nacionalidad con el nombre: " + name + ".");
	}

	@GetMapping("/read/all")
	public ResponseEntity<?> readAll() {

		List<NationalityDTO> nationes = nationalityService.readAll().stream()
				.map((n) -> new NationalityDTO(n.getNationalityId(), n.getName(), n.getLanguage())).toList();

		if (nationes.size() > 0)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(nationes);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se han encontrado nacionalidades.");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody NationalityDTO nationalityDTO) {

		Optional<NationalityEntity> recovered = nationalityService.readById(id);

		if (nationalityDTO.getName().isEmpty() | nationalityDTO.getLanguage().isEmpty()) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("faltan datos.");

		} else if (recovered.isPresent()) {

			ArrayList<NationalityEntity> otros = nationalityService.getOthers(recovered.get().getName());

			if (otros.contains(nationalityService.readByName(nationalityDTO.getName()).get()))
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(nationalityDTO.getName() + ", ya existe, pruebe con otro nombre.");
			else {
				NationalityEntity na = recovered.get();
				na.setName(nationalityDTO.getName());
				na.setLanguage(nationalityDTO.getLanguage());

				nationalityService.create(na);

				return ResponseEntity.status(HttpStatus.CONFLICT).body("datos actualizados, correctamente.");
			}

		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("no se ha encontrado nacionalidad con el id: " + id + ".");

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

		Optional<NationalityEntity> recovered = nationalityService.readById(id);

		if (recovered.isPresent()) {
			nationalityService.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body("nacionalidad con id: " + id + ", eliminada correctamente.");
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("no se ha encontrado nacionalidad con el id: " + id + ".");
	}

}

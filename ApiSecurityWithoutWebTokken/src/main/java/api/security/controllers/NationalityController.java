package api.security.controllers;

import java.util.List;
import java.util.Optional;

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

		if (nationalityDTO.getName().trim().length() != 0 & nationalityDTO.getLanguage().trim().length() != 0) {

			if (nationalityService.readByName(nationalityDTO.getName()).get().getName()
					.equalsIgnoreCase(nationalityDTO.getName())) {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(nationalityDTO.getName() + ", ya existe, pruebe con otro nombre.");
			} else {
				nationalityService
						.create(new NationalityEntity(nationalityDTO.getName(), nationalityDTO.getLanguage()));
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(nationalityDTO.getName() + ", creada sastifactoriamente.");
			}

		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("datos inválidos.");
	}

	@GetMapping("/read/id/{id}")
	public ResponseEntity<?> readById(@PathVariable Long id) {

		Optional<NationalityEntity> recovered = nationalityService.readById(id);

		if (recovered != null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(recovered.get());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se ha encontrado nationalidad con el id: " + id);
	}

	@GetMapping("/read/name/{name}")
	public ResponseEntity<?> readById(@PathVariable String name) {

		Optional<NationalityEntity> recovered = nationalityService.readByName(name);

		if (recovered != null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(recovered.get());

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("no se ha encontrado nationalidad con el name: " + name);
	}

	@GetMapping("/read/all")
	public ResponseEntity<?> readAll() {

		List<NationalityDTO> nationes = nationalityService.readAll().stream()
				.map((n) -> new NationalityDTO(n.getNationalityId(), n.getName(), n.getLanguage())).toList();

		if (nationes.size() > 0)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(nationes);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se han encontrado nationalidades.");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody NationalityDTO nationality) {

		Optional<NationalityEntity> recovered = nationalityService.readById(id);

		if (recovered != null) {

			NationalityEntity ne = new NationalityEntity(nationality.getName(), nationality.getLanguage());
			recovered.get().setName(ne.getName());
			recovered.get().setLanguage(ne.getLanguage());
			nationalityService.create(recovered.get());

			return ResponseEntity.status(HttpStatus.ACCEPTED).body(recovered.get());
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("no se ha encontrado nacionalidad con el id: " + id + ", para actualización.");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

		Optional<NationalityEntity> recovered = nationalityService.readById(id);

		if (recovered != null) {
			nationalityService.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body("cationalidad con id: " + id + ", eliminada sastifactoriamente.");
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("no se ha encontrado nationalidad con el id: " + id);
	}
}

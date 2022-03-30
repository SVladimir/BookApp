package mk.com.iwec.BookApp.controller;

import mk.com.iwec.BookApp.entity.City;
import mk.com.iwec.BookApp.dto.CityDto2;
import mk.com.iwec.BookApp.service.CityService;
import mk.com.iwec.BookApp.infrastructure.Endpoints;
import mk.com.iwec.BookApp.infrastructure.controller.ControllerLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.CITY)
@CrossOrigin
public class CityController implements ControllerLayer<City, CityDto2> {

	@Autowired
	CityService service;

	@Override
	@GetMapping
	public List<CityDto2> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public CityDto2 findId(@PathVariable Long id) {
		return service.findId(id);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteId(@PathVariable Long id) {
		service.deleteId(id);

	}

	@Override
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public City save(@RequestBody City t) {
		return service.save(t);

	}

	@Override
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public City update(@PathVariable Long id, @RequestBody City t) {
		return service.update(id, t);

	}

}

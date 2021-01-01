package dkw.beer.srvr.web.controller.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dkw.beer.srvr.services.v2.BeerServiceV2;
import dkw.beer.srvr.web.model.v2.BeerDtoV2;

@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerServiceV2;
	

	public BeerControllerV2(BeerServiceV2 beerServiceV2) {
		this.beerServiceV2 = beerServiceV2;
	}


	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
		
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping // create a new beer
	public ResponseEntity createBeer(@Valid @RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//TODO add hostname with value from properties file
		String url = String.format("%s/%s", "localhost:8080/api/v1/beer", savedDto.getId().toString());
		headers.add("Location", url);
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
		beerServiceV2.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)  // will force a return object, although the method is void
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerServiceV2.deleteById(beerId);
	}

	// See the MvcExceptionHandler for ControllerAdvice!
//	// To handle specific errors (Constraint Violations)
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
//		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//		e.getConstraintViolations().forEach(violation -> {
//			errors.add(String.format("%s : %s", violation.getPropertyPath(), violation.getMessage()));
//		});
//		return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
//	}
}

package dkw.beer.srvr.web.controller;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dkw.beer.srvr.services.BeerService;
import dkw.beer.srvr.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
@RequestMapping("api/v1/beer")
@RestController
// Put validation on method parameters (See @NotNull on various methods for beerId, below)
@Validated 
public class BeerController {

	private final BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}


	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {
		log.info(String.format("-->> Server - Get beer by Id: %s", beerId.toString()));
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping // create a new beer
	public ResponseEntity createBeer (@Valid @RequestBody BeerDto beerDto) {
		log.info(String.format("-->> Server - Save beer: %s", beerDto.toString()));
		BeerDto savedDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//TODO add hostname with value from properties file
		String url = String.format("%s/%s", "http://localhost:8080/api/v1/beer", savedDto.getId().toString());
		headers.add("Location", url);
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeer(@NotNull @PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
		log.info(String.format("-->> Server - Update beer - id: %s, beer: %s", beerId.toString(), beerDto.toString()));
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)  // will force a return object, although the method is void
	public void deleteBeer(@NotNull @PathVariable("beerId") UUID beerId) {
		log.info(String.format("-->> Server - Delete beer by id: %s", beerId.toString()));
		beerService.deleteById(beerId);
	}
}

package dkw.beer.srvr.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dkw.beer.srvr.services.CustomerService;
import dkw.beer.srvr.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private final CustomerService customerService;
	

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}


	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
		log.info(String.format("-->> Server - Get Customer by Id: %s", customerId.toString()));
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
		log.info(String.format("-->> Server - Save Customer: %s", customerDto.toString()));
		CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//TODO add hostname with value from properties file
		String url = String.format("%s/%s", "localhost:8080/api/v1/customer", savedDto.getId().toString());
		headers.add("Location", url);
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
		log.info(String.format("-->> Server - Update Customer - id: %s, Customer: %s", customerId.toString(), customerDto.toString()));
		customerService.updateCustomer(customerId, customerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		log.info(String.format("-->> Server - Delete Customer by id: %s", customerId.toString()));
		customerService.deleteById(customerId);
	}
}

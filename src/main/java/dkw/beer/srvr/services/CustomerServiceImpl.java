package dkw.beer.srvr.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dkw.beer.srvr.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerUrl) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Kieth Wood")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Bubba Louie")
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		log.debug(String.format("-->> Updating a beer - id: %s \n-->> CustomerDto: %s", customerId, customerDto.toString()));
	}

	@Override
	public void deleteById(UUID customerId) {
		log.debug(String.format("-->> Deleting a beer - id: %s", customerId));
	}

	
}

package dkw.beer.srvr.mappers;

import org.mapstruct.Mapper;

import dkw.beer.srvr.domain.Customer;
import dkw.beer.srvr.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	
	public CustomerDto customerToDto(Customer customer); 
	public Customer dtoToCustomer(CustomerDto dto); 

}

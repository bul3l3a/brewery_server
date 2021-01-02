package dkw.beer.srvr.mappers;

import org.mapstruct.Mapper;

import dkw.beer.srvr.domain.Beer;
import dkw.beer.srvr.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	public BeerDto beerToDto(Beer beer);
	public Beer dtoToBeer(BeerDto beer);
	
}

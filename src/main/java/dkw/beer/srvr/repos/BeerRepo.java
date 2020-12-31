package dkw.beer.srvr.repos;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import dkw.beer.srvr.domain.Beer;

public interface BeerRepo extends PagingAndSortingRepository<Beer, UUID> {

}

package dkw.beer.srvr.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dkw.beer.srvr.domain.Beer;
import dkw.beer.srvr.repos.BeerRepo;

@Component
public class BeerLoader implements CommandLineRunner{
	
	private final BeerRepo beerRepo;
	
	

	public BeerLoader(BeerRepo beerRepo) {
		super();
		this.beerRepo = beerRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeer();
	}

	private void loadBeer() {
		if (beerRepo.count() == 0) {
			beerRepo.save(Beer.builder().beerName("Galaxy Cat").beerStyle("Pale Ale")
					.minOnHand(12)
					.quantityToBrew(200)
					.upc(234230978098089L)
					.price(new BigDecimal("12.95"))
					.build());

			beerRepo.save(Beer.builder().beerName("Mango Bobs").beerStyle("IPA")
					.minOnHand(12)
					.quantityToBrew(200)
					.upc(234230978098090L)
					.price(new BigDecimal("10.95"))
					.build());

			beerRepo.save(Beer.builder().beerName("Miller Lite").beerStyle("Beer")
					.minOnHand(50)
					.quantityToBrew(200)
					.upc(234230978098091L)
					.price(new BigDecimal("5.95"))
					.build());
			System.out.println("\n-->> Loaded 3 beers for testing");
		}
		
	}
}

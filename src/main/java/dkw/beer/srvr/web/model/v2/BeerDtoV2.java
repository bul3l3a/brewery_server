package dkw.beer.srvr.web.model.v2;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Creates Getters and Setters 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {

	@Null
	private UUID id;
	@NotBlank
	private String beerName;
	private BeerStyleEnum beerStyle;
	@Positive
	private Long upc;
	
}

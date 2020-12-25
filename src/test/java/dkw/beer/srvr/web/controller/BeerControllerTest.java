package dkw.beer.srvr.web.controller;

//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.net.URI;
//import java.util.UUID;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import dkw.beer.srvr.services.BeerService;
//import dkw.beer.srvr.web.model.BeerDto;

//@WebMvcTest(BeerController.class)
class BeerControllerTest {

//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @MockBean
//    BeerService beerService;
//
//    @Test
//    void getBeerById() throws Exception {
//
//        given(beerService.getBeerById((any(), any())).willReturn(getValidBeerDto());
//
//        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    void saveNewBeer() throws Exception {
//
//        BeerDto beerDto = getValidBeerDto();
//        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
//
//        mockMvc.perform(post("/api/v1/beer/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(beerDtoJson))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    void updateBeerById() throws Exception {
//        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());
//
//        BeerDto beerDto = getValidBeerDto();
//        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(beerDtoJson))
//                .andExpect(status().isNoContent());
//    }
//
//    BeerDto getValidBeerDto(){
//        return BeerDto.builder()
//                .beerName("My Beer")
//                .beerStyle(BeerStyleEnum.ALE)
//                .price(new BigDecimal("2.99"))
//                .upc(BeerLoader.BEER_1_UPC)
//                .build();
//    }
}
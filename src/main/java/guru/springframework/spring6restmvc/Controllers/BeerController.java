package guru.springframework.spring6restmvc.Controllers;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {


    private final BeerService beerService;

//    @PostMapping
//    public ResponseEntity handlePost(Beer beer) {
//
//        Beer savedBeer = beerService.saveNewBeer(beer);
//
//        return new ResponseEntity(HttpStatus.CREATED);
//    }

    @GetMapping
    public List<Beer> listBeer() {
        return beerService.listBeer();
    }

    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable UUID beerId) {

        //log.debug("Get Beer by id - in controller");

        return beerService.getBeerByID(beerId);
    }

}

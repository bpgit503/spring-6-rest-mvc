package guru.springframework.spring6restmvc.Controllers;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
public class BeerController {


    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeer() {
        return beerService.listBeer();
    }

    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by id - in controller");

        return beerService.getBeerByID(id);
    }

}

package guru.springframework.spring6restmvc.Controllers;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class BeerController {


    private final BeerService beerService;

    public Beer getBeerById(UUID id){

        log.debug("Get Beer by id - in controller");

        return beerService.getBeerByID(id);
    }

}

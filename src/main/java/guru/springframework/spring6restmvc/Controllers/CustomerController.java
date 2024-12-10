package guru.springframework.spring6restmvc.Controllers;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.addNewCustomer(customer);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Location", "/api/v1/customer/"+ savedCustomer.getId().toString());


        return new ResponseEntity(responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable UUID customerId) {
        return customerService.findCustomerById(customerId);
    }



}

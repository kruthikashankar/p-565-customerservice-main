//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.iu.p565.customerservice.controller;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/customers"})
public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @PostMapping
    public int create(@RequestBody @Valid Customer customer) {
        Customer addedCustomer = (Customer)this.repository.save(customer);
        return addedCustomer.getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping({"/{id}"})
    public void update(@RequestBody @Valid Customer customer, @PathVariable int id) {
        customer.setId(id);
        this.repository.save(customer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id) {
        Customer customer = new Customer();
        customer.setId(id);
        this.repository.delete(customer);
    }
}

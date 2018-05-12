package com.michaelchen.zerotohero;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;


@RestController
public class CandyController {

    @Autowired
    private CandyRepository candyRepository;

    @RequestMapping(path = "/candies", method = RequestMethod.GET)
    public Iterable<Candy> getAllCandies() {  // what is iterable???
        return candyRepository.findAll();
    }

    @RequestMapping(path = "/candy", method = RequestMethod.GET)
    public Candy getCandy(@RequestParam Long id) {
        return candyRepository.findById(id).get();
    }

    @RequestMapping(path = "/candy/{id}", method = RequestMethod.GET)
    public Candy getCandyPath(@PathVariable Long id) {
        return candyRepository.findById(id).get();
    }

    @RequestMapping(path = "/candy", method = RequestMethod.POST)
    public Candy addCandy(@RequestBody Candy candy) {
        if (candyRepository.existsById(candy.getId())) {
            throw new EntityExistsException("candy with ID " + candy.getId() + " already exists");
        }

        return candyRepository.save(candy);  // why candyRepo returns candy???
    }

    @RequestMapping(path = "/candy", method = RequestMethod.PUT)
    public Candy editCandy(@RequestBody Candy candy) throws Exception {
        if (!candyRepository.existsById(candy.getId())) {
            throw new NotFoundException("candy with ID " + candy.getId() + " not found");
        }

        return candyRepository.save(candy);
    }

    @RequestMapping(path = "/candy/{id}", method = RequestMethod.DELETE)
    public void deleteCandy(@PathVariable Long id) throws Exception {
        if (!candyRepository.existsById(id)) {
            throw new NotFoundException("candy with ID " + id + " not found");
        }

        candyRepository.deleteById(id);
    }
}
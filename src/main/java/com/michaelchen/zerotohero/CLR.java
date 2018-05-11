package com.michaelchen.zerotohero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {

    @Autowired
    private CandyRepository candyRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Getting candy!");
        candyRepository.findAll().forEach(System.out::println);

        System.out.println("Deleting #3");
        candyRepository.deleteById(3L);

        System.out.println("Getting more candy!");
        candyRepository.findAll().forEach(System.out::println);

        System.out.println("Adding Bananas!");
        Candy newCandy = new Candy();
        newCandy.setId(3L);
        newCandy.setName("Bananas");
        candyRepository.save(newCandy);

        System.out.println("Getting more candy!");
        candyRepository.findAll().forEach(System.out::println);
    }
}

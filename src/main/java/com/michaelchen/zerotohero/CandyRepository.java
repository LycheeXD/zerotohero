package com.michaelchen.zerotohero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends CrudRepository<Candy, Long> {

}

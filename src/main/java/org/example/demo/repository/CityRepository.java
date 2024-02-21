package org.example.demo.repository;

import org.example.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByNameContaining(String name);

}

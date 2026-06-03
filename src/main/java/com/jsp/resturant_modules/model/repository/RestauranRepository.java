package com.jsp.resturant_modules.model.repository;


import com.jsp.resturant_modules.model.model.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranRepository extends JpaRepository<Resturant,Integer> {
}

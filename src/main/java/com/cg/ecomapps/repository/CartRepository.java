package com.cg.ecomapps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecomapps.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}

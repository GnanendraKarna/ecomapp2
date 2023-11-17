package com.cg.ecomapps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecomapps.entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Integer>{

}

package com.emandi.customerservice.repository;


import com.emandi.customerservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
   /* @Query("select from Cart c where c.users.id=?1")
    List<Cart> findCartsByUserId(Integer userId);*/

}

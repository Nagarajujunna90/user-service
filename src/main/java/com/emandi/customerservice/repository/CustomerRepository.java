package com.emandi.customerservice.repository;


import com.emandi.customerservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends CrudRepository<User, Integer> {




	

}

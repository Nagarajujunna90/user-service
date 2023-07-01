package com.emandi.customerservice.repository;


import com.emandi.customerservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {

}

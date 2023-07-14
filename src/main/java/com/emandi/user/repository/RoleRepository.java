package com.emandi.user.repository;


import com.emandi.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {

}

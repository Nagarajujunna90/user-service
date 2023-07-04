package com.emandi.customerservice.service;


import com.emandi.customerservice.dto.UserDTO;
import com.emandi.customerservice.model.Role;
import com.emandi.customerservice.model.User;
import com.emandi.customerservice.repository.CustomerRepository;
import com.emandi.customerservice.repository.RoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository userRepositroy;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EventServiceLog eventServiceLog;
//    @Autowired
//   private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) throws JsonProcessingException {
        Set<Role> roles1 = new HashSet<>();
        roles1.add(new Role("user"));
        user.setRoles(roles1);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user1 = userRepositroy.save(user);
     //   eventServiceLog.addEvent(user1, "ADD_USER");
        return user1;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepositroy.deleteById(id);
        eventServiceLog.addEvent(id, "DELETE_USER");

    }

    @Override
    public User updateUser(Integer id, User user) {
        user.setId(id);
        User updatedUser = userRepositroy.save(user);
        eventServiceLog.addEvent(updatedUser, "UPDATE_USER");
        return updatedUser;
    }

    @Override
    @Transactional
    public UserDTO findByUserId(Integer id) {
        User user = userRepositroy.findById(id).orElse(null);
        UserDTO userDTO=new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        eventServiceLog.addEvent(user, "GET_USER_BY_ID");
        return userDTO;
    }

    @Override
    public List<User> findAllUserDetails() {
        List<User> userlist = (List<User>) userRepositroy.findAll();
        eventServiceLog.addEvent(userlist, "GET_ALL_USER_BY_ID");
        return userlist;
    }


}

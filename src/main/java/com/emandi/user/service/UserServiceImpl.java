package com.emandi.user.service;


import com.emandi.user.dto.LoginDTO;
import com.emandi.user.dto.UserDTO;
import com.emandi.user.model.Role;
import com.emandi.user.model.User;
import com.emandi.user.repository.CustomerRepository;
import com.emandi.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CustomerRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EventServiceLog eventServiceLog;
   // @Autowired
//   private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserDTO userDTO) {
        User user=new User(userDTO);
        Set<Role> roles1 = new HashSet<>();
        roles1.add(new Role("user"));
        user.setRoles(roles1);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user1 = userRepository.save(user);
        //   eventServiceLog.addEvent(user1, "ADD_USER");
        return user1;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
        eventServiceLog.addEvent(id, "DELETE_USER");

    }

    @Override
    public User updateUser(Integer id, User user) {
        user.setId(id);
        User updatedUser = userRepository.save(user);
        eventServiceLog.addEvent(updatedUser, "UPDATE_USER");
        return updatedUser;
    }

    @Override
    @Transactional
    public UserDTO findByUserId(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        eventServiceLog.addEvent(user, "GET_USER_BY_ID");
        return userDTO;
    }

    @Override
    public List<User> findAllUserDetails() {
        List<User> userlist = (List<User>) userRepository.findAll();
        eventServiceLog.addEvent(userlist, "GET_ALL_USER_BY_ID");
        return userlist;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        User user = userRepository.findByUserNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
        if(user!=null){
            eventServiceLog.addEvent(loginDTO,"USER_LOGGED_IN");
            return "User LoggedIn successfully";
        }else{
            return "User details not found";
        }

    }


}

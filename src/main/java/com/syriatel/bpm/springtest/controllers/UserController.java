package com.syriatel.bpm.springtest.controllers;

import com.syriatel.bpm.springtest.entity.Role;
import com.syriatel.bpm.springtest.entity.User;
import com.syriatel.bpm.springtest.repo.Roles;
import com.syriatel.bpm.springtest.repo.Sections;
import com.syriatel.bpm.springtest.repo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private  final Users users;

    private final Roles roles;


    public UserController(Users users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return users.findAll();
    }
   @PostMapping("/user/add")
  public User addUser(@RequestBody User user){
      Optional<Role> temp=roles.findById(user.getRole().getId());
       Role tempq=temp.get();
       user.setRole(tempq);
//      Optional<Section> tem=sections.findById(user.getSection().getId());
//      Section section=tem.get();
//      user.setSection(section);
      return users.save(user);

          }
}

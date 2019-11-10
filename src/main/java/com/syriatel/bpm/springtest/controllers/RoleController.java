package com.syriatel.bpm.springtest.controllers;

import com.syriatel.bpm.springtest.entity.Role;
import com.syriatel.bpm.springtest.repo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RoleController {
    @Autowired
    private Roles roles;
    @GetMapping("/roles")
    public List<Role> allRplles(){
        List<Role> rol=roles.findAll();
        return rol;
    }
    @PostMapping("/roles/add")
    public Role addRole(@Valid @RequestBody Role ro){
       return roles.save(ro);
    }
    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Long id){
        Optional<Role> entity=roles.findById(id);
        Role ro=entity.get();
        if(ro==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body( ro);
        }
    }
    @PutMapping("roles/update/{id}")
    public ResponseEntity<Role> update(@PathVariable(value = "id") Long id,@RequestBody Role ro){
        Optional<Role> temp=roles.findById(id);
        Role rol=temp.get();
        if(rol==null){
            return ResponseEntity.notFound().build();
        }else{
            rol.setName(ro.getName());
            rol.setUsers(ro.getUsers());
            Role updatedRole=roles.save(rol);
            return ResponseEntity.ok().body(rol);
        }
    }
    @DeleteMapping("roles/delete/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable(value = "id") Long id){
        Optional<Role> temp=roles.findById(id);
        Role ro=temp.get();
        if(ro==null){
            return ResponseEntity.notFound().build();
        }else{
            roles.delete(ro);
            return ResponseEntity.ok().body(ro);
        }

    }
}

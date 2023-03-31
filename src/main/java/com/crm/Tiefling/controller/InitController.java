package com.crm.Tiefling.controller;

import com.crm.Tiefling.DTO.AuthorityDTO;
import com.crm.Tiefling.DTO.UserDTO;
import com.crm.Tiefling.arch.mappers.AuthorityMapper;
import com.crm.Tiefling.arch.mappers.UserMapper;
import com.crm.Tiefling.entity.Authority;
import com.crm.Tiefling.entity.User;
import com.crm.Tiefling.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InitController {
    @Autowired
    UserSevice userSevice;

    @GetMapping("/initial_filling")
    public List<AuthorityDTO> init(){
        List<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority("admin"));
        authorities.add(new Authority("dm"));
        authorities.add(new Authority("manager"));
        for (Authority authority: authorities) {
            userSevice.saveAuthority(authority);
        }
        return new AuthorityMapper().returnDTOList(authorities);
    }

    @GetMapping("/get_roles")
    public List<AuthorityDTO> getRoles(){
        return new AuthorityMapper().returnDTOList(userSevice.getAllAuthorities());
    }

    @GetMapping("/create_admin")
    public List<UserDTO> createAdmin(){
        User first = new User();
        first.setPassword("admin");
        first.setLogin("admin");
        ArrayList<Authority> authorities = new ArrayList<>();
        authorities.add(userSevice.getAuthorityByName("admin"));
        authorities.add(userSevice.getAuthorityByName("dm"));
        authorities.add(userSevice.getAuthorityByName("manager"));
        first.setAuthorities(authorities);
        userSevice.saveUser(first);
        return new UserMapper().returnDTOList(userSevice.getAllUsers());
    }
}

package com.crm.Tiefling.arch.mappers;

import com.crm.Tiefling.DTO.AuthorityDTO;
import com.crm.Tiefling.DTO.UserDTO;
import com.crm.Tiefling.entity.Authority;
import com.crm.Tiefling.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public List<UserDTO> returnDTOList(List<User> users){
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            List<AuthorityDTO> authorities = new AuthorityMapper()
                    .returnDTOList((List<Authority>) user.getAuthorities());
            dtos.add(new UserDTO(user.getId(), user.getLogin(), user.getPassword(), authorities));
        }

        return dtos;
    }

    public AuthorityDTO returnDTO(Authority authority){
        return new AuthorityDTO(authority.getId(), authority.getAuthority());
    }


}

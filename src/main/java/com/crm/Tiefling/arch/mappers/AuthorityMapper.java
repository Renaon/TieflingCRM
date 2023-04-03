package com.crm.Tiefling.arch.mappers;

import com.crm.Tiefling.DTO.AuthorityDTO;
import com.crm.Tiefling.entity.Authority;

import java.util.ArrayList;
import java.util.List;

public class AuthorityMapper {

    public List<AuthorityDTO> returnDTOList(List<Authority> authorities){
        List<AuthorityDTO> dtos = new ArrayList<>();
        for (Authority authority: authorities) {
            dtos.add(new AuthorityDTO(authority.getId(), authority.getAuthority()));
        }
        return dtos;
    }

    public AuthorityDTO returnDTO(Authority authority){
        return new AuthorityDTO(authority.getId(), authority.getAuthority());
    }
}

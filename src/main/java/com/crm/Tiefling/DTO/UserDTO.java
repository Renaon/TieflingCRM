package com.crm.Tiefling.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private final Long id;
    private final String login;
    private final String password;
    private final AuthorityDTO role;
}

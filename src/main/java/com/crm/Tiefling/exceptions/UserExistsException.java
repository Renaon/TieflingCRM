package com.crm.Tiefling.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserExistsException extends RuntimeException{
    private static final long serialVersionUID = 2L;
    private String message;
}

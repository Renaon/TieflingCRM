package com.crm.Tiefling.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FileStorageException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
}

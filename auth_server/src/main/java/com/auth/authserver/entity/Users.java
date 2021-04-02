package com.auth.authserver.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private Integer id;
    private String username;
    private String password;
}

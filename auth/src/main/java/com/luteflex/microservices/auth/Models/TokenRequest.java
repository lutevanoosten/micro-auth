package com.luteflex.microservices.auth.Models;

import javax.persistence.*;

@Entity
public class TokenRequest {


    private String id;

    private String name;
    private String role;
    private String avatar;

    public TokenRequest() {
    }

    public TokenRequest(String UserId, String Name, String Role, String Avatar) {
        id = UserId;
        name = Name;
        role = Role;
        avatar = Avatar;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public String getAvatar() {
        return avatar;
    }



}

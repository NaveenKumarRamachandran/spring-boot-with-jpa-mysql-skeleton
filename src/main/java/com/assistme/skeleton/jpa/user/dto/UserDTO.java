package com.assistme.skeleton.jpa.user.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * The type User dto.
 */
@Getter
@Setter
public class UserDTO {

    private String username;

    private String password;

    private String role;

    private boolean enabled;

}

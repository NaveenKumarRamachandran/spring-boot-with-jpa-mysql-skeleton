package com.assistme.skeleton.jpa.user;

import com.assistme.skeleton.jpa.user.dao.UserRepository;
import com.assistme.skeleton.jpa.user.entities.UserEntity;
import com.assistme.skeleton.jpa.utilities.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("api/v1/user")
@ComponentScan
public class UserController {

    /**
     * The User service.
     */
    @Autowired
    UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    /**
     * Gets user by username for token.
     * @return the user by username for token
     */
    @GetMapping("all")
    public List<UserEntity> getUserList() {
        List<UserEntity> userEntities = new ArrayList<>();
        return this.userRepository.findAll();
    }

    /**
     * Create user entity.
     * @param userDTO the user dto
     * @return the user entity
     */
    @PostMapping()
    public UserEntity createUser(@RequestBody() UserEntity userDTO) {
        return this.userRepository.save(userDTO);
    }

    /**
     * Update user entity.
     * @param username    the username
     * @param updatedUser the updated user
     * @return the user entity
     */
    @PutMapping("/user/{username}")
    public UserEntity updateUser(@PathVariable String username, @RequestBody UserEntity updatedUser) {
        updatedUser.setUsername(username);
        return userRepository.save(updatedUser);
    }

    /**
     * Delete user response dto.
     * @param username the username
     * @return the response dto
     */
    @DeleteMapping("/user/{username}")
    public ResponseDTO deleteUser(@PathVariable String username) {
        this.userRepository.deleteById(username);
        return new ResponseDTO(200, "User deleted Successfully");
    }


}


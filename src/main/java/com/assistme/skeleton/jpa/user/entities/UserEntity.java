package com.assistme.skeleton.jpa.user.entities;

import com.assistme.skeleton.jpa.todo.entities.TodoEntity;
import com.assistme.skeleton.jpa.utilities.TableName;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableName.USER_TABLE)
public class UserEntity {

    @Id
    @Column(name = "username", unique = true, length = 150)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "is_enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TodoEntity> todo = new ArrayList<>();


}

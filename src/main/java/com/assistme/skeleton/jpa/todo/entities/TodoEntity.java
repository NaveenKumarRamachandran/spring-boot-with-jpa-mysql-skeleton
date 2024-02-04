package com.assistme.skeleton.jpa.todo.entities;


import com.assistme.skeleton.jpa.user.entities.UserEntity;
import com.assistme.skeleton.jpa.utilities.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Todo entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableName.TODO_TABLE)
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username", foreignKey = @ForeignKey(name = "fk_todo_user_name"))
    private UserEntity user;
}

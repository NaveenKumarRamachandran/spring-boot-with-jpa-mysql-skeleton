package com.assistme.skeleton.jpa.todo.dao;

import com.assistme.skeleton.jpa.todo.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Todo repository.
 */
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {}

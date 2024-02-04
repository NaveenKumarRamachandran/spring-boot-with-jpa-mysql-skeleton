package com.assistme.skeleton.jpa.todo;

import com.assistme.skeleton.jpa.todo.dao.TodoRepository;
import com.assistme.skeleton.jpa.todo.entities.TodoEntity;
import com.assistme.skeleton.jpa.user.dao.UserRepository;
import com.assistme.skeleton.jpa.user.entities.UserEntity;
import com.assistme.skeleton.jpa.utilities.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

/**
 * The type Todo controller.
 */
@RestController
@RequestMapping("api/v1/todo")
@ComponentScan
public class TodoController {

    /**
     * The Todo service.
     */
    @Autowired
    TodoRepository todoRepository;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;



    /**
     * Update todo todo entity.
     * @param todoEntity the todo entity
     * @return the todo entity
     */
    @PutMapping
    public TodoEntity updateTodo(@RequestBody TodoEntity todoEntity) {
        return todoRepository.save(todoEntity);
    }

    /**
     * Delete response dto.
     * @param id the id
     * @return the response dto
     */
    @DeleteMapping("{id}")
    public ResponseDTO delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return new ResponseDTO(200, "Todo deleted Successfully");
    }

    /**
     * Gets todo.
     * @param id the id
     * @return the todo
     */
    @GetMapping("{id}")
    public TodoEntity getTodo(@PathVariable Long id) throws ConfigDataNotFoundException {
        Optional<TodoEntity> todoEntity = this.todoRepository.findById(id);
        return todoEntity.orElse(new TodoEntity());

    }

    /**
     * Gets all todo.
     * @return the all todo
     */
    @GetMapping("all")
    public List<TodoEntity> getAllTodo() {
        return this.todoRepository.findAll();
    }


    /**
     * Create Todo todo entity.
     * @param todoEntity the child
     * @param username   the parent id
     * @return the todo entity
     */
    @PostMapping("/create/{username}")
    public TodoEntity createTodo(@RequestBody TodoEntity todoEntity, @PathVariable String username) {
        UserEntity userEntity = userRepository.findById(username).get();
        todoEntity.setUser(userEntity);
        userEntity.getTodo().add(todoEntity);
        userRepository.save(userEntity);
        return todoEntity;
    }


}

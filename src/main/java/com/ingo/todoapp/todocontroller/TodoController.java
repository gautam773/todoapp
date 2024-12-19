package com.ingo.todoapp.todocontroller;

import com.ingo.todoapp.todoentity.TodoData;
import com.ingo.todoapp.todoentity.TodoDataDTO;
import com.ingo.todoapp.todoservice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todoApp")
@CrossOrigin
public class TodoController {

    @Autowired
    TodoService todoService;


    @PostMapping("findAllTodoForTheDay")
    public ResponseEntity<List<TodoDataDTO>> findAllTodoForTheDay(@RequestBody TodoDataDTO todoDataDTO)
    {
        List<TodoDataDTO> todoList = todoService.findAllTodoForTheDay(todoDataDTO);
        return new ResponseEntity<>(todoList,HttpStatus.OK);
    }

    @PostMapping("createTodoActivity")
    public ResponseEntity<String> createTodoActivity(@RequestBody TodoDataDTO todoDataDTO)
    {
        todoService.createTodoActivity(todoDataDTO);
        return new ResponseEntity<>("Todo created Successfully",HttpStatus.OK);
    }

    @DeleteMapping("removeTodo/{id}")
    public ResponseEntity<String> removeTodo(@PathVariable Long id)
    {
        todoService.removeTodo(id);
        return new ResponseEntity<>("Sucessfully Removed",HttpStatus.OK);
    }

    @PutMapping("updateTodo")
    public ResponseEntity<TodoDataDTO> updateTodo(@RequestBody TodoDataDTO dto)
    {
        TodoDataDTO response =  todoService.updateTodo(dto);
     return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

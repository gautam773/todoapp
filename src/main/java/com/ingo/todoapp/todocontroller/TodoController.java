package com.ingo.todoapp.todocontroller;

import com.ingo.todoapp.todoentity.TodoDataDTO;
import com.ingo.todoapp.todoservice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("todoApp")
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
}

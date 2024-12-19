package com.ingo.todoapp.todocontroller;

import com.ingo.todoapp.todoentity.TodoDataDTO;
import com.ingo.todoapp.todoservice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todoApp")
public class TodoController {

    @Autowired
    TodoService todoService;

    @CrossOrigin(origins = "https://todoapp-production-b5d4.up.railway.app")
    @PostMapping("findAllTodoForTheDay")
    public ResponseEntity<List<TodoDataDTO>> findAllTodoForTheDay(@RequestBody TodoDataDTO todoDataDTO)
    {
        List<TodoDataDTO> todoList = todoService.findAllTodoForTheDay(todoDataDTO);
        return new ResponseEntity<>(todoList,HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://todoapp-production-b5d4.up.railway.app")
    @PostMapping("createTodoActivity")
    public ResponseEntity<String> createTodoActivity(@RequestBody TodoDataDTO todoDataDTO)
    {
        todoService.createTodoActivity(todoDataDTO);
        return new ResponseEntity<>("Todo created Successfully",HttpStatus.OK);
    }
}

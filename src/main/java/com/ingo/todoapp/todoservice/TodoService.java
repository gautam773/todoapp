package com.ingo.todoapp.todoservice;

import com.ingo.todoapp.todoentity.TodoDataDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    List<TodoDataDTO> findAllTodoForTheDay(TodoDataDTO todoDataDTO);

    void createTodoActivity(TodoDataDTO todoDataDTO);
}

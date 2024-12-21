package com.ingo.todoapp.todoservice;

import com.ingo.todoapp.tododao.StatusDao;
import com.ingo.todoapp.tododao.TodoDao;
import com.ingo.todoapp.todoentity.TodoData;
import com.ingo.todoapp.todoentity.TodoDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoDao todoDao;
    @Autowired
    StatusDao statusDao;

    @Override
    public List<TodoDataDTO> findAllTodoForTheDay(TodoDataDTO todoDataDTO) {

        if(todoDataDTO != null)
        {
            String status = todoDataDTO.getStatus();
            String activity = todoDataDTO.getActivity();
            Date date = todoDataDTO.getDate();
            LocalTime time = todoDataDTO.getTime();
            System.out.println("status: " + status);
            System.out.println("activity: "+activity);
            System.out.println("date: "+date);
            System.out.println("time: "+time);
            List<TodoData> todoList = todoDao.findTodoList(date,time,activity,status);
            List<TodoDataDTO> dto = new ArrayList<>();
            if(!todoList.isEmpty())
            {
                for(TodoData data : todoList)
                {
                    TodoDataDTO dtoObj = new TodoDataDTO();
                    dtoObj.setActivity(data.getActivity());
                    dtoObj.setDate(data.getDate());
                    dtoObj.setTime(data.getTime());
                    dtoObj.setStatus(data.getStatus());
                    dtoObj.setId(data.getId());
                    dto.add(dtoObj);
                }
            }
            return dto;
        }
return new ArrayList<>();
    }

    @Override
    public void createTodoActivity(TodoDataDTO todoDataDTO) {
        if(null != todoDataDTO)
        {
            TodoData data = new TodoData();
            data.setDate(todoDataDTO.getDate());
            data.setTime(todoDataDTO.getTime());
            data.setActivity(todoDataDTO.getActivity());
            data.setStatus(todoDataDTO.getStatus());
            todoDao.save(data);
        }
    }

    @Override
    public void removeTodo(Long id) {
        todoDao.deleteById(id);
    }

    @Override
    public TodoDataDTO updateTodo(TodoDataDTO dto) {

        TodoData data = new TodoData();
        data.setDate(dto.getDate());
        data.setTime(dto.getTime());
        data.setActivity(dto.getActivity());
        data.setStatus(dto.getStatus());
        data.setId(dto.getId());
        TodoData updated = todoDao.save(data);
        TodoDataDTO dtoData = new TodoDataDTO();
        dtoData.setActivity(updated.getActivity());
        dtoData.setDate(updated.getDate());
        dtoData.setTime(updated.getTime());
        dtoData.setStatus(updated.getStatus());
        dtoData.setId(updated.getId());

        return dtoData;
    }

    @Override
    public List<String> fetchStatusList() {
        List<String> statusList = new ArrayList<>();
        statusList = statusDao.fetchStatusList();
        return statusList;
    }
}

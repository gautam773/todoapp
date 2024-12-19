package com.ingo.todoapp.tododao;

import com.ingo.todoapp.todoentity.TodoData;
import com.ingo.todoapp.todoentity.TodoDataDTO;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TodoDao  extends JpaRepository<TodoData,Long> {

    @Query(value="SELECT * FROM todo WHERE date IS NULL OR DATE = :date and :time IS NULL OR TIME = :time and :activity IS NULL or ACTIVITY=:activity and :status IS NULL OR STATUS=:status",nativeQuery=true)
    List<TodoData>  findTodoList(Date date, LocalTime time, String activity, String status);

}

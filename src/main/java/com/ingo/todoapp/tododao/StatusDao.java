package com.ingo.todoapp.tododao;

import com.ingo.todoapp.todoentity.StatusData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusDao extends JpaRepository<StatusData,String> {

    @Query(value = "SELECT STATUS FROM STATUS",nativeQuery = true)
    List<String> fetchStatusList();
}

package com.tsswebapps.todo.repositories;

import com.tsswebapps.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT todos FROM Todo todos WHERE todos.finalizado = false ORDER BY todos.dataParaFinalizar")
    List<Todo> findAllOpen();

    @Query("SELECT todos FROM Todo todos WHERE todos.finalizado = true ORDER BY todos.dataParaFinalizar")
    List<Todo> findAllClose();
}

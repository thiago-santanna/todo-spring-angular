package com.tsswebapps.todo.services;

import com.tsswebapps.todo.domain.Todo;
import com.tsswebapps.todo.repositories.TodoRepository;
import com.tsswebapps.todo.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo findById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("Todo não encontrado : id " +
                                id + ", tipo: " + Todo.class.getName()));
    }

    public List<Todo> findAllOpen() {
       List<Todo> todosAbertos = repository.findAllOpen();
       return todosAbertos;
    }

    public List<Todo> findAllClose() {
        List<Todo> todosFechados = repository.findAllClose();
        return todosFechados;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo create(Todo todo) {
        todo.setId(null);
        return repository.save(todo);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Todo update(Integer id, Todo todo) {
        Todo todoNew = findById(id);
        todoNew.setTitulo(todo.getTitulo());
        todoNew.setDescricao(todo.getDescricao());
        todoNew.setDataParaFinalizar(todo.getDataParaFinalizar());
        todoNew.setFinalizado(todo.getFinalizado());
        return repository.save(todoNew);
    }
}

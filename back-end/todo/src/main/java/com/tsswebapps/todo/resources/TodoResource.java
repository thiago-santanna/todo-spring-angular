package com.tsswebapps.todo.resources;

import com.tsswebapps.todo.domain.Todo;
import com.tsswebapps.todo.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todos")
public class TodoResource {

    private TodoService service;

    public TodoResource(TodoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo todo = service.findById(id);
        return ResponseEntity.ok().body(todo);
    }

    @GetMapping("/open")
    public ResponseEntity<List<Todo>> listOpen() {
        List<Todo> todosAbertos = service.findAllOpen();
        return ResponseEntity.ok().body(todosAbertos);
    }

    @GetMapping("/close")
    public ResponseEntity<List<Todo>> listClose() {
        List<Todo> todosFechados = service.findAllClose();
        return ResponseEntity.ok().body(todosFechados);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> allTodos = service.findAll();
        return ResponseEntity.ok().body(allTodos);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        todo = service.create(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).body(todo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
        Todo todoAlterado = service.update(id, todo);
        return ResponseEntity.ok().body(todoAlterado);
    }
}

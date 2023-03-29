package com.tsswebapps.todo.services;

import com.tsswebapps.todo.domain.Todo;
import com.tsswebapps.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DbService {
    @Autowired
    private TodoRepository repository;

    public boolean instaciaBaseDeDados() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Todo t1 = new Todo(null, "Estudar","Estudar Spring 2 e Angular 11 fullsatack", dateFormat.parse("22/03/2023"), true);
        Todo t2 = new Todo(null, "Estudar","Estudar Jira e sua utilizacao basica", dateFormat.parse("23/03/2023"), false);
        Todo t3 = new Todo(null, "Ensinar","Dar aula de algoritimo com a linguagem de programacao Java na escola Moderna", dateFormat.parse("28/03/2023"), true);
        Todo t4 = new Todo(null, "Estudar","Estudar Java efetivo e avancado", dateFormat.parse("29/03/2023"), false);
        Todo t5 = new Todo(null, "Ler","Programador Pragmatico e refltir em como posso melhorar como Dev", dateFormat.parse("30/03/2023"), false);
        Todo t6 = new Todo(null, "Financeiro","Fazer pagamentos das contas de casa", dateFormat.parse("06/04/2023"), false);
        repository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
        return true;
    }
}

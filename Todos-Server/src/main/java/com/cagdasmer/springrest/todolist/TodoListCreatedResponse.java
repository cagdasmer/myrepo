package com.cagdasmer.springrest.todolist;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class TodoListCreatedResponse {
    private String id;
    private String name;
    private List<TodoItem> items = new ArrayList<>();
    
    public TodoListCreatedResponse() {}

    public TodoListCreatedResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TodoListCreatedResponse from(TodoList todoList) {
        return new TodoListCreatedResponse(todoList.getId().toString(), todoList.getName());
    }
}

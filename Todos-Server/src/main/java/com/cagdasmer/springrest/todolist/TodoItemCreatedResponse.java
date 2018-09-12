package com.cagdasmer.springrest.todolist;

import lombok.Data;

@Data
public class TodoItemCreatedResponse {
    private String id;
    private String name;
    
    public TodoItemCreatedResponse() {}

    public TodoItemCreatedResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TodoItemCreatedResponse from(TodoItem todoItem) {
        return new TodoItemCreatedResponse(todoItem.getId().toString(), todoItem.getName());
    }
}

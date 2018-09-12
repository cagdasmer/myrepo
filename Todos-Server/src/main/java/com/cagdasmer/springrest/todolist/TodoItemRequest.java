package com.cagdasmer.springrest.todolist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoItemRequest {

    private boolean completed;
    private String name;
    
    public TodoItemRequest() {}

    public TodoItemRequest(String name) {
        this.name = name;
    }
}

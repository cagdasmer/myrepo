package com.cagdasmer.springrest.todolist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TodoListRequest {

    private String name;
    
    public TodoListRequest() {}

    public TodoListRequest(String name) {
        this.name = name;
    }

}

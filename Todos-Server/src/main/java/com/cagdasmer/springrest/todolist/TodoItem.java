package com.cagdasmer.springrest.todolist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.cagdasmer.springrest.todolist.TodoList;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = {"list"})
@Table(name="todo_item")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TodoList.class)
    @JoinColumn(name = "TODO_LIST_ID", insertable = true, updatable = true)
    @JsonIgnore
    private TodoList list;
    
    public TodoItem() {}
    
    public TodoItem(String name, TodoList list) {
        this.name = name;
        this.list = list;
    }
    
    public TodoItem(Long id, String name, TodoList list) {
    	this.id = id;
        this.name = name;
        this.list = list;
    }

    public static TodoItem from(TodoItemRequest todoItemRequest, TodoList todoList) {
        return new TodoItem(todoItemRequest.getName(), todoList);
    }

    public void merge(TodoItemRequest request) {
        this.name = request.getName();
        this.completed = request.isCompleted();
    }
}

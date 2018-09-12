package com.cagdasmer.springrest.todolist;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name="todo_list")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "list",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TodoItem> items = new ArrayList<>();

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + this.id +
                ", name='" + name + '\'' +
                '}';
    }
    
    public TodoList(String name) {
		this.name = name;
	}
    
    public TodoList(Long id, String name) {
    	this.id = id;
		this.name = name;
	}
    public static TodoList from(TodoListRequest todoListRequest) {
        return new TodoList(todoListRequest.getName());
    }

    public void merge(TodoListRequest request) {
        setName(request.getName());
    }
}

package com.cagdasmer.springrest.todolist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages="com.cagdasmer.springrest.todolist")
@DataJpaTest
public class TodoItemRepositoryTests {

    @Autowired
    TodoItemRepository repository;
    
    @Autowired
    private TestEntityManager entityManager;

    private TodoList todoList;

    @Before
    public void setUp() throws Exception {
    	todoList = entityManager.find(TodoList.class, 4L);
    }

    @Test
    public void testCreate() {
    	TodoList loadedTodoList = entityManager.find(TodoList.class, 2L);
        TodoItem todoItem = new TodoItem();
        todoItem.setName("Bookmark the documents");
        todoItem.setList(loadedTodoList);
        repository.save(todoItem);

        Optional<TodoItem> loadedItem = repository.findById(7L);
        if(loadedItem.isPresent()) {
        	assertThat(loadedItem.get().getName()).isEqualTo("Bookmark the documents");
        }
        assertThat(loadedTodoList.getItems()).contains(loadedItem.get());
    }

    @Test
    public void testGet() {
        TodoItem todoItem = repository.findOneByIdAndList(6L, todoList);
        assertThat(todoItem.getName()).isEqualTo("Prepare documentation for the application");
    }

    @Test
    public void testDelete() { 	
        repository.deleteByIdAndList(6L, todoList);
        System.out.println(repository.findById(6L));
        assertThat(repository.findById(6L)).isEmpty();
    }
}

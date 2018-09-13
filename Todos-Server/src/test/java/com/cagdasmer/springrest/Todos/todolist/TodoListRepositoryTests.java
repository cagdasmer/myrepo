package com.cagdasmer.springrest.todolist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages="com.cagdasmer.springrest.todolist")
@DataJpaTest
public class TodoListRepositoryTests {

    @Autowired
    private TodoListRepository repository;


    @Test
    public void testCreate() {
        TodoList list = new TodoList("List");
        repository.save(list);

        TodoList loadedList = repository.findOneById(5L);
        assertThat(loadedList.getItems()).isEmpty();
        assertThat(loadedList.getName()).isEqualTo("List");
    }

    @Test
    public void testGet() {
        TodoList todoList = repository.findOneById(1L);

        assertThat(todoList.getName()).isEqualTo("Research");
    }

    @Test
    public void testList() {
        List<TodoList> lists = repository.findAll();
        assertThat(lists.size()).isEqualTo(4);
    }

    @Test
    public void testDelete() {
        repository.deleteById(1L);
        assertNull(repository.findOneById(1L));
    }
}

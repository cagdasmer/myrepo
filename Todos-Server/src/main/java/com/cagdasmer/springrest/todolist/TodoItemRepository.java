package com.cagdasmer.springrest.todolist;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@RepositoryRestResource
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    TodoItem findOneByIdAndList(Long id, TodoList todoList);

    @Transactional
    void deleteByIdAndList(Long id, TodoList todoList);
}

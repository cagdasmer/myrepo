package com.cagdasmer.springrest.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    TodoList findOneById(Long id);

    @Transactional
    void deleteById(Long id);
}

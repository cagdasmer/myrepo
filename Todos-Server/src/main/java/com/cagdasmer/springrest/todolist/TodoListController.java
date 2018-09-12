package com.cagdasmer.springrest.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cagdasmer.springrest.todolist.TodoItemRepository;
import com.cagdasmer.springrest.todolist.TodoListRepository;

import com.cagdasmer.springrest.todolist.TodoItem;
import com.cagdasmer.springrest.todolist.TodoItemCreatedResponse;
import com.cagdasmer.springrest.todolist.TodoItemRequest;
import com.cagdasmer.springrest.todolist.TodoListCreatedResponse;
import com.cagdasmer.springrest.todolist.TodoListRequest;

import com.cagdasmer.springrest.todolist.TodoList;


import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {
	
	@Autowired
    private TodoListRepository repository;
	
	@Autowired
    private TodoItemRepository iRepository;
	
	
	//WORKS
	@GetMapping("/lists")
//	@CrossOrigin(origins = "http://localhost:3000")
    public List<TodoList> index(){
		return repository.findAll();
    }
	
	//WORKS
    @GetMapping("/lists/{id}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public TodoList show(@PathVariable String id){
        Long blogId = Long.parseLong(String.valueOf(id));
        return repository.findOneById(blogId);
    }

    //WORKS
    @PostMapping("/lists")
//    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TodoListCreatedResponse> create(@RequestBody TodoListRequest todoListRequest) {
    		TodoList todoList = repository.save(TodoList.from(todoListRequest));
    		return new ResponseEntity<>(TodoListCreatedResponse.from(todoList), HttpStatus.CREATED);
    }
    
    //WORKS
    @PostMapping("/lists/{id}/items")
//    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TodoItemCreatedResponse> createItem(@PathVariable("id") Long id, @RequestBody TodoItemRequest todoItemRequest) {
        TodoList todoList = repository.findOneById(id);
        TodoItem todoItem = iRepository.save(TodoItem.from(todoItemRequest, todoList));
        return new ResponseEntity<>(TodoItemCreatedResponse.from(todoItem), HttpStatus.CREATED);
    }

    //WORKS
    @PutMapping("/lists/{id}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public TodoList update(@PathVariable("id") Long id, @RequestBody TodoList Request){
        //Long listId = Long.parseLong(String.valueOf(id));
        TodoList list = repository.findOneById(id);
        list.setName(Request.getName());
        return repository.save(list);
    }
    
  //WORKS
    @PutMapping("/lists/{id}/items/{itemId}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public boolean updateItem(@PathVariable("id") Long id,
                                             @PathVariable("itemId") Long itemId,
                                             @RequestBody TodoItemRequest request) {
        TodoList todoList = repository.findOneById(id);
        TodoItem todoItem = iRepository.findOneByIdAndList(itemId, todoList);
        todoItem.merge(request);
        iRepository.save(todoItem);
        return true;
     }

    //WORKS
    @DeleteMapping("lists/{id}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public boolean delete(@PathVariable Long id){
    	//Long listId = Long.parseLong(String.valueOf(id));
        repository.deleteById(id);
        return true;
    }
    
    //WORKS
    @DeleteMapping("/lists/{id}/items/{itemId}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public boolean deleteItem(@PathVariable("id") Long id,
                                         @PathVariable("itemId") Long itemId ) {
//    	Long listId = Long.parseLong(String.valueOf(id));
//    	Long itemId = Long.parseLong(String.valueOf(mId));
    	TodoList todoList = repository.findOneById(id);
    	iRepository.deleteByIdAndList(itemId, todoList);
    	return true;
    }

}

package com.cagdasmer.springrest.todolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoListCommandLineRunner implements CommandLineRunner {

//	private final TodoListRepository repository;
//
//	@Autowired
//	public TodoListCommandLineRunner(TodoListRepository repository) {
//		this.repository = repository;
//	}
//
//	@Override
//	public void run(String... strings) throws Exception {
//		
//        // Top beers from https://www.beeradvocate.com/lists/top/
//        Stream.of("Research", "Study", "Develop", "Document")
//        .forEach(name ->repository.save(new TodoList(name))
//        );
//        repository.findAll().forEach(System.out::println);
//    }
	private static final Logger log = LoggerFactory.getLogger(TodoListCommandLineRunner.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE todo_list IF EXISTS CASCADE");
        jdbcTemplate.execute("CREATE TABLE todo_list(" +
                "id SERIAL, name VARCHAR(255))");
        
        jdbcTemplate.execute("DROP TABLE todo_item IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE todo_item(id SERIAL, " + 
        							" name VARCHAR(255), " + 
        							"   todo_list_id BIGINT, " + 
        							"   completed BOOLEAN )" );
//        							"   CONSTRAINT items_ibfk_1 FOREIGN KEY (todo_list_id) REFERENCES todo_list (id), " + 
//        							"   CONSTRAINT test_pkey PRIMARY KEY (id, todo_list_id))");
        
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.execute("INSERT INTO todo_list(name) VALUES('Research')");
        jdbcTemplate.execute("INSERT INTO todo_list(name) VALUES('Study')");
        jdbcTemplate.execute("INSERT INTO todo_list(name) VALUES('Develop')");
        jdbcTemplate.execute("INSERT INTO todo_list(name) VALUES('Document')");
        
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Look for online tutorials', 1, true)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Look for books', 1, true)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Study the documents', 2, false)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Develop the back-end', 3, false)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Develop the front-end', 3, false)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Prepare documentation for the application', 4, false)");
        
//        log.info("Querying for todolist records where name = 'Josh':");
//        jdbcTemplate.query(
//                "SELECT id, name FROM todo_list WHERE id = ?", new Object[] { 2 },
//                (rs, rowNum) -> new TodoList(rs.getString("name"))).forEach(TodoList -> log.info(TodoList.toString())
//                		);
//        log.info("Querying for todolist records");
//        jdbcTemplate.query(
//              "SELECT * FROM todo_list",
//              (rs, rowNum) -> (rs.getString("name"))).forEach(TodoList -> log.info(TodoList.toString())
//              		);
//        log.info("Querying for todoitem records");
//        jdbcTemplate.query(
//                "SELECT * FROM todo_item",
//                (rs, rowNum) -> new TodoItem(rs.getString("name"), rs.getInt("todo_list_id"), 
//                		rs.getBoolean("completed"))).forEach(TodoItem -> log.info(TodoItem.toString())
//                				);
    }
}

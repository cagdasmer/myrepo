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
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Develop the back-end', 3, true)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Develop the front-end', 3, false)");
        jdbcTemplate.execute("INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Prepare documentation for the application', 4, false)");
        
    }
}

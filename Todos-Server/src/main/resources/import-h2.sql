DROP TABLE IF EXISTS todo_list CASCADE;
CREATE TABLE todo_list(id SERIAL, 
					   name VARCHAR(255), 
					   PRIMARY KEY (id));
        
DROP TABLE IF EXISTS todo_item;
CREATE TABLE todo_item(id BIGINT, 
					   name VARCHAR(255), 
					   todo_list_id BIGINT, 
					   completed BOOLEAN, 
					   CONSTRAINT items_ibfk_1 FOREIGN KEY (todo_list_id) REFERENCES todo_list (id),
					   CONSTRAINT test_pkey PRIMARY KEY (id, todo_list_id));
        

INSERT INTO todo_list(name) VALUES('Research');
INSERT INTO todo_list(name) VALUES('Study');
INSERT INTO todo_list(name) VALUES('Develop');
INSERT INTO todo_list(name) VALUES('Document');
        
INSERT INTO todo_item(id, name, todo_list_id, completed) VALUES(1, 'Look for online tutorials', 1, true);
INSERT INTO todo_item(id, name, todo_list_id, completed) VALUES(2, 'Look for books', 1, true);
INSERT INTO todo_item(id, name, todo_list_id, completed) VALUES(1, 'Study the documents', 2, false);
INSERT INTO todo_item(id, name, todo_list_id, completed) VALUES(1, 'Develop the back-end', 3, false);
INSERT INTO todo_item(id, name, todo_list_id, completed) VALUES(2, 'Develop the front-end', 3, false);
INSERT INTO todo_item(id, name, todo_list_id, completed) VALUES(1, 'Prepare documentation for the application', 4, false);
														
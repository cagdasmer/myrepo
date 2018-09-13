DROP TABLE IF EXISTS todo_list CASCADE;
CREATE TABLE todo_list(id SERIAL, 
					   name VARCHAR(255));
        
DROP TABLE IF EXISTS todo_item;
CREATE TABLE todo_item(id SERIAL, 
					   name VARCHAR(255), 
					   todo_list_id BIGINT, 
					   completed BOOLEAN);
        

INSERT INTO todo_list(name) VALUES('Research');
INSERT INTO todo_list(name) VALUES('Study');
INSERT INTO todo_list(name) VALUES('Develop');
INSERT INTO todo_list(name) VALUES('Document');
        
INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Look for online tutorials', 1, true);
INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Look for books', 1, true);
INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Study the documents', 2, false);
INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Develop the back-end', 3, true);
INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Develop the front-end', 3, false);
INSERT INTO todo_item(name, todo_list_id, completed) VALUES('Prepare documentation for the application', 4, false);
														

-- Authors
INSERT INTO AUTHOR (id, name) VALUES (1, 'Robert C. Martin');
INSERT INTO AUTHOR (id, name) VALUES (2, 'Martin Fowler');
INSERT INTO AUTHOR (id, name) VALUES (3, 'Joshua Bloch');
INSERT INTO AUTHOR (id, name) VALUES (4, 'Eric Evans');
INSERT INTO AUTHOR (id, name) VALUES (5, 'Kent Beck');
INSERT INTO AUTHOR (id, name) VALUES (6, 'Brian Goetz');
INSERT INTO AUTHOR (id, name) VALUES (7, 'Rod Johnson');

-- Books
INSERT INTO BOOK (id, title, author_id) VALUES (1, 'Clean Code', 1);
INSERT INTO BOOK (id, title, author_id) VALUES (2, 'Clean Architecture', 1);
INSERT INTO BOOK (id, title, author_id) VALUES (3, 'Refactoring', 2);
INSERT INTO BOOK (id, title, author_id) VALUES (4, 'Patterns of Enterprise Application Architecture', 2);
INSERT INTO BOOK (id, title, author_id) VALUES (5, 'Effective Java', 3);
INSERT INTO BOOK (id, title, author_id) VALUES (6, 'Domain-Driven Design', 4);
INSERT INTO BOOK (id, title, author_id) VALUES (7, 'Test-Driven Development', 5);
INSERT INTO BOOK (id, title, author_id) VALUES (8, 'Java Concurrency in Practice', 6);
INSERT INTO BOOK (id, title, author_id) VALUES (9, 'Expert One-on-One J2EE Design and Development', 7);

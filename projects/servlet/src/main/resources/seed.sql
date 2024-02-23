CREATE DATABASE jee_tp_db;
USE jee_tp_db;

DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;

CREATE TABLE category (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES category(id)
);

INSERT INTO category (id, name) VALUES
(1, 'Electronics'),
(2, 'Books');

INSERT INTO product (id, name, categoryId) VALUES
(1, 'Laptop', 1),
(2, 'Headphones', 1),
(3, 'Harry Potter', 2),
(4, 'Lord of the Rings', 2);

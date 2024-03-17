DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (id, login, password) VALUES
(1, 'user1', 'password1'),
(2, 'user2', 'password2');

CREATE TABLE category (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    categoryId INT,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (categoryId) REFERENCES category(id)
);

INSERT INTO category (id, name) VALUES
(1, 'Electronics'),
(2, 'Books');

INSERT INTO product (id, name, categoryId, quantity, price) VALUES
(1, 'Laptop', 1, 10, 999.99),
(2, 'Headphones', 1, 20, 49.99),
(3, 'Harry Potter', 2, 30, 19.99),
(4, 'Lord of the Rings', 2, 40, 29.99);

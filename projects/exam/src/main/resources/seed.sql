USE jee_exam;

DROP TABLE IF EXISTS utilisateur;
DROP TABLE IF EXISTS chambre;

CREATE TABLE utilisateur (
    cin int PRIMARY KEY,
    role VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    addresse VARCHAR(255) NOT NULL
);

CREATE TABLE chambre (
    id int PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    etat VARCHAR(255) NOT NULL
)

INSERT INTO utilisateur (cin, role, nom, prenom, login, password, addresse) VALUES
(1, 'admin', 'Adminer', 'User A', 'admin', 'password', '123 Admin St'),
(2, 'student', 'Studenter', 'User S', 'student', 'password', '456 Student St');

INSERT INTO chambre (id, nom, etat) VALUES
(1, 'Chambre 1', 'Available'),
(2, 'Chambre 2', 'Occupied'),
(3, 'Chambre 3', 'Available');

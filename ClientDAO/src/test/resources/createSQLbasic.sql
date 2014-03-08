DROP TABLE IF EXISTS Personne;

create table Personne (
    id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    nom_naissance varchar(30) not null,
    nom_usage varchar(30) not null,
    prenom varchar(30) not null,
    dt_naissance timestamp  not null,
    dt_deces timestamp,
    genre varchar(30) not null
);

insert into Personne (nom_naissance,nom_usage,prenom,dt_naissance,dt_deces,genre) values 
('Dupond','Dupond','Louis',DATE '1913-03-12', null,'Homme');

insert into Personne (nom_naissance,nom_usage,prenom,dt_naissance,dt_deces,genre) values 
('Jenkins','Jenkins','Jhon',DATE '1973-06-11', null,'Homme');


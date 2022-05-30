create table title_directors
(
    id          int auto_increment
        primary key,
    title_id    int not null,
    director_id int not null,
    constraint title_directors_director_id_fk
        foreign key (director_id) references director (id),
    constraint title_directors_title_id_fk
        foreign key (director_id) references title (id)
);


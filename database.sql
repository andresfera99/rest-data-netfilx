create table actor
(
    id int auto_increment
        primary key
);
create table category
(
    id int auto_increment
        primary key
);
create table director
(
    id int auto_increment
        primary key
);
create table title
(
    id int auto_increment
        primary key
);
create table title_actor
(
    id       int auto_increment
        primary key,
    title_id int not null,
    actor_id int not null,
    constraint title_actor_actor_id_fk
        foreign key (actor_id) references actor (id),
    constraint title_actor_title_id_fk
        foreign key (title_id) references title (id)
);
create table title_category
(
    id          int auto_increment
        primary key,
    title_id    int not null,
    category_id int not null,
    constraint title_category_category_id_fk
        foreign key (category_id) references category (id),
    constraint title_category_title_id_fk
        foreign key (title_id) references title (id)
);
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
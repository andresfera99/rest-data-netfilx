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


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


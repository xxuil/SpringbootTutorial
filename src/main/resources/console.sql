use test;
drop table post;
create table post
(
    pid         int auto_increment,
    title       varchar(255) not null,
    content     varchar(255) not null,
    time        varchar(255) not null,
    userId      int not null,
    viewCount   int not null,
    replyCount  int not null,
    primary key (pid)
) engine=InnoDB default charset = utf8;

create table user
(
    uid         int auto_increment,
    username    varchar(255) not null,
    password    varchar(255) not null,
    primary key (uid)
) engine=InnoDB default charset = utf8;

create table reply
(
    rid         int auto_increment,
    content     varchar(255) not null,
    postId      int not null,
    userId      int not null,
    time        varchar(255) not null,
    primary key (rid)
) engine=InnoDB default charset = utf8


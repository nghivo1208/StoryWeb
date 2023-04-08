drop database story_web;
create database story_web;
use story_web;
CREATE TABLE IF NOT EXISTS roles (
     id INT NOT NULL AUTO_INCREMENT,
     name VARCHAR(50),
    description VARCHAR(100),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS users (
     id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    password VARCHAR(25),
    fullname VARCHAR(255),
    login_id VARCHAR(25),
    id_number integer(12) default 0,
    address varchar(255),
    stp int default 0,
    warning_times int default 0,
    status boolean default 0,
    role_id int,
    PRIMARY KEY (id),
    foreign key(role_id) references roles(id)
    );

CREATE TABLE IF NOT EXISTS follows (
    id INT NOT NULL AUTO_INCREMENT,
    user_fl_id int not null,
    user_followed_id int not null,
    PRIMARY KEY (id),
    foreign key(user_fl_id) references users(id),
    foreign key(user_followed_id) references users(id)
    );

CREATE TABLE IF NOT EXISTS report_types (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS reports (
    id INT NOT NULL AUTO_INCREMENT,
    user_report int not null,
    user_reported int not null,
    report_type_id int not null,
    PRIMARY KEY (id),
    foreign key(user_report) references users(id),
    foreign key(user_reported) references users(id),
    foreign key(report_type_id) references report_types(id)
    );

CREATE TABLE IF NOT EXISTS ledger (
    id INT NOT NULL AUTO_INCREMENT,
    inbound_account_id int not null,
    outbound_account_id int not null,
    amount int default 0,
    date_ledger Long,
    description varchar(225),

    PRIMARY KEY (id),
    foreign key(inbound_account_id) references users(id),
    foreign key(outbound_account_id) references users(id)
    );

CREATE TABLE IF NOT EXISTS chapters (
    id INT NOT NULL AUTO_INCREMENT,
    chapter_order int not null,
    chapter_title varchar(255),
    date_submitted Long,
    content_url varchar(255),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS categories (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),

    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS interact_types (
                                              id INT NOT NULL AUTO_INCREMENT,
                                              name varchar(255),
    description varchar(255),

    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS literaries (
                                          id INT NOT NULL AUTO_INCREMENT,
                                          category_id int not null,
                                          account_id int not null,
                                          literary_name varchar(255),
    age int (100),
    is_Plus int default 0,
    date_submitted Long,
    summary varchar(255),

    PRIMARY KEY (id),
    foreign key(category_id) references categories(id),
    foreign key(account_id) references users(id)
    );

CREATE TABLE IF NOT EXISTS comments(
                                       id INT NOT NULL AUTO_INCREMENT,
                                       account_id int not null,
                                       literary_id int not null,
                                       content varchar(255),
    comment_time Long ,


    PRIMARY KEY (id),
    foreign key(literary_id) references literaries(id),
    foreign key(account_id) references users(id)
    );

CREATE TABLE IF NOT EXISTS views(
                                    id INT NOT NULL AUTO_INCREMENT,
                                    account_id int not null,
                                    literary_id int not null,
                                    time_view Long ,

                                    PRIMARY KEY (id),
    foreign key(literary_id) references literaries(id),
    foreign key(account_id) references users(id)
    );

CREATE TABLE IF NOT EXISTS interactions(
       id INT NOT NULL AUTO_INCREMENT,
       account_id int not null,
       literary_id int not null,
       interact_type int not null,
       interact_time Long ,

       PRIMARY KEY (id),
    foreign key(literary_id) references literaries(id),
    foreign key(account_id) references users(id),
    foreign key(interact_type) references interact_types(id)
    );


insert into roles (name) values ("ADMIN");
insert into roles (name) values ("MENBER");
insert into roles (name) values ("USER");
INSERT INTO `story_web`.`users` (`email`, `password`, `fullname`, `role_id`) VALUES ('admin@gmail.com', '123', 'ADMIN', '1');
INSERT INTO `story_web`.`users` (`email`, `password`, `fullname`, `role_id`) VALUES ('abc@gmail.com', '123', 'Member', '2');
INSERT INTO `story_web`.`users` (`email`, `password`, `fullname`, `role_id`) VALUES ('nguyenvana@gmail.com', '123', 'Nguyen Van A', '3');
INSERT INTO `story_web`.`interact_types` (`name`) VALUES ('No react');
INSERT INTO `story_web`.`interact_types` (`name`) VALUES ('Like');
INSERT INTO `story_web`.`interact_types` (`name`) VALUES ('Dislike');
INSERT INTO `story_web`.`report_types` (`name`) VALUES ('Age inappropriate');
INSERT INTO `story_web`.`report_types` (`name`) VALUES ('Extreme creed');
INSERT INTO `story_web`.`report_types` (`name`) VALUES ('Anti-political views');
INSERT INTO `story_web`.`report_types` (`name`) VALUES ('Anti social');

INSERT INTO `story_web`.`categories` (`name`) VALUES ('Actions');
INSERT INTO `story_web`.`categories` (`name`) VALUES ('Fantasy');
INSERT INTO `story_web`.`categories` (`name`) VALUES ('Romantic');
INSERT INTO `story_web`.`categories` (`name`) VALUES ('Adventure');
INSERT INTO `story_web`.`categories` (`name`) VALUES ('History');
INSERT INTO `story_web`.`categories` (`name`) VALUES ('Fiction');

use story_web;
select * from users;
drop database story_web;
>>>>>>> master

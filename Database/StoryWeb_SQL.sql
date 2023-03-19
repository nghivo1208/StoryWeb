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
    id_number integer(12),
    address varchar(255),
    stp int default 0,
    warning_times integer,
    status boolean,
    role_id integer,
    PRIMARY KEY (id),
    foreign key(role_id) references roles(id)
);

CREATE TABLE IF NOT EXISTS follows (
    id INT NOT NULL AUTO_INCREMENT,
    user_fl_id int,
    user_followed_id int,
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
    user_report int,
    user_reported int,
    report_type_id int,
    PRIMARY KEY (id),
    foreign key(user_report) references users(id),
    foreign key(user_reported) references users(id),
    foreign key(report_type_id) references report_types(id)
);

CREATE TABLE IF NOT EXISTS ledger (
    id INT NOT NULL AUTO_INCREMENT,
    inbound_account_id int,
    outbound_account_id int,
    amount int default 0,
    date_ledger Long,
    description varchar(225),
    
    PRIMARY KEY (id),
    foreign key(inbound_account_id) references users(id),
    foreign key(outbound_account_id) references users(id)
);

CREATE TABLE IF NOT EXISTS chapters (
    id INT NOT NULL AUTO_INCREMENT,
    chapter_order int,
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
    category_id int,
    account_id int,
    literary_name varchar(255),
    age int (100),
    isPlus boolean,
    date_submitted Long,
    summary varchar(255),
    chapter_id int,
    
    PRIMARY KEY (id),
    foreign key(chapter_id) references chapters(id),
    foreign key(category_id) references categories(id),
    foreign key(account_id) references users(id)
);

CREATE TABLE IF NOT EXISTS comments(
    id INT NOT NULL AUTO_INCREMENT,
    account_id int,
    literary_id int,
    content varchar(255),
    comment_time Long,
    
    
    PRIMARY KEY (id),
    foreign key(literary_id) references literaries(id),
    foreign key(account_id) references users(id)
);

CREATE TABLE IF NOT EXISTS views(
    id INT NOT NULL AUTO_INCREMENT,
    account_id int,
    literary_id int,
    time_view Long,

    PRIMARY KEY (id),
    foreign key(literary_id) references literaries(id),
    foreign key(account_id) references users(id)
);

CREATE TABLE IF NOT EXISTS interactions(
    id INT NOT NULL AUTO_INCREMENT,
    account_id int,
    literary_id int,
    interact_type int,
	interact_time Long,

    PRIMARY KEY (id),
    foreign key(literary_id) references literaries(id),
    foreign key(account_id) references users(id),
    foreign key(interact_type) references interact_types(id)
);

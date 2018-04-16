CREATE TABLE course
(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    description text,
    code varchar(50),
    pensum int
);

CREATE TABLE course_history
(
    id int PRIMARY KEY AUTO_INCREMENT,
    course_id int,
    professor_id int,
    date datetime
);

CREATE TABLE assigned_course
(
    id int PRIMARY KEY AUTO_INCREMENT,
    course_history_id int,
    student_id int
);

CREATE TABLE role
(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45)
);

CREATE TABLE user_role
(
    id int PRIMARY KEY AUTO_INCREMENT,
    user_id int,
    role_id int,
    CONSTRAINT user_role_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT user_role_role_id_fk FOREIGN KEY (role_id) REFERENCES role (id)
);

ALTER TABLE course_history
ADD CONSTRAINT course_history_user_id_fk
FOREIGN KEY (professor_id) REFERENCES user (id);
ALTER TABLE course_history
ADD CONSTRAINT course_history_course_id_fk
FOREIGN KEY (course_id) REFERENCES course (id);

ALTER TABLE assigned_course
			ADD CONSTRAINT assigned_course_course_history_id_fk
			FOREIGN KEY (course_history_id) REFERENCES course_history (id);

ALTER TABLE assigned_course
ADD CONSTRAINT assigned_course_user_id_fk
FOREIGN KEY (student_id) REFERENCES user (id);

ALTER TABLE course_history ADD section int NULL;

ALTER TABLE course_history MODIFY section varchar(10);
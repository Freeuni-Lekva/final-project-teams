USE test;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS friends;
DROP TABLE IF EXISTS quizzes;
DROP TABLE IF EXISTS question_response;
DROP TABLE IF EXISTS picture_response;
DROP TABLE IF EXISTS fill_blank;
DROP TABLE IF EXISTS multiple_choice;


CREATE TABLE accounts(
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(255) UNIQUE NOT NULL,
                         password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE friends(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        friend_id1 INT NOT NULL,
                        friend_id2 INT NOT NULL,
                        CONSTRAINT fk_friend_id1 FOREIGN KEY (friend_id1) REFERENCES accounts(id),
                        CONSTRAINT fk_friend_id2 FOREIGN KEY (friend_id2) REFERENCES accounts(id)
);

CREATE TABLE quizzes(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255),
                        description VARCHAR(255)
);

CREATE TABLE question_response(
                                quiz_id INT,
                                question VARCHAR(255),
                                answer VARCHAR(255)
);

CREATE TABLE picture_response(
                                  quiz_id INT,
                                  url VARCHAR(255),
                                  answer VARCHAR(255)
);

CREATE TABLE fill_blank(
                                 quiz_id INT,
                                 first_part VARCHAR(255),
                                 second_part VARCHAR(255),
                                 answer VARCHAR(255)
);

CREATE TABLE multiple_choice(
                           quiz_id INT,
                           question VARCHAR(255),
                           correct_answer VARCHAR(255),
                           answer1 VARCHAR(255),
                           answer2 VARCHAR(255),
                           answer3 VARCHAR(255),
                           answer4 VARCHAR(255),
                           answer5 VARCHAR(255),
                           answer6 VARCHAR(255)
);
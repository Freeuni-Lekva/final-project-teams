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
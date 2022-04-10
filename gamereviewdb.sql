--
-- CREATE DATABASE IF NOT EXISTS
-- USE gamereviewdb
--
CREATE DATABASE IF NOT EXISTS gamereviewdb;
USE gamereviewdb;

--
-- DROP TABLES IN CORRECT ORDER
--
DROP TABLE IF EXISTS users;

--
-- Create table for user logins
--
CREATE TABLE users
(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	username VARCHAR(20),
    password VARCHAR(20),
    PRIMARY KEY (id)
)
ENGINE 
	INNODB
CHARSET
	utf8
COLLATE
	utf8_swedish_ci
;


--
-- Create procedure for create user
--
DROP PROCEDURE IF EXISTS create_account;
DELIMITER ;;
CREATE PROCEDURE create_account(
    a_username VARCHAR(20),
    a_password VARCHAR(20)
)
BEGIN
    INSERT INTO user_logins (username, password) VALUES (a_username, a_password);
END
;;
DELIMITER ;


SELECT * FROM users;


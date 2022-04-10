--
-- CREATE DATABASE IF NOT EXISTS
-- USE gamereviewdb
--
CREATE DATABASE IF NOT EXISTS gamereviewdb;
USE gamereviewdb;

--
-- DROP TABLES IN CORRECT ORDER
--
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS appuser;


--
-- Create table for user logins
--
CREATE TABLE appuser
(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	username VARCHAR(50),
    password VARCHAR(100),
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
-- Create table for games
--
CREATE TABLE game
(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	gameTitle VARCHAR(50),
    gameDeveloper VARCHAR(100),
    releaseYear int,
    PRIMARY KEY (id)
);

--
-- Create table for review
--
CREATE TABLE review
(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	gameTitle VARCHAR(50),
    reviewText VARCHAR(500),
    reviewPlus VARCHAR(100),
    reviewMinus VARCHAR(100),
    reviewScore int,
    PRIMARY KEY (id)
);


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
    INSERT INTO appuser (username, password) 
    VALUES (a_username, a_password);
END
;;
DELIMITER ;


--
-- Create procedure for create game
--
DROP PROCEDURE IF EXISTS create_game;
DELIMITER ;;
CREATE PROCEDURE create_game(
	a_gameTitle VARCHAR(50),
    a_gameDeveloper VARCHAR(100),
    a_releaseYear int
)
BEGIN
    INSERT INTO game (gameTitle, gameDeveloper, releaseYear) 
    VALUES (a_gameTitle, a_gameDeveloper, a_releaseYear);
END
;;
DELIMITER ;


--
-- Create procedure for create review
--
DROP PROCEDURE IF EXISTS create_review;
DELIMITER ;;
CREATE PROCEDURE create_review(
	a_gameTitle VARCHAR(50),
    a_reviewText VARCHAR(500),
    a_reviewPlus VARCHAR(100),
    a_reviewMinus VARCHAR(100),
    a_reviewScore int
)
BEGIN
    INSERT INTO review (gameTitle, reviewText, reviewPlus, reviewMinus, reviewScore) 
    VALUES (a_gameTitle, a_reviewText, a_reviewPlus, a_reviewMinus, a_reviewScore);
END
;;
DELIMITER ;


SELECT * FROM appuser;
SELECT * FROM game;
SELECT * FROM review;


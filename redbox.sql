CREATE DATABASE IF NOT EXISTS redbox;

USE redbox;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- Admin Table
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) NULL DEFAULT NULL,
  `admin_password` varchar(255) NULL DEFAULT NULL,
  `admin_name` varchar(255) NULL DEFAULT NULL,
  `admin_sex` varchar(255) NULL DEFAULT NULL,
  `admin_age` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3;

-- Alog Table
DROP TABLE IF EXISTS `alog`;
CREATE TABLE `alog` (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_id` int(0) NULL DEFAULT NULL,
  `admin_username` varchar(255) NULL DEFAULT NULL,
  `admin_password` varchar(255) NULL DEFAULT NULL,
  `admin_name` varchar(255) NULL DEFAULT NULL,
  `admin_sex` varchar(255) NULL DEFAULT NULL,
  `admin_age` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2;

-- dvd Table
DROP TABLE IF EXISTS `dvd`;
CREATE TABLE `dvd` (
  `dvd_id` int(0) NOT NULL,
  `dvd_name` varchar(255) NULL DEFAULT NULL,
  `dvd_price` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`dvd_id`)
) ENGINE = InnoDB;

-- Borrow Table
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `admin_id` int(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  `dvd_id` int(0) NOT NULL,
  `time` varchar(225) NULL DEFAULT NULL,
  `now_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`, `user_id`, `dvd_id`),
  FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`dvd_id`) REFERENCES `dvd` (`dvd_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Borrowed Table
DROP TABLE IF EXISTS `borrowed`;
CREATE TABLE `borrowed` (
  `admin_id` int(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  `dvd_id` int(0) NOT NULL,
  `time` varchar(255) NULL DEFAULT NULL,
  `now_time` datetime(0) NULL DEFAULT NULL,
  `back_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`, `user_id`, `dvd_id`),
  FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`dvd_id`) REFERENCES `dvd` (`dvd_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Returndvd Table
DROP TABLE IF EXISTS `returndvd`;
CREATE TABLE `returndvd` (
  `admin_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `dvd_id` int(0) NULL DEFAULT NULL,
  `borrow_time` datetime(0) NULL DEFAULT NULL,
  `time` varchar(255) NULL DEFAULT NULL,
  `ddl` datetime(0) NULL DEFAULT NULL,
  `back_time` datetime(0) NULL DEFAULT NULL,
  FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (`dvd_id`) REFERENCES `dvd` (`dvd_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Ulog Table
DROP TABLE IF EXISTS `ulog`;
CREATE TABLE `ulog` (
  `id` int(0) NOT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `user_username` varchar(255) NULL DEFAULT NULL,
  `user_password` varchar(255) NULL DEFAULT NULL,
  `user_name` varchar(255) NULL DEFAULT NULL,
  `user_sex` varchar(255) NULL DEFAULT NULL,
  `user_age` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB;

-- User Table
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(0) NOT NULL,
  `user_username` varchar(255) NULL DEFAULT NULL,
  `user_password` varchar(255) NULL DEFAULT NULL,
  `user_name` varchar(255) NULL DEFAULT NULL,
  `user_sex` varchar(255) NULL DEFAULT NULL,
  `user_age` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE = InnoDB;

-- Initial data

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES 
(1, 'admin1', 'admin1', 'David', 'Male', '19'),
(2, 'admin2', 'admin2', 'Mary', 'Female', '24'),
(3, 'admin3', 'admin3', 'Mike', 'Male', '25');


-- ----------------------------
-- Records of dvd
-- ----------------------------
INSERT INTO `dvd` VALUES 
(1, 'Inception', '9'),
(2, 'The Godfather', '8'),
(3, 'Interstellar', '7'),
(4, 'Pulp Fiction', '6'),
(5, 'Forrest Gump', '5'),
(6, 'The Matrix', '4'),
(7, 'Jurassic Park', '3'),
(8, 'The Dark Knight', '2');


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES
(1, 'user1', 'user1', 'Harry', 'Male', '19'),
(2, 'user2', 'user2', 'Kelly', 'Female', '28'),
(3, 'user3', 'user3', 'Lee', 'Male', '30'),
(4, 'user4', 'user4', 'Emma', 'Female', '25'),
(5, 'user5', 'user5', 'Carlos', 'Male', '22'),
(6, 'user6', 'user6', 'Aisha', 'Female', '27'),
(7, 'user7', 'user7', 'Brian', 'Male', '33'),
(8, 'user8', 'user8', 'Sophia', 'Female', '31');

-- ----------------------------
-- Records of borrowed
-- ----------------------------
INSERT INTO `borrowed` VALUES (1, 2, 1, '1', '2023-12-07 16:30:59', '2023-12-09 00:00:00');
-- ----------------------------
-- Records of returndvd
-- ----------------------------
INSERT INTO `returndvd` VALUES (1, 2, 2, '2023-12-07 16:50:59', '2', '2023-12-10 00:00:00', '2023-12-09 16:51:56');
-- ----------------------------
-- Records of ulog
-- ----------------------------
INSERT INTO `ulog` VALUES (1, 2, 'user2', 'user2', 'Kelly', 'F', '28');

-- ----------------------------
-- Records of alog
-- ----------------------------
INSERT INTO `alog` VALUES (1, 1, 'admin1', 'admin1', 'David', 'Male', '19');


SET FOREIGN_KEY_CHECKS = 1;

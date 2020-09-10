CREATE DATABASE IF NOT EXISTS FeedsDb;

use FeedsDb;

DROP TABLE IF EXISTS Feeds;

CREATE TABLE IF NOT EXISTS Feeds(
Id INT AUTO_INCREMENT PRIMARY KEY,
UserId VARCHAR(250) NOT NULL,
Title VARCHAR(150) NOT NULL,
Content VARCHAR(250) NOT NULL,
DatePosted TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
LastUpdate TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE `movie` (
    `movie_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `movie_collection_id` INT UNSIGNED NOT NULL,
    `original_language_id` INT UNSIGNED NOT NULL,
    `imdb_id` VARCHAR(30),
    `original_title` VARCHAR(1024) NOT NULL,
    `overview` TEXT,
    `homepage` VARCHAR(1024),
    `backdrop_path` VARCHAR(1024),
    `poster_path` VARCHAR(1024),
    `release_date` DATE,
    `release_status_code` INT,
    `budget` BIGINT,
    `revenue` BIGINT,
    `runtime` INT,
    `popularity` DOUBLE,
    `adult` BOOLEAN,
    `video` BOOLEAN,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `movie_collection_id` FOREIGN KEY (`movie_collection_id`) REFERENCES `collection` (`collection_id`),
    CONSTRAINT `original_language_id` FOREIGN KEY (`original_language_id`) REFERENCES `language` (`language_id`)
);
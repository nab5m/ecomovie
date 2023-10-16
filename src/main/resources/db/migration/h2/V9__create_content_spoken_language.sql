CREATE TABLE `content_spoken_language` (
    `content_spoken_language_id` INT PRIMARY KEY AUTO_INCREMENT,
    `movie_id` INT,
    `spoken_language_id` INT NOT NULL,
    `content_type_code` INT NOT NULL,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `content_spoken_language_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
    CONSTRAINT `spoken_language_id` FOREIGN KEY (`spoken_language_id`) REFERENCES `language` (`language_id`)
);
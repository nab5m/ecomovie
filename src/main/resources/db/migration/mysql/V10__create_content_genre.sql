CREATE TABLE `content_genre` (
    `content_genre_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `movie_id` INT UNSIGNED,
    `content_type_code` INT NOT NULL,
    `genre_code` INT NOT NULL,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `content_genre_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`)
);
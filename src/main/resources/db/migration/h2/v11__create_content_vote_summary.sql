CREATE TABLE `content_vote_summary` (
    `content_vote_summary_id` INT PRIMARY KEY AUTO_INCREMENT,
    `movie_id` INT,
    `content_type_code` INT NOT NULL,
    `vote_average_rating` DOUBLE NOT NULL,
    `vote_count` INT NOT NULL,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `content_vote_summary_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`)
);
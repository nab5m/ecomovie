CREATE TABLE `content_production_company` (
    `content_production_company_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `production_movie_id` INT UNSIGNED NOT NULL,
    `production_company_id` INT UNSIGNED NOT NULL,
    `content_type_code` INT NOT NULL,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `production_movie_id` FOREIGN KEY (`production_movie_id`) REFERENCES `movie` (`movie_id`),
    CONSTRAINT `production_company_id` FOREIGN KEY (`production_company_id`) REFERENCES `company` (`company_id`)
);
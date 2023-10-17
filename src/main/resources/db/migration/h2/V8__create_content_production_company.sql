CREATE TABLE `content_production_company` (
    `content_production_company_id` INT PRIMARY KEY AUTO_INCREMENT,
    `production_movie_id` INT,
    `production_company_id` INT NOT NULL,
    `content_type_code` INT NOT NULL,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `production_movie_id` FOREIGN KEY (`production_movie_id`) REFERENCES `movie` (`movie_id`),
    CONSTRAINT `production_company_id` FOREIGN KEY (`production_company_id`) REFERENCES `company` (`company_id`)
);
CREATE TABLE `country` (
    `country_id` INT PRIMARY KEY AUTO_INCREMENT,
    `country_name` VARCHAR(256),
    `iso_3166_1` VARCHAR(10) UNIQUE,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME
);
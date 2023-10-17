CREATE TABLE `language` (
    `language_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `language_name` VARCHAR(256),
    `english_name` VARCHAR(256),
    `iso_639_1` VARCHAR(10) UNIQUE,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME
);
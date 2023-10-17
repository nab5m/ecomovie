CREATE TABLE `collection` (
    `collection_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(1024) NOT NULL,
    `poster_path` VARCHAR(1024),
    `backdrop_path` VARCHAR(1024),
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME
);
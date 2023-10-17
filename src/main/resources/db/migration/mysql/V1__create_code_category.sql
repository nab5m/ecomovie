CREATE TABLE `code_category` (
    `code_category_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `code_category_name` VARCHAR(30) NOT NULL UNIQUE,
    `creation_date_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `last_update_date_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    `deletion_date_time` DATETIME
);
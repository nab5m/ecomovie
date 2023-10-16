CREATE TABLE `code_item` (
    `code_item_id` INT PRIMARY KEY AUTO_INCREMENT,
    `code_category_id` INT NOT NULL,
    `code_item_name` VARCHAR(30) NOT NULL,
    `code` INT NOT NULL,
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `code_item_code_category_id` FOREIGN KEY (`code_category_id`) REFERENCES `code_category` (`code_category_id`),
    CONSTRAINT `unique_name_per_category` UNIQUE (`code_category_id`, `code_item_name`)
);
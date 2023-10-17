CREATE TABLE `company` (
    `company_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `company_country_id` INT UNSIGNED,
    `company_name` VARCHAR(256) NOT NULL,
    `logo_path` VARCHAR(1024),
    `creation_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deletion_date_time` DATETIME,
    CONSTRAINT `company_country_id` FOREIGN KEY (`company_country_id`) REFERENCES `country` (`country_id`)
);
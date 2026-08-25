CREATE TABLE IF NOT EXISTS `users` (
    `id` BIGINT AUTO_INCREMENT,
    `device_description` TEXT,
    `created_at` DATETIME NOT NULL,
    `edited_at` DATETIME NOT NULL,
    CONSTRAINT USERS_PK PRIMARY KEY (`id`)
) ENGINE InnoDB;
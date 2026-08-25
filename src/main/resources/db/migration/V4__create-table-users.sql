CREATE TABLE `users` (
    `id` BIGINT AUTO_INCREMENT,
    `deviceDescription` TEXT,
    `createdAt` DATETIME NOT NULL,
    `editedAt` DATETIME NOT NULL,
    CONSTRAINT USERS_PK PRIMARY KEY (`id`)
) ENGINE InnoDB;
CREATE TABLE IF NOT EXISTS `logs` (
    `id` BIGINT AUTO_INCREMENT,
    `type` TEXT NOT NULL,
    `timestamp` DATETIME NOT NULL,
    `coordinatesX` FLOAT NOT NULL,
    `coordinatesY` FLOAT NOT NULL,
    `direction` TEXT,
    `target_element_id` TEXT NOT NULL,
    `normalized` BOOLEAN NOT NULL DEFAULT FALSE,
    `user` VARCHAR(32) NOT NULL,
    CONSTRAINT LOGS_PK PRIMARY KEY (`id`)
) ENGINE InnoDB;
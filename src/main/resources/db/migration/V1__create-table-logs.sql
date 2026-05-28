CREATE TABLE `logs` (
    `id` BIGINT AUTO_INCREMENT,
    `type` TEXT NOT NULL,
    `timestamp` DATETIME NOT NULL,
    `coordinatesX` INT NOT NULL,
    `coordinatesY` INT NOT NULL,
    `target_element_id` TEXT NOT NULL,
    CONSTRAINT LOGS_PK PRIMARY KEY (`id`)
) ENGINE InnoDB;
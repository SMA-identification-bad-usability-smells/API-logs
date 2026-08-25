CREATE TABLE IF NOT EXISTS `normalizedlogs` (
    `id` BIGINT,
    `frequency` BIGINT NOT NULL,
    `interaction_type` TEXT NOT NULL,
    `time` DATETIME NOT NULL,
    `gesture_direction` TEXT,
    CONSTRAINT NORMALIZEDLOGS_PK PRIMARY KEY (`id`)
) ENGINE InnoDB;
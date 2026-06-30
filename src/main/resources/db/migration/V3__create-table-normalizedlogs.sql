CREATE TABLE `normalizedlogs` (
    `id` BIGINT,
    `frequency` BIGINT NOT NULL,
    `interactionType` TEXT NOT NULL,
    `time` DATETIME NOT NULL,
    `gestureDirection` TEXT,
    CONSTRAINT NORMALIZEDLOGS_PK PRIMARY KEY (`id`)
) ENGINE InnoDB;
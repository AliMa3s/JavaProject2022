2021-12-02 (rose)
----------------
ALTER TABLE `winkeldb`.`werknemers` 
CHANGE COLUMN `functie` `functie` ENUM('admin', 'bediende') NOT NULL ;

UPDATE `winkeldb`.`werknemers` SET `naam` = 'jalmar' WHERE (`id` = '3');


ALTER TABLE `winkeldb`.`klanten` 
CHANGE COLUMN `GSM` `GSM` VARCHAR(45) NULL DEFAULT NULL ;

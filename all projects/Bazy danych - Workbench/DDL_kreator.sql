-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`worker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `pesel` VARCHAR(11) CHARACTER SET 'dec8' COLLATE 'dec8_bin' NOT NULL,
  `date_of_birthday` DATE NOT NULL,
  `department_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_worker_department1_idx` (`department_id` ASC),
  CONSTRAINT `fk_worker_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `mydb`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` ENUM('external', 'internal') NOT NULL,
  `manager_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_project_worker1_idx` (`manager_id` ASC),
  CONSTRAINT `fk_project_worker1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`worker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`worker_in_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`worker_in_project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `worker_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  `start_event` DATE NOT NULL,
  `stop_event` DATE NULL,
  `function` ENUM('PL', 'TCD', 'FCD', 'DEV') NOT NULL,
  `daily_salary` DECIMAL(6) NOT NULL,
  INDEX `fk_worker_has_project_project1_idx` (`project_id` ASC),
  PRIMARY KEY (`id`, `project_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_worker_in_project_worker1_idx` (`worker_id` ASC),
  CONSTRAINT `fk_worker_has_project_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `mydb`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_worker_in_project_worker1`
    FOREIGN KEY (`worker_id`)
    REFERENCES `mydb`.`worker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

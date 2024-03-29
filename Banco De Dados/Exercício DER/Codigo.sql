-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `tb_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `Usuario` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `foto` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Temas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_Postagens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_Postagens` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `texto` VARCHAR(1000) NOT NULL,
  `dataPostagem` DATE NOT NULL,
  `tb_Temas_id` BIGINT NOT NULL,
  `tb_usuarios_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Postagens_tb_Temas_idx` (`tb_Temas_id` ASC) VISIBLE,
  INDEX `fk_tb_Postagens_tb_usuarios1_idx` (`tb_usuarios_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_Postagens_tb_Temas`
    FOREIGN KEY (`tb_Temas_id`)
    REFERENCES `tb_Temas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Postagens_tb_usuarios1`
    FOREIGN KEY (`tb_usuarios_id`)
    REFERENCES `tb_usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vendedores` (
  `idVendedores` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVendedores`));



-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `CPF` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CPF`));



-- -----------------------------------------------------
-- Table `mydb`.`OperacaoVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OperacaoVenda` (
  `idOperacaoVenda` INT NOT NULL,
  `Vendedores_idVendedores` INT NOT NULL,
  `Cliente_CPF` INT NOT NULL,
  PRIMARY KEY (`idOperacaoVenda`),
  CONSTRAINT `fk_OperacaoVenda_Vendedores`
    FOREIGN KEY (`Vendedores_idVendedores`)
    REFERENCES `mydb`.`Vendedores` (`idVendedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OperacaoVenda_Cliente1`
    FOREIGN KEY (`Cliente_CPF`)
    REFERENCES `mydb`.`Cliente` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`NotasFiscais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NotasFiscais` (
  `idNotasFiscais` INT NOT NULL,
  `OperacaoVenda_idOperacaoVenda` INT NOT NULL,
  PRIMARY KEY (`idNotasFiscais`),
  CONSTRAINT `fk_NotasFiscais_OperacaoVenda1`
    FOREIGN KEY (`OperacaoVenda_idOperacaoVenda`)
    REFERENCES `mydb`.`OperacaoVenda` (`idOperacaoVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produtos` (
  `idProdutos` INT NOT NULL,
  `Valor` VARCHAR(45) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProdutos`));


-- -----------------------------------------------------
-- Table `mydb`.`OperaçãoVenda_has_Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OperacaoVenda_has_Produtos` (
  `OperacaoVenda_idOperacaoVenda` INT NOT NULL,
  `Produtos_idProdutos` INT NOT NULL,
  PRIMARY KEY (`OperacaoVenda_idOperacaoVenda`, `Produtos_idProdutos`),
  CONSTRAINT `fk_OperacaoVenda_has_Produtos_OperacaoVenda1`
    FOREIGN KEY (`OperacaoVenda_idOperacaoVenda`)
    REFERENCES `mydb`.`OperacaoVenda` (`idOperacaoVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OperacaoVenda_has_Produtos_Produtos1`
    FOREIGN KEY (`Produtos_idProdutos`)
    REFERENCES `mydb`.`Produtos` (`idProdutos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


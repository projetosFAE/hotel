SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Hotel_V1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Hotel_V1` ;

-- -----------------------------------------------------
-- Table `Hotel_V1`.`financeiro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`financeiro` (
  `idfinanceiro` INT NOT NULL ,
  `hospedagem_idhospedagem` INT NOT NULL ,
  PRIMARY KEY (`idfinanceiro`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`reserva` (
  `idreserva` INT NOT NULL ,
  `financeiro_idfinanceiro` INT NOT NULL ,
  PRIMARY KEY (`idreserva`) ,
  INDEX `fk_reserva_financeiro1` (`financeiro_idfinanceiro` ASC) ,
  CONSTRAINT `fk_reserva_financeiro1`
    FOREIGN KEY (`financeiro_idfinanceiro` )
    REFERENCES `Hotel_V1`.`financeiro` (`idfinanceiro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`usuario` (
  `idusuario` INT NOT NULL ,
  `usuario_nome` VARCHAR(45) NULL ,
  `usuario_tipo` VARCHAR(45) NULL ,
  `reserva_idreserva` INT NOT NULL ,
  `usuario_cpf` VARCHAR(11) NULL ,
  `usuario_cnpj` VARCHAR(14) NULL ,
  `usuario_email` VARCHAR(100) NOT NULL ,
  `usuario_senha` VARCHAR(45) NULL ,
  INDEX `fk_usuario_reserva1` (`reserva_idreserva` ASC) ,
  UNIQUE INDEX `usuario_email_UNIQUE` (`usuario_email` ASC) ,
  UNIQUE INDEX `idusuario_UNIQUE` (`idusuario` ASC) ,
  PRIMARY KEY (`idusuario`) ,
  CONSTRAINT `fk_usuario_reserva1`
    FOREIGN KEY (`reserva_idreserva` )
    REFERENCES `Hotel_V1`.`reserva` (`idreserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`conversa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`conversa` (
  `idconversa` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  PRIMARY KEY (`idconversa`) ,
  INDEX `fk_conversa_usuario1` (`usuario_idusuario` ASC) ,
  CONSTRAINT `fk_conversa_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `Hotel_V1`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`chat`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`chat` (
  `idchat` INT NOT NULL ,
  `conversa_idconversa` INT NOT NULL ,
  PRIMARY KEY (`idchat`) ,
  INDEX `fk_chat_conversa` (`conversa_idconversa` ASC) ,
  CONSTRAINT `fk_chat_conversa`
    FOREIGN KEY (`conversa_idconversa` )
    REFERENCES `Hotel_V1`.`conversa` (`idconversa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`pais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`pais` (
  `idpais` INT NOT NULL ,
  PRIMARY KEY (`idpais`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`estado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`estado` (
  `idestado` INT NOT NULL ,
  `estado_UF` VARCHAR(45) NULL ,
  `pais_idpais` INT NOT NULL ,
  PRIMARY KEY (`idestado`) ,
  INDEX `fk_estado_pais1` (`pais_idpais` ASC) ,
  CONSTRAINT `fk_estado_pais1`
    FOREIGN KEY (`pais_idpais` )
    REFERENCES `Hotel_V1`.`pais` (`idpais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`cidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`cidade` (
  `idcidade` INT NOT NULL ,
  `cidade_nome` VARCHAR(45) NULL ,
  `estado_idestado` INT NOT NULL ,
  PRIMARY KEY (`idcidade`) ,
  INDEX `fk_cidade_estado1` (`estado_idestado` ASC) ,
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`estado_idestado` )
    REFERENCES `Hotel_V1`.`estado` (`idestado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`logradouro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`logradouro` (
  `idlogradouro` INT NOT NULL ,
  `logradouro_nome` VARCHAR(45) NULL ,
  `logradouro_numero` VARCHAR(45) NULL ,
  PRIMARY KEY (`idlogradouro`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`cep`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`cep` (
  `idcep` INT NOT NULL ,
  `cidade_idcidade` INT NOT NULL ,
  `logradouro_idlogradouro` INT NOT NULL ,
  PRIMARY KEY (`idcep`) ,
  INDEX `fk_cep_cidade1` (`cidade_idcidade` ASC) ,
  INDEX `fk_cep_logradouro1` (`logradouro_idlogradouro` ASC) ,
  CONSTRAINT `fk_cep_cidade1`
    FOREIGN KEY (`cidade_idcidade` )
    REFERENCES `Hotel_V1`.`cidade` (`idcidade` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cep_logradouro1`
    FOREIGN KEY (`logradouro_idlogradouro` )
    REFERENCES `Hotel_V1`.`logradouro` (`idlogradouro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`hotel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`hotel` (
  `idhotel` INT NOT NULL ,
  `hotel_nome` VARCHAR(45) NOT NULL ,
  `hotel_cnpj` VARCHAR(14) NOT NULL ,
  `hotel_inscricao_estadual` VARCHAR(12) NOT NULL ,
  `hotel_email` VARCHAR(100) NOT NULL ,
  `hotel_observacoes` VARCHAR(800) NULL ,
  `hotel_gerente` VARCHAR(70) NULL ,
  PRIMARY KEY (`idhotel`) ,
  UNIQUE INDEX `hotel_cnpj_UNIQUE` (`hotel_cnpj` ASC) ,
  UNIQUE INDEX `hotel_nome_UNIQUE` (`hotel_nome` ASC) ,
  UNIQUE INDEX `hotel_inscricao_estadual_UNIQUE` (`hotel_inscricao_estadual` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`telefone`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`telefone` (
  `idtelefone` INT NOT NULL ,
  `hotel_idhotel` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  PRIMARY KEY (`idtelefone`) ,
  INDEX `fk_telefone_hotel1` (`hotel_idhotel` ASC) ,
  INDEX `fk_telefone_usuario1` (`usuario_idusuario` ASC) ,
  CONSTRAINT `fk_telefone_hotel1`
    FOREIGN KEY (`hotel_idhotel` )
    REFERENCES `Hotel_V1`.`hotel` (`idhotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `Hotel_V1`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`ambiente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`ambiente` (
  `idambiente` INT NOT NULL ,
  `hotel_idhotel` INT NOT NULL ,
  `ambiente_nome` VARCHAR(75) NOT NULL ,
  `ambiente_observacao` VARCHAR(800) NOT NULL ,
  `ambiente_valor` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idambiente`) ,
  INDEX `fk_ambiente_hotel1` (`hotel_idhotel` ASC) ,
  UNIQUE INDEX `ambiente_nome_UNIQUE` (`ambiente_nome` ASC) ,
  CONSTRAINT `fk_ambiente_hotel1`
    FOREIGN KEY (`hotel_idhotel` )
    REFERENCES `Hotel_V1`.`hotel` (`idhotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`servico` (
  `idservico` INT NOT NULL ,
  `hotel_idhotel` INT NOT NULL ,
  `servico_nome` VARCHAR(45) NULL ,
  `servico_observacao` VARCHAR(800) NULL ,
  `servico_valor` DECIMAL(10,0) NULL ,
  PRIMARY KEY (`idservico`) ,
  INDEX `fk_servico_hotel1` (`hotel_idhotel` ASC) ,
  CONSTRAINT `fk_servico_hotel1`
    FOREIGN KEY (`hotel_idhotel` )
    REFERENCES `Hotel_V1`.`hotel` (`idhotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`quartos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`quartos` (
  `idquartos` INT NOT NULL ,
  `hotel_idhotel` INT NOT NULL ,
  `quartos_numero` INT NOT NULL ,
  `quartos_descricao` VARCHAR(800) NOT NULL ,
  `quartos_valor` DECIMAL(10,0) NOT NULL ,
  `quartoscol` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idquartos`) ,
  INDEX `fk_quartos_hotel1` (`hotel_idhotel` ASC) ,
  UNIQUE INDEX `quartos_numero_UNIQUE` (`quartos_numero` ASC) ,
  CONSTRAINT `fk_quartos_hotel1`
    FOREIGN KEY (`hotel_idhotel` )
    REFERENCES `Hotel_V1`.`hotel` (`idhotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`camas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`camas` (
  `idcamas` INT NOT NULL ,
  `quartos_idquartos` INT NOT NULL ,
  PRIMARY KEY (`idcamas`) ,
  INDEX `fk_camas_quartos1` (`quartos_idquartos` ASC) ,
  CONSTRAINT `fk_camas_quartos1`
    FOREIGN KEY (`quartos_idquartos` )
    REFERENCES `Hotel_V1`.`quartos` (`idquartos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`cardapio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`cardapio` (
  `idcardapio` INT NOT NULL ,
  `hotel_idhotel` INT NOT NULL ,
  `cardapio_nome` VARCHAR(75) NOT NULL ,
  `cardapio_tempo` TIME NOT NULL ,
  `cardapio_observacao` VARCHAR(800) NULL ,
  `cardapio_valor_calorico` INT NULL ,
  `cardapio_valor` DECIMAL(10,0) NOT NULL ,
  PRIMARY KEY (`idcardapio`) ,
  INDEX `fk_cardapio_hotel1` (`hotel_idhotel` ASC) ,
  UNIQUE INDEX `cardapio_nome_UNIQUE` (`cardapio_nome` ASC) ,
  CONSTRAINT `fk_cardapio_hotel1`
    FOREIGN KEY (`hotel_idhotel` )
    REFERENCES `Hotel_V1`.`hotel` (`idhotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`pacote`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`pacote` (
  `idpacote` INT NOT NULL ,
  `quartos_idquartos` INT NOT NULL ,
  `cardapio_idcardapio` INT NOT NULL ,
  `ambiente_idambiente` INT NOT NULL ,
  `servico_idservico` INT NOT NULL ,
  `reserva_idreserva` INT NOT NULL ,
  `pacote_nome` VARCHAR(45) NOT NULL ,
  `pacote_data_inicial` DATE NOT NULL ,
  `pacote_data_final` DATE NOT NULL ,
  `pacote_pessoas` INT NOT NULL ,
  `pacote_desc` INT NOT NULL ,
  PRIMARY KEY (`idpacote`) ,
  INDEX `fk_pacote_quartos1` (`quartos_idquartos` ASC) ,
  INDEX `fk_pacote_cardapio1` (`cardapio_idcardapio` ASC) ,
  INDEX `fk_pacote_ambiente1` (`ambiente_idambiente` ASC) ,
  INDEX `fk_pacote_servico1` (`servico_idservico` ASC) ,
  INDEX `fk_pacote_reserva1` (`reserva_idreserva` ASC) ,
  UNIQUE INDEX `pacote_nome_UNIQUE` (`pacote_nome` ASC) ,
  CONSTRAINT `fk_pacote_quartos1`
    FOREIGN KEY (`quartos_idquartos` )
    REFERENCES `Hotel_V1`.`quartos` (`idquartos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacote_cardapio1`
    FOREIGN KEY (`cardapio_idcardapio` )
    REFERENCES `Hotel_V1`.`cardapio` (`idcardapio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacote_ambiente1`
    FOREIGN KEY (`ambiente_idambiente` )
    REFERENCES `Hotel_V1`.`ambiente` (`idambiente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacote_servico1`
    FOREIGN KEY (`servico_idservico` )
    REFERENCES `Hotel_V1`.`servico` (`idservico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacote_reserva1`
    FOREIGN KEY (`reserva_idreserva` )
    REFERENCES `Hotel_V1`.`reserva` (`idreserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`itens_reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`itens_reserva` (
  `idreserva` INT NOT NULL ,
  `quartos_idquartos` INT NOT NULL ,
  `cardapio_idcardapio` INT NOT NULL ,
  `ambiente_idambiente` INT NOT NULL ,
  `servico_idservico` INT NOT NULL ,
  `reserva_idreserva` INT NOT NULL ,
  PRIMARY KEY (`idreserva`) ,
  INDEX `fk_reserva_quartos1` (`quartos_idquartos` ASC) ,
  INDEX `fk_reserva_cardapio1` (`cardapio_idcardapio` ASC) ,
  INDEX `fk_reserva_ambiente1` (`ambiente_idambiente` ASC) ,
  INDEX `fk_reserva_servico1` (`servico_idservico` ASC) ,
  INDEX `fk_itens_reserva_reserva1` (`reserva_idreserva` ASC) ,
  CONSTRAINT `fk_reserva_quartos1`
    FOREIGN KEY (`quartos_idquartos` )
    REFERENCES `Hotel_V1`.`quartos` (`idquartos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_cardapio1`
    FOREIGN KEY (`cardapio_idcardapio` )
    REFERENCES `Hotel_V1`.`cardapio` (`idcardapio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_ambiente1`
    FOREIGN KEY (`ambiente_idambiente` )
    REFERENCES `Hotel_V1`.`ambiente` (`idambiente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_servico1`
    FOREIGN KEY (`servico_idservico` )
    REFERENCES `Hotel_V1`.`servico` (`idservico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_reserva_reserva1`
    FOREIGN KEY (`reserva_idreserva` )
    REFERENCES `Hotel_V1`.`reserva` (`idreserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`pagamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`pagamento` (
  `idpagamento` INT NOT NULL ,
  `financeiro_idfinanceiro` INT NOT NULL ,
  PRIMARY KEY (`idpagamento`) ,
  INDEX `fk_pagamento_financeiro1` (`financeiro_idfinanceiro` ASC) ,
  CONSTRAINT `fk_pagamento_financeiro1`
    FOREIGN KEY (`financeiro_idfinanceiro` )
    REFERENCES `Hotel_V1`.`financeiro` (`idfinanceiro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`logradouro_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`logradouro_usuario` (
  `idlogradouro_usuario` INT NOT NULL ,
  `cep_idcep` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `hotel_idhotel` INT NOT NULL ,
  PRIMARY KEY (`idlogradouro_usuario`) ,
  INDEX `fk_logradouro_usuario_cep1` (`cep_idcep` ASC) ,
  INDEX `fk_logradouro_usuario_usuario1` (`usuario_idusuario` ASC) ,
  INDEX `fk_logradouro_usuario_hotel1` (`hotel_idhotel` ASC) ,
  CONSTRAINT `fk_logradouro_usuario_cep1`
    FOREIGN KEY (`cep_idcep` )
    REFERENCES `Hotel_V1`.`cep` (`idcep` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logradouro_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `Hotel_V1`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logradouro_usuario_hotel1`
    FOREIGN KEY (`hotel_idhotel` )
    REFERENCES `Hotel_V1`.`hotel` (`idhotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`pacote_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`pacote_usuario` (
  `idpacote_usuario` INT NOT NULL ,
  `pacote_idpacote` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  PRIMARY KEY (`idpacote_usuario`) ,
  INDEX `fk_pacote_usuario_pacote1` (`pacote_idpacote` ASC) ,
  INDEX `fk_pacote_usuario_usuario1` (`usuario_idusuario` ASC) ,
  CONSTRAINT `fk_pacote_usuario_pacote1`
    FOREIGN KEY (`pacote_idpacote` )
    REFERENCES `Hotel_V1`.`pacote` (`idpacote` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacote_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `Hotel_V1`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`ramal`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`ramal` (
  `idramal` INT NOT NULL ,
  `quartos_idquartos` INT NOT NULL ,
  `ambiente_idambiente` INT NOT NULL ,
  PRIMARY KEY (`idramal`) ,
  INDEX `fk_ramal_quartos1` (`quartos_idquartos` ASC) ,
  INDEX `fk_ramal_ambiente1` (`ambiente_idambiente` ASC) ,
  CONSTRAINT `fk_ramal_quartos1`
    FOREIGN KEY (`quartos_idquartos` )
    REFERENCES `Hotel_V1`.`quartos` (`idquartos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ramal_ambiente1`
    FOREIGN KEY (`ambiente_idambiente` )
    REFERENCES `Hotel_V1`.`ambiente` (`idambiente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel_V1`.`niveis`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Hotel_V1`.`niveis` (
  `idniveis` INT NOT NULL ,
  PRIMARY KEY (`idniveis`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Abr 16, 2012 as 02:47 AM
-- Versão do Servidor: 5.1.53
-- Versão do PHP: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `trabalho`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE IF NOT EXISTS `contato` (
  `contato` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `contato_nome` varchar(100) NOT NULL,
  `contato_momento_cadastro` date NOT NULL,
  PRIMARY KEY (`contato`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`contato`, `usuario`, `contato_nome`, `contato_momento_cadastro`) VALUES
(1, 1, 'marcos', '2012-04-06'),
(2, 1, 'maeda', '2012-04-08'),
(3, 1, 'yukio', '2012-04-15');

-- --------------------------------------------------------

--
-- Estrutura da tabela `foto`
--

CREATE TABLE IF NOT EXISTS `foto` (
  `foto` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `foto_nome` varchar(150) NOT NULL,
  `foto_tipo` enum('familia','amigo') NOT NULL,
  `foto_momento_cadastro` date NOT NULL,
  PRIMARY KEY (`foto`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `foto`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `mensagem`
--

CREATE TABLE IF NOT EXISTS `mensagem` (
  `mensagem` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `mensagem_texto` text NOT NULL,
  `mensagem_momento_cadastro` date NOT NULL,
  PRIMARY KEY (`mensagem`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `mensagem`
--

INSERT INTO `mensagem` (`mensagem`, `usuario`, `mensagem_texto`, `mensagem_momento_cadastro`) VALUES
(13, 1, 'marcos\r\nmaeda', '2012-04-06'),
(14, 1, 'yukio', '2012-04-08'),
(15, 1, 'erik\r\nmaeda', '2012-04-15'),
(16, 1, '757', '2012-04-16');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_nome` varchar(100) NOT NULL,
  `usuario_login` varchar(100) NOT NULL,
  `usuario_senha` varchar(100) NOT NULL,
  `usuario_email` varchar(100) NOT NULL,
  `usuario_lembrete` text NOT NULL,
  `usuario_momento_cadastro` date NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuario`, `usuario_nome`, `usuario_login`, `usuario_senha`, `usuario_email`, `usuario_lembrete`, `usuario_momento_cadastro`) VALUES
(1, 'marcos', 'marcos', 'marcos', 'marcos@mail.com', 'maeda', '2012-04-06');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `contato`
--
ALTER TABLE `contato`
  ADD CONSTRAINT `contato_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para a tabela `foto`
--
ALTER TABLE `foto`
  ADD CONSTRAINT `foto_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para a tabela `mensagem`
--
ALTER TABLE `mensagem`
  ADD CONSTRAINT `mensagem_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

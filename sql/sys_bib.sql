-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Mar-2021 às 01:11
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sys_bib`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `dataDeNascimento` date NOT NULL,
  `curso` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `nome`, `cpf`, `telefone`, `dataDeNascimento`, `curso`, `senha`) VALUES
(402119, 'Jorge Lucas Colares Martins', '111.111.111-11', '(11) 11111-1111', '1998-07-14', 'Engenharia de Computação', '1407'),
(402749, 'Gregorio Mariano de Azevedo Neto', '222.222.222-22', '(00) 00000-0000', '1997-05-07', 'Engenharia de Computação', '1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `bibliotecario`
--

CREATE TABLE `bibliotecario` (
  `id_bibliotecario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `telefone` varchar(14) NOT NULL,
  `dataDeNascimento` date NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `bibliotecario`
--

INSERT INTO `bibliotecario` (`id_bibliotecario`, `nome`, `cpf`, `telefone`, `dataDeNascimento`, `login`, `senha`) VALUES
(2, 'admin', '000.000.000-00', '(00)00000-0000', '2021-03-10', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nome`) VALUES
(9, 'Eletronica');

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `id_editora` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `cidade` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `editora`
--

INSERT INTO `editora` (`id_editora`, `nome`, `cnpj`, `cidade`) VALUES
(7, 'PEARSON EDUCATION DO BRASIL LTDA', '01.404.158/0019-19', 'LOUVEIRA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimo`
--

CREATE TABLE `emprestimo` (
  `id_emprestimo` int(11) NOT NULL,
  `livro` int(11) NOT NULL,
  `aluno` int(11) NOT NULL,
  `bibliotecario` int(11) DEFAULT NULL,
  `dataInicio` date DEFAULT NULL,
  `dataTermino` date DEFAULT NULL,
  `renovado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`id_emprestimo`, `livro`, `aluno`, `bibliotecario`, `dataInicio`, `dataTermino`, `renovado`) VALUES
(19, 38, 402119, 2, '2021-03-22', '2021-04-06', 0),
(20, 39, 402749, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `id_livro` int(11) NOT NULL,
  `obra` int(11) NOT NULL,
  `dataAquiscao` date NOT NULL,
  `situacao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`id_livro`, `obra`, `dataAquiscao`, `situacao`) VALUES
(38, 13, '2021-03-20', 'alugado'),
(39, 13, '2021-03-20', 'pedente'),
(40, 13, '2021-03-20', 'disponivel'),
(41, 13, '2021-03-20', 'disponivel'),
(42, 13, '2021-03-20', 'disponivel'),
(43, 13, '2021-03-20', 'disponivel'),
(44, 13, '2021-03-20', 'disponivel'),
(45, 13, '2021-03-20', 'disponivel'),
(46, 13, '2021-03-20', 'disponivel'),
(47, 13, '2021-03-20', 'disponivel'),
(48, 13, '2021-03-20', 'disponivel'),
(49, 13, '2021-03-20', 'disponivel'),
(50, 13, '2021-03-20', 'disponivel'),
(51, 13, '2021-03-20', 'disponivel'),
(52, 13, '2021-03-20', 'disponivel'),
(53, 13, '2021-03-20', 'disponivel'),
(54, 13, '2021-03-20', 'disponivel'),
(55, 13, '2021-03-20', 'disponivel'),
(56, 13, '2021-03-20', 'disponivel'),
(57, 13, '2021-03-20', 'disponivel');

-- --------------------------------------------------------

--
-- Estrutura da tabela `obra`
--

CREATE TABLE `obra` (
  `id_obra` int(11) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `isbn` bigint(11) NOT NULL,
  `volume` int(11) NOT NULL,
  `descricaoDaObra` varchar(500) NOT NULL,
  `categoria` int(11) NOT NULL,
  `editora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `obra`
--

INSERT INTO `obra` (`id_obra`, `titulo`, `autor`, `isbn`, `volume`, `descricaoDaObra`, `categoria`, `editora`) VALUES
(13, 'Dispositivos Eletrônicos e Teoria dos Circuitos', 'Robert L. Boylestad, Louis Nashelsky ', 856457, 11, 'Ideal para estudantes de cursos de engenharia relacionados à eletrônica, contempla ainda aplicações nas versões atualizadas do Multisim e PSpice, além de exemplos, atividades e resumos com os conceitos que se destacam em cada capítulo.', 9, 7);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices para tabela `bibliotecario`
--
ALTER TABLE `bibliotecario`
  ADD PRIMARY KEY (`id_bibliotecario`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Índices para tabela `editora`
--
ALTER TABLE `editora`
  ADD PRIMARY KEY (`id_editora`);

--
-- Índices para tabela `emprestimo`
--
ALTER TABLE `emprestimo`
  ADD PRIMARY KEY (`id_emprestimo`),
  ADD KEY `emprestimo_ibfk_3` (`bibliotecario`),
  ADD KEY `emprestimo_ibfk_1` (`aluno`),
  ADD KEY `emprestimo_ibfk_2` (`livro`);

--
-- Índices para tabela `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`id_livro`),
  ADD KEY `obra` (`obra`);

--
-- Índices para tabela `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`id_obra`),
  ADD KEY `categoria` (`categoria`),
  ADD KEY `editora` (`editora`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bibliotecario`
--
ALTER TABLE `bibliotecario`
  MODIFY `id_bibliotecario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `editora`
--
ALTER TABLE `editora`
  MODIFY `id_editora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `emprestimo`
--
ALTER TABLE `emprestimo`
  MODIFY `id_emprestimo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `livro`
--
ALTER TABLE `livro`
  MODIFY `id_livro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT de tabela `obra`
--
ALTER TABLE `obra`
  MODIFY `id_obra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `emprestimo`
--
ALTER TABLE `emprestimo`
  ADD CONSTRAINT `emprestimo_ibfk_1` FOREIGN KEY (`aluno`) REFERENCES `aluno` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `emprestimo_ibfk_2` FOREIGN KEY (`livro`) REFERENCES `livro` (`id_livro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `emprestimo_ibfk_3` FOREIGN KEY (`bibliotecario`) REFERENCES `bibliotecario` (`id_bibliotecario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `livro`
--
ALTER TABLE `livro`
  ADD CONSTRAINT `livro_ibfk_1` FOREIGN KEY (`obra`) REFERENCES `obra` (`id_obra`);

--
-- Limitadores para a tabela `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `obra_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `obra_ibfk_2` FOREIGN KEY (`editora`) REFERENCES `editora` (`id_editora`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

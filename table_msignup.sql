-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 29, 2023 at 07:58 AM
-- Server version: 10.5.20-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id19512314_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `table_msignup`
--

CREATE TABLE `table_msignup` (
  `mfullname` varchar(100) DEFAULT NULL,
  `Mno` varchar(20) DEFAULT NULL,
  `mid` varchar(100) DEFAULT NULL,
  `mcity` varchar(100) DEFAULT NULL,
  `mpassword` varchar(100) DEFAULT NULL,
  `memailid` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_msignup`
--

INSERT INTO `table_msignup` (`mfullname`, `Mno`, `mid`, `mcity`, `mpassword`, `memailid`) VALUES
('priya', '9606717844', '123', 'hubli', 'priya123', 'priya@gmail.com'),
('', '', '', '', '', ''),
('', '', '', '', '', ''),
('', '', '', '', '', ''),
('', '', '', '', '', ''),
('ygg', 'hh', 'gh', 'hgjg', 'ygg', 'ghjgh'),
('', '', '', '', '', ''),
('bvb', 'vhj', 'jdjh', 'jh', 'hj', 'hjjnj'),
('', '', '', '', '', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 29, 2023 at 07:57 AM
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
-- Table structure for table `table_fsignup`
--

CREATE TABLE `table_fsignup` (
  `fullname` varchar(100) DEFAULT NULL,
  `mb` varchar(20) DEFAULT NULL,
  `emailid` varchar(100) DEFAULT NULL,
  `Aadharno` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `fpass` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_fsignup`
--

INSERT INTO `table_fsignup` (`fullname`, `mb`, `emailid`, `Aadharno`, `city`, `fpass`) VALUES
('Kartik', '9606667377', 'gouda@gmail.com', '123456789012', 'gadag', 'kartik123'),
('', '', '', '', '', ''),
('snehamaloji', '9686057088', 'sneha@gmail.com', '455666665', 'gadag', 'sneha@123'),
('', '', '', '', '', ''),
('', '', '', '', '', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

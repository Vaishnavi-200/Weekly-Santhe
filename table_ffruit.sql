-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 29, 2023 at 07:56 AM
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
-- Table structure for table `table_ffruit`
--

CREATE TABLE `table_ffruit` (
  `Fruitname` varchar(100) DEFAULT NULL,
  `FCity` varchar(100) DEFAULT NULL,
  `Fprice` varchar(100) DEFAULT NULL,
  `Fdate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_ffruit`
--

INSERT INTO `table_ffruit` (`Fruitname`, `FCity`, `Fprice`, `Fdate`) VALUES
('Apple', 'Gadag', '50', '2 feb 2023'),
('Jackfruit', 'Gadag', '20', '2 feb 2023'),
('Jackfruit', 'Hubli', '40', '3 feb 2023'),
('Apple', 'Hubli', '20', '3 feb 2023'),
('Mango', 'Gadag', '20', '2 feb 2023'),
('Mango', 'Hubli', '20', '2 feb 2023'),
('Cheery', 'Gadag', '20', '4 feb 2023'),
('Guva', 'Hubli', '10', '2 feb 2023');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

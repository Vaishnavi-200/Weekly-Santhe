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
-- Table structure for table `table_fvegetable`
--

CREATE TABLE `table_fvegetable` (
  `Name` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_fvegetable`
--

INSERT INTO `table_fvegetable` (`Name`, `city`, `price`, `date`) VALUES
('Tomato', 'Gadag', '30', '2 feb 2023'),
('Beetroot', 'Gadag', '20', '2 feb 2023'),
('Carrot', 'Gadag', '40', '3 feb 2023'),
('Peas', 'Gadag', '25', '3 feb 2023'),
('Beetroot', 'Hubli', '25', '4 feb 2023'),
('Tomato', 'Hubli', '30', '6 feb 2023'),
('Beetroot', 'Bellari', '20', '5 feb 2023'),
('Carrot', 'Bellari', '20', '2 feb 2023');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

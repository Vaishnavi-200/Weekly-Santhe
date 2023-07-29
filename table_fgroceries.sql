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
-- Table structure for table `table_fgroceries`
--

CREATE TABLE `table_fgroceries` (
  `gName` varchar(100) DEFAULT NULL,
  `gPrice` varchar(100) DEFAULT NULL,
  `gDate` varchar(100) DEFAULT NULL,
  `gCity` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_fgroceries`
--

INSERT INTO `table_fgroceries` (`gName`, `gPrice`, `gDate`, `gCity`) VALUES
('ToorDal', '50', '2 feb 2023', 'Gadag'),
('Wheat', '40', '2 feb 2023', 'Gadag'),
('ToorDal', '30', '6 feb 2023', 'Gadag'),
('ToorDal', '20', '3 feb 2023', 'Hubli'),
('Wheat', '40', '2 feb 2023', 'Hubli');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2015 at 08:02 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `chat`
--

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `message` text COLLATE utf8_unicode_ci NOT NULL,
  `from` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `to` varchar(60) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message`, `from`, `to`) VALUES
('hi', 'mrri', 'huy'),
('hi', 'mrri', 'huy'),
('xin chao', 'huy', 'mrri'),
('xin chao', 'huy', 'mrri'),
('alo alo', 'mrri', 'huy'),
('alo alo', 'mrri', 'huy'),
('ok ok', 'huy', 'mrri'),
('ok ok', 'huy', 'mrri'),
('hahaha', 'huy', 'mrri'),
('hahaha', 'huy', 'mrri'),
('huhuhu', 'huy', 'mrri'),
('huhuhu', 'huy', 'mrri'),
('you are crazy', 'mrri', 'huy'),
('you are crazy', 'mrri', 'huy');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

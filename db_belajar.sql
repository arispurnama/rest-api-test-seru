-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2022 at 05:03 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_belajar`
--

-- --------------------------------------------------------

--
-- Table structure for table `price_list`
--

CREATE TABLE `price_list` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  `year_id` int(11) DEFAULT NULL,
  `vehicle_model_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `price_list`
--

INSERT INTO `price_list` (`id`, `code`, `price`, `model_id`, `year_id`, `vehicle_model_id`) VALUES
(2, '4356', 670000000, 2, 9, 2),
(3, '4543', 30000000, 4, 11, 4),
(4, 'e454', 50000000, 6, 13, 6),
(5, '4345', 120000000, 1, 15, 1),
(6, '7654', 34000000, 2, 10, 2),
(7, '8765', 780000000, 3, 11, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `admin` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `admin`, `password`, `token`, `username`) VALUES
(1, b'1', '$2a$10$BMIVhPUeL2.dxYoKYfFjRuzpfGZ7fUT0.Kkw/YAWShqu0yI/B5Vju', NULL, 'Aris');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_brand`
--

CREATE TABLE `vehicle_brand` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle_brand`
--

INSERT INTO `vehicle_brand` (`id`, `name`) VALUES
(4, 'GTR'),
(3, 'BMW'),
(5, 'Mitsubishi'),
(6, 'Ferrari Wheel'),
(7, 'DUcati V2'),
(8, 'Nissan'),
(9, 'Ferrari'),
(10, 'Fuso'),
(11, 'Honda'),
(12, 'Daihatsu'),
(13, 'Jeep'),
(14, 'Lamborghini');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_model`
--

CREATE TABLE `vehicle_model` (
  `id` int(11) NOT NULL,
  `name_model` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle_model`
--

INSERT INTO `vehicle_model` (`id`, `name_model`, `type_id`) VALUES
(1, 'L300', 1),
(2, 'Avansa', 3),
(3, 'Alfard', 2),
(4, 'Grand Max', 1),
(5, 'MPV', 4),
(6, 'Toyota L', 5),
(7, 'L600', 3),
(8, 'Truk', 2);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_type`
--

CREATE TABLE `vehicle_type` (
  `id` int(11) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `name_type` varchar(255) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle_type`
--

INSERT INTO `vehicle_type` (`id`, `capacity`, `name_type`, `brand_id`) VALUES
(1, 6, 'Toyota Rush', 1),
(2, 5, 'sport', 1),
(3, 4, 'Convertible', 3),
(4, 2, 'Pick Up', 4),
(5, 4, 'VAn / mini bus', 1),
(6, 5, 'Off Roader', 4),
(7, 2, 'Sport Utility Vehicle', 5),
(8, 4, 'Multi Purpose Vehicle', 6),
(9, 6, 'Mobil Hybrid', 3),
(10, 7, 'Mobil Elektrik', 3),
(11, 2, 'Sport Sedan', 3);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_year`
--

CREATE TABLE `vehicle_year` (
  `id` int(11) NOT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle_year`
--

INSERT INTO `vehicle_year` (`id`, `year`) VALUES
(7, '2012'),
(5, '2021'),
(6, '2015'),
(8, '2011'),
(9, '2010'),
(10, '2009'),
(11, '2007'),
(12, '2014'),
(13, '2016'),
(14, '2017'),
(15, '2018'),
(16, '2019'),
(17, '2020'),
(18, '2022');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `price_list`
--
ALTER TABLE `price_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp2124uiklj6b9sx9baskuf1cc` (`vehicle_model_id`),
  ADD KEY `FKqrij8abt2tml9pb5ss1nw9ssv` (`model_id`),
  ADD KEY `FK3whn4750jegjajxdwwxex58uw` (`year_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vehicle_brand`
--
ALTER TABLE `vehicle_brand`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vehicle_model`
--
ALTER TABLE `vehicle_model`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6ixxkcqsmanyc9g0aqkpw8op3` (`type_id`);

--
-- Indexes for table `vehicle_type`
--
ALTER TABLE `vehicle_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl0h3s6d9h3o9cl03wq99p60aa` (`brand_id`);

--
-- Indexes for table `vehicle_year`
--
ALTER TABLE `vehicle_year`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `price_list`
--
ALTER TABLE `price_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vehicle_brand`
--
ALTER TABLE `vehicle_brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `vehicle_model`
--
ALTER TABLE `vehicle_model`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `vehicle_type`
--
ALTER TABLE `vehicle_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `vehicle_year`
--
ALTER TABLE `vehicle_year`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

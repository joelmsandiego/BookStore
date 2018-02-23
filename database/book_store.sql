-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 23, 2018 at 04:11 PM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_info`
--

CREATE TABLE `book_info` (
  `book_id` bigint(20) NOT NULL,
  `book_tittle` text NOT NULL,
  `book_author` text NOT NULL,
  `book_genre` text NOT NULL,
  `price` double NOT NULL,
  `created_by` text NOT NULL,
  `created_date` text NOT NULL,
  `last_modified_by` text NOT NULL,
  `last_modified_date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_info`
--

INSERT INTO `book_info` (`book_id`, `book_tittle`, `book_author`, `book_genre`, `price`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`) VALUES
(6, 'hello bite', 'Joel2', 'journey the 2nd', 500, 'joel', '2018-02-22', 'joel', '2018-02-22'),
(7, 'hello bite', 'Joel2', 'journey the 3nd', 500, 'joel', '2018-02-22', 'joel', '2018-02-22'),
(8, 'hello bite', 'Joel2Joel2Joel2', 'journey the 3nd', 500, 'joel', '2018-02-22', 'joel', '2018-02-22'),
(9, 'hello bite', 'Rouge', 'journey the 3nd', 500, 'joel', '2018-02-22', 'joel', '2018-02-22'),
(10, 'hello bite', 'Rouge', 'journey the 3nd', 500, 'joel', '2018-02-22', 'joel', '2018-02-22'),
(11, 'hello bite', 'Rouge', 'journey the 3nd', 500, 'joel', '2018-02-22', 'joel', '2018-02-22'),
(12, 'hello', 'joel the man', 'action', 500, 'jj', '2018-02-23', 'jj', '2018-02-23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_info`
--
ALTER TABLE `book_info`
  ADD PRIMARY KEY (`book_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_info`
--
ALTER TABLE `book_info`
  MODIFY `book_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

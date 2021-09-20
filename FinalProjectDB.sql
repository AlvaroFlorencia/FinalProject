-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2021 at 06:55 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `name`, `email`, `password`) VALUES
(1, 'rahul', 'rahul@gmail.com', 'pass'),
(2, 'ankit', 'ankit@gmail.com', 'pass'),
(3, 'gowthami', 'gowthami@gmail.com', 'pass'),
(4, 'aishwarya', 'aishwarya@gmail.com', 'pass'),
(5, 'harshitha', 'harshitha@gmail.com', 'pass');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone_no` int(11) DEFAULT NULL,
  `Messege` varchar(20) DEFAULT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`user_id`, `name`, `Email`, `Phone_no`, `Messege`, `contact_id`) VALUES
(101, 'Ankit', 'ankit@gmail.com', 1234, 'Message', 1),
(102, 'Rahul', 'rahul@gmail.com', 1235, 'Message', 2),
(103, 'Gouthami', 'Gouthami@gmail.com', 1236, 'Message', 3),
(104, 'Ishwarya', 'Ishwarya@gmail.com', 1237, 'Message', 4),
(105, 'Harshitha', 'Harshitha@gmail.com', 1238, 'Message', 5);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `c_name` varchar(100) DEFAULT NULL,
  `c_desp` varchar(100) DEFAULT NULL,
  `c_fees` varchar(100) DEFAULT NULL,
  `c_resource` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `c_name`, `c_desp`, `c_fees`, `c_resource`) VALUES
(111, 'JAVA', 'Programing language', '299', 'video.mp4'),
(112, 'C Programming', 'Programming language', '199', 'cprogram.mp4'),
(113, 'C++ Programming', 'Programming language', '199', 'c++program.mp4');

-- --------------------------------------------------------

--
-- Table structure for table `courseuser`
--

CREATE TABLE `courseuser` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courseuser`
--

INSERT INTO `courseuser` (`id`, `user_id`, `course_id`) VALUES
(2, 101, 112),
(4, 0, 111),
(5, 108, 111);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `f_id` int(11) NOT NULL,
  `feedback` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`user_id`, `name`, `email`, `f_id`, `feedback`) VALUES
(101, 'ankit', 'ankit@gmail.com', 1, 'good'),
(105, 'harshitha', 'harshitha@gmail.com', 2, 'good'),
(101, 'Luis Alvaro Florencia Sanchez', 'luisalvf@amdocs.com', 7, 'erfrfmr');

-- --------------------------------------------------------

--
-- Table structure for table `user1`
--

CREATE TABLE `user1` (
  `user_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone_no` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT current_timestamp(),
  `password` varchar(100) DEFAULT NULL,
  `upload_photo` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user1`
--

INSERT INTO `user1` (`user_id`, `name`, `phone_no`, `email`, `address`, `reg_date`, `password`, `upload_photo`) VALUES
(101, 'Ankit', 2147483647, 'ankit@gmail.com', 'noida', '2021-09-14', 'ankit', 'rock.jpg'),
(102, 'Rahul', 2147483647, 'rahul@gmail.com', 'banglore', '2021-09-14', 'rahul', 'img1.jpg'),
(103, 'gouthami', 2147483647, 'gouthami@gmail.com', 'anantapur', '2021-09-14', 'gouthami', 'img2.jpg'),
(104, 'iswarya', 2147483647, 'iswarya@gmail.com', 'nellore', '2021-09-14', 'iswarya', 'img3.jpg'),
(105, 'harshitha', 2147483647, 'harshitha@gmail.com', 'vijayawada', '2021-09-14', 'harshitha', 'img4.jpg'),
(109, 'Alvarin', 836, 'ccrcr', 'cdddd', '2021-09-19', 'd33e3', 'rock.jpg'),
(110, 'cr', 83, 'luisalvf@amdocs.com', 'Virtual', '2021-09-19', '12d', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `courseuser`
--
ALTER TABLE `courseuser`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`f_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user1`
--
ALTER TABLE `user1`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT for table `courseuser`
--
ALTER TABLE `courseuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `f_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user1`
--
ALTER TABLE `user1`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user1` (`user_id`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user1` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

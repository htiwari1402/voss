-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2015 at 06:50 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `voss`
--

-- --------------------------------------------------------

--
-- Table structure for table `bankmaster`
--

CREATE TABLE IF NOT EXISTS `bankmaster` (
`pk_bankID` int(8) NOT NULL,
  `country` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `desc` varchar(80) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `accNo` varchar(10) DEFAULT NULL,
  `swift` varchar(20) DEFAULT NULL,
  `contactNo` varchar(10) DEFAULT NULL,
  `emailID` varchar(40) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `details` varchar(300) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `bankmaster`
--

INSERT INTO `bankmaster` (`pk_bankID`, `country`, `name`, `desc`, `address`, `accNo`, `swift`, `contactNo`, `emailID`, `status`, `details`) VALUES
(5, '55', 'ABB', 'ABB', 'Powai, Mumbai,Maharashtra(India)', 'gsdaj213', '23178sajhg8127', '231982139', 'jhsadjhsaj', 'Enable', 'dasgdlglsagdlsgld'),
(6, '55', 'bhu', 'gfdgfgsf', NULL, NULL, NULL, NULL, NULL, 'Enable', NULL),
(7, '02', 'jpa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, '79', 'uk1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, '79', 'Swiss Bank', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, '55', 'abbbbb', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, '79', 'uk4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '79', 'uk5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, '79', 'uk6', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(14, '79', 'uk77', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(15, '79', 'uk778', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(16, '79', 'uk7789', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `businessunitmaster`
--

CREATE TABLE IF NOT EXISTS `businessunitmaster` (
`buID` int(20) NOT NULL,
  `code` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `designations`
--

CREATE TABLE IF NOT EXISTS `designations` (
  `designation` varchar(60) NOT NULL,
`designationId` int(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `designations`
--

INSERT INTO `designations` (`designation`, `designationId`) VALUES
('Salesman', 1),
('Sales Manager', 2);

-- --------------------------------------------------------

--
-- Table structure for table `productmaster`
--

CREATE TABLE IF NOT EXISTS `productmaster` (
  `name` varchar(40) NOT NULL,
  `desc` varchar(60) NOT NULL,
  `status` varchar(10) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `specification` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productmaster`
--

INSERT INTO `productmaster` (`name`, `desc`, `status`, `grade`, `specification`) VALUES
('Cipla', 'Medicine', 'Enabled', 'A', 'leads to death');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE IF NOT EXISTS `request` (
  `userName` varchar(50) NOT NULL,
  `requestType` varchar(50) NOT NULL,
  `activationFlag` int(10) NOT NULL,
  `date` date NOT NULL,
  `data` varchar(10000) NOT NULL,
  `apiCall` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userregistration`
--

CREATE TABLE IF NOT EXISTS `userregistration` (
  `userName` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `reportingManager` varchar(50) NOT NULL,
`userId` int(30) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `userregistration`
--

INSERT INTO `userregistration` (`userName`, `name`, `designation`, `reportingManager`, `userId`, `password`) VALUES
('amit', 'Amit Singh', 'GM', 'None', 1, 'amit'),
('htiwari1402', 'Himanshu Tiwari', 'Sales Manager', 'None', 2, 'himanshu'),
('ter54', 'Terry', 'Salesman', 'None', 3, 'terwer'),
('yerty', 'yergher', 'Salesman', 'htiwari1402', 4, 'yerty');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bankmaster`
--
ALTER TABLE `bankmaster`
 ADD PRIMARY KEY (`pk_bankID`);

--
-- Indexes for table `businessunitmaster`
--
ALTER TABLE `businessunitmaster`
 ADD PRIMARY KEY (`buID`);

--
-- Indexes for table `designations`
--
ALTER TABLE `designations`
 ADD PRIMARY KEY (`designationId`);

--
-- Indexes for table `userregistration`
--
ALTER TABLE `userregistration`
 ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bankmaster`
--
ALTER TABLE `bankmaster`
MODIFY `pk_bankID` int(8) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `businessunitmaster`
--
ALTER TABLE `businessunitmaster`
MODIFY `buID` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `designations`
--
ALTER TABLE `designations`
MODIFY `designationId` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `userregistration`
--
ALTER TABLE `userregistration`
MODIFY `userId` int(30) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

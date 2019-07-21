-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2019 at 05:17 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jaljivika`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `Activity_id` varchar(20) NOT NULL,
  `Activity_name` text,
  `Description` text,
  `Pond_id` varchar(20) DEFAULT NULL,
  `farmer_id` varchar(20) NOT NULL,
  `Breed` text,
  `Quantity` text,
  `Status` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cat_id` int(11) DEFAULT NULL,
  `CAT_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `CAT_name`) VALUES
(1, 'Farmer'),
(2, 'Fish Buyer'),
(3, 'Supplier'),
(4, 'Expert'),
(5, ' PondOwner');

-- --------------------------------------------------------

--
-- Table structure for table `changes`
--

CREATE TABLE `changes` (
  `change_id` varchar(20) NOT NULL,
  `Activity_id` varchar(20) DEFAULT NULL,
  `Change_reason` text,
  `Change_desc` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `expert`
--

CREATE TABLE `expert` (
  `Expert_id` varchar(20) NOT NULL,
  `Expert_name` text,
  `expert_location` text,
  `Expert_state` text,
  `Expert_district` text,
  `Expert_contact` text,
  `Category_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expert`
--

INSERT INTO `expert` (`Expert_id`, `Expert_name`, `expert_location`, `Expert_state`, `Expert_district`, `Expert_contact`, `Category_id`) VALUES
('e1', 'Raj Shinde', 'Mumbai', 'Maharashtra', 'Mumbai', '9087655678', 'expert'),
('e2', 'Akash Dube', 'Malvan', 'Maharashtra', 'Malvan', '9087655670', 'expert'),
('e3', 'Raj Shinde', 'jai', 'Maharashtra', 'Jaigad', '9087655691', 'expert');

-- --------------------------------------------------------

--
-- Table structure for table `farmer`
--

CREATE TABLE `farmer` (
  `f_id` varchar(20) NOT NULL,
  `f_name` text,
  `location` text,
  `state` varchar(20) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `cid` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmer`
--

INSERT INTO `farmer` (`f_id`, `f_name`, `location`, `state`, `district`, `contact`, `cid`) VALUES
('f1', 'Gauri  Raja', '106 /, Choolai High Road', 'Tamil Nadu', 'Chennai', '04426691670', 'Farmer'),
('f10', 'Varun Mehta', 'jai', 'Maharashtra', 'Jaigad', '04426691677', 'Farmer'),
('f2', 'Manda  Walia', 'Faridabad', 'Delhi', 'Faridabad', '01292421389', 'Farmer'),
('f3', 'Yash Kabra', 'Nasik', 'Maharashtra', 'Nasik', '04426601670', 'Farmer'),
('f4', 'Akshay Kabra', 'Malad', 'Maharashtra', 'Mumbai', '04426691671', 'Farmer'),
('f5', 'Pooja Patil', 'Masjid Bandar', 'Maharashtra', 'Mumbai', '04426691672', 'Farmer'),
('f6', 'Ajay Wadia', 'Malvan', 'Maharashtra', 'Malvan', '04426691673', 'Farmer'),
('f7', 'Omkar Ghadi', 'K1', 'Maharashtra', 'Kolhapur', '04426691674', 'Farmer'),
('f8', 'Raj Thakur', 'Ratna', 'Maharashtra', 'Ratnagiri', '04426691675', 'Farmer'),
('f9', 'Jay More', 'Jaigad', 'Maharashtra', 'Jaigad', '04426691676', 'Farmer');

-- --------------------------------------------------------

--
-- Table structure for table `fish_buyer`
--

CREATE TABLE `fish_buyer` (
  `fb_id` varchar(20) NOT NULL,
  `fb_name` text,
  `fb_location` text,
  `fb_state` varchar(20) DEFAULT NULL,
  `fb_district` varchar(20) DEFAULT NULL,
  `fb_contact` varchar(20) DEFAULT NULL,
  `cid` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fish_buyer`
--

INSERT INTO `fish_buyer` (`fb_id`, `fb_name`, `fb_location`, `fb_state`, `fb_district`, `fb_contact`, `cid`) VALUES
('b1', 'Sachin Ghag', 'Malad', 'Maharashtra', 'Mumbai', '8585858585', 'Fish Buyer'),
('b2', 'Kenneth Sebastian', 'Raigad', 'Maharashtra', 'Jaigad', '9876543210', 'Fish Buyer'),
('b3', 'Shivaji Naik', 'Malad', 'Maharashtra', 'Kolhapur', '9807654320', 'Fish Buyer'),
('b4', 'Pranav Rajput', 'Malvan', 'Maharashtra', 'Malvani', '8907654321', 'Fish Buyer'),
('b5', 'Devangana Sharma', 'Ratna', 'Maharashtra', 'Ratnagiri', '9102837465', 'Fish Buyer');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pondowner`
--

CREATE TABLE `pondowner` (
  `pondowner_id` varchar(20) NOT NULL,
  `pond_details_id` varchar(20) DEFAULT NULL,
  `pond_name` text,
  `pondowner_contact` text,
  `Category_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pondowner`
--

INSERT INTO `pondowner` (`pondowner_id`, `pond_details_id`, `pond_name`, `pondowner_contact`, `Category_id`) VALUES
('po1', 'pond2', 'pond name 1', '9870634532', 'pond owner'),
('po2', 'pond3', 'pond name 2', '8976543210', 'pond owner'),
('po3', 'pond1', 'pond name 3', '9867542310', 'Pond Owner');

-- --------------------------------------------------------

--
-- Table structure for table `pond_details`
--

CREATE TABLE `pond_details` (
  `Pond_details_id` varchar(20) NOT NULL,
  `location` text NOT NULL,
  `Pond_area` text,
  `Pond_depth` text,
  `Soil_ph` text,
  `Water_ph` text,
  `Rent` varchar(20) DEFAULT NULL,
  `Time_period` text,
  `Timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pond_details`
--

INSERT INTO `pond_details` (`Pond_details_id`, `location`, `Pond_area`, `Pond_depth`, `Soil_ph`, `Water_ph`, `Rent`, `Time_period`, `Timestamp`) VALUES
('pond1', 'Mumbai', '200', '1', '4.5', '6.5', 'f4', '6', '2008-11-11 13:23:44'),
('pond2', 'Kolhapur', '500', '2', '4', '5', '0', '12', '2008-11-09 15:45:21'),
('pond3', 'Malvan', '800', '1.5', '7.5', '7.5', '0', '24', '2008-10-29 14:56:59');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_id` varchar(20) NOT NULL,
  `Product_name` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_id`, `Product_name`) VALUES
('pr1', 'Wallago'),
('pr10', 'Ground Nut Cake'),
('pr11', 'Wallago Seed'),
('pr12', 'Pabda Seed'),
('pr13', 'Channa Striata Seed'),
('pr14', 'Calbasu Seed'),
('pr15', 'Trout Seed'),
('pr2', 'Pabda'),
('pr3', 'Channa Striata'),
('pr4', 'Calbasu'),
('pr5', 'Trout'),
('pr6', 'Fishing Net'),
('pr7', 'Brood Stock'),
('pr8', 'Mustard Cake'),
('pr9', 'Rice Bran');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_id` varchar(20) NOT NULL,
  `Supplier_name` text,
  `Supplier_location` text,
  `Supplier_state` text,
  `Supplier_district` text,
  `Supplier_contact` text,
  `Category_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_id`, `Supplier_name`, `Supplier_location`, `Supplier_state`, `Supplier_district`, `Supplier_contact`, `Category_id`) VALUES
('s1', 'Akshay Gupta', 'Mumbai', 'Maharashtra', 'Mumbai', '987654123', 'supplier'),
('s2', 'Amit Gupta', 'Malvan', 'Maharashtra', 'malvan', '987654124', 'supplier'),
('s3', 'Akshay Chadda', 'Kolhapur', 'Maharashtra', 'kolhapur', '987654125', 'supplier');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'demo', 'demo@farmer.com', '$2y$10$IgE/QMms36SqHf64tU.UCuGE31RLPUrxPGIifS6O4oiCa6gNq7Cs2', NULL, '2019-07-20 09:27:18', '2019-07-20 09:27:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`Activity_id`),
  ADD KEY `Pond_id` (`Pond_id`),
  ADD KEY `farmer_id` (`farmer_id`);

--
-- Indexes for table `changes`
--
ALTER TABLE `changes`
  ADD PRIMARY KEY (`change_id`),
  ADD KEY `Activity_id` (`Activity_id`);

--
-- Indexes for table `expert`
--
ALTER TABLE `expert`
  ADD PRIMARY KEY (`Expert_id`);

--
-- Indexes for table `farmer`
--
ALTER TABLE `farmer`
  ADD PRIMARY KEY (`f_id`);

--
-- Indexes for table `fish_buyer`
--
ALTER TABLE `fish_buyer`
  ADD PRIMARY KEY (`fb_id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pondowner`
--
ALTER TABLE `pondowner`
  ADD PRIMARY KEY (`pondowner_id`),
  ADD KEY `pond_details_id` (`pond_details_id`);

--
-- Indexes for table `pond_details`
--
ALTER TABLE `pond_details`
  ADD PRIMARY KEY (`Pond_details_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`Pond_id`) REFERENCES `pond_details` (`Pond_details_id`),
  ADD CONSTRAINT `activity_ibfk_2` FOREIGN KEY (`farmer_id`) REFERENCES `farmer` (`f_id`);

--
-- Constraints for table `changes`
--
ALTER TABLE `changes`
  ADD CONSTRAINT `changes_ibfk_1` FOREIGN KEY (`Activity_id`) REFERENCES `activity` (`Activity_id`);

--
-- Constraints for table `pondowner`
--
ALTER TABLE `pondowner`
  ADD CONSTRAINT `pondowner_ibfk_1` FOREIGN KEY (`pond_details_id`) REFERENCES `pond_details` (`Pond_details_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

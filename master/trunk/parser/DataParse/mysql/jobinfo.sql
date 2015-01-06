/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : job

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-12-25 11:50:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jobinfo`
-- ----------------------------
DROP TABLE IF EXISTS `jobinfo`;
CREATE TABLE `jobinfo` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `month_salary` varchar(20) DEFAULT NULL,
  `job_location` varchar(20) DEFAULT NULL,
  `announce_time` date DEFAULT NULL,
  `job_property` varchar(20) DEFAULT NULL,
  `job_experience` varchar(20) DEFAULT NULL,
  `education_limit` varchar(20) DEFAULT NULL,
  `hire_num` varchar(20) DEFAULT NULL,
  `job_category` varchar(20) DEFAULT NULL,
  `job_position` varchar(200) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `file_dir` varchar(20) DEFAULT NULL,
  `average_salary` float DEFAULT NULL,
  `hire_num_trans` int(11) DEFAULT NULL,
  `job_experience_trans` float DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61757 DEFAULT CHARSET=utf8;
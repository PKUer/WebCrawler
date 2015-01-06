/*
Navicat MySQL Data Transfer

Source Server         : cloudprint
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : jobresult

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-01-06 15:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `analysisresult`
-- ----------------------------
DROP TABLE IF EXISTS `analysisresult`;
CREATE TABLE `analysisresult` (
  `analysisId` int(11) NOT NULL AUTO_INCREMENT,
  `city` int(11) DEFAULT NULL,
  `positionName` varchar(255) DEFAULT NULL,
  `peopleNum` int(11) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`analysisId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of analysisresult
-- ----------------------------
INSERT INTO `analysisresult` VALUES ('1', '0', 'WEB工程师', '14124', '10155', '0');
INSERT INTO `analysisresult` VALUES ('2', '0', 'C++工程师', '8386', '7670', '0');
INSERT INTO `analysisresult` VALUES ('3', '0', 'java工程师', '49150', '8236', '0');
INSERT INTO `analysisresult` VALUES ('4', '0', 'Android工程师', '13884', '8764', '0');
INSERT INTO `analysisresult` VALUES ('5', '0', 'ios工程师', '11372', '12999', '0');
INSERT INTO `analysisresult` VALUES ('6', '0', 'WinPhone工程师', '16', '0', '0');
INSERT INTO `analysisresult` VALUES ('7', '1', 'WEB工程师', '4584', '11325', '1');
INSERT INTO `analysisresult` VALUES ('8', '1', 'C++工程师', '3989', '8331', '1');
INSERT INTO `analysisresult` VALUES ('9', '1', 'java工程师', '19518', '8171', '1');
INSERT INTO `analysisresult` VALUES ('10', '1', 'Android工程师', '5168', '9416', '1');
INSERT INTO `analysisresult` VALUES ('11', '1', 'ios工程师', '3379', '14290', '1');
INSERT INTO `analysisresult` VALUES ('12', '1', 'WinPhone工程师', '4', '0', '1');
INSERT INTO `analysisresult` VALUES ('13', '2', 'WEB工程师', '2561', '10477', '1');
INSERT INTO `analysisresult` VALUES ('14', '2', 'C++工程师', '1586', '6991', '1');
INSERT INTO `analysisresult` VALUES ('15', '2', 'java工程师', '10869', '9705', '1');
INSERT INTO `analysisresult` VALUES ('16', '2', 'Android工程师', '2883', '9409', '1');
INSERT INTO `analysisresult` VALUES ('17', '2', 'ios工程师', '3124', '13418', '1');
INSERT INTO `analysisresult` VALUES ('18', '2', 'WinPhone工程师', '4', '0', '1');
INSERT INTO `analysisresult` VALUES ('19', '3', 'WEB工程师', '2325', '8157', '1');
INSERT INTO `analysisresult` VALUES ('20', '3', 'C++工程师', '847', '7662', '1');
INSERT INTO `analysisresult` VALUES ('21', '3', 'java工程师', '6181', '7947', '1');
INSERT INTO `analysisresult` VALUES ('22', '3', 'Android工程师', '1524', '9238', '1');
INSERT INTO `analysisresult` VALUES ('23', '3', 'ios工程师', '1617', '10675', '1');
INSERT INTO `analysisresult` VALUES ('24', '3', 'WinPhone工程师', '8', '0', '1');
INSERT INTO `analysisresult` VALUES ('25', '4', 'WEB工程师', '2984', '9556', '1');
INSERT INTO `analysisresult` VALUES ('26', '4', 'C++工程师', '1041', '6525', '1');
INSERT INTO `analysisresult` VALUES ('27', '4', 'java工程师', '6918', '7573', '1');
INSERT INTO `analysisresult` VALUES ('28', '4', 'Android工程师', '2427', '7515', '1');
INSERT INTO `analysisresult` VALUES ('29', '4', 'ios工程师', '1846', '12193', '1');
INSERT INTO `analysisresult` VALUES ('30', '4', 'WinPhone工程师', '0', '0', '1');
INSERT INTO `analysisresult` VALUES ('31', '5', 'WEB工程师', '1670', '8972', '1');
INSERT INTO `analysisresult` VALUES ('32', '5', 'C++工程师', '923', '7988', '1');
INSERT INTO `analysisresult` VALUES ('33', '5', 'java工程师', '5662', '7378', '1');
INSERT INTO `analysisresult` VALUES ('34', '5', 'Android工程师', '1882', '7895', '1');
INSERT INTO `analysisresult` VALUES ('35', '5', 'ios工程师', '1406', '12365', '1');
INSERT INTO `analysisresult` VALUES ('36', '5', 'WinPhone工程师', '0', '0', '1');

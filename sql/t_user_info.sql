/*
Navicat MySQL Data Transfer

Source Server         : hacker
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : gdatafront

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-04-11 23:09:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `class_no` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('1', '1001', 'zhangsan', '2012001');

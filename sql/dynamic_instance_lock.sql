/*
Navicat MySQL Data Transfer

Source Server         : hacker
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : gdatafront

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-04-21 21:38:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dynamic_instance_lock
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_instance_lock`;
CREATE TABLE `dynamic_instance_lock` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `lock_type` varchar(32) NOT NULL,
  `lock_desc` varchar(132) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamic_instance_lock
-- ----------------------------
INSERT INTO `dynamic_instance_lock` VALUES ('1', '2019-04-21 21:36:41', '2019-04-21 21:36:45', 'DYNAMIC_TASK_CONFIG_LOCK', '配置锁');
INSERT INTO `dynamic_instance_lock` VALUES ('2', '2019-04-21 21:37:16', '2019-04-21 21:37:20', 'DYNAMIC_TASK_INSTANCE_LOCK', '实例锁');

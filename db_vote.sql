/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : db_vote

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 27/11/2020 16:52:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_vote
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote`;
CREATE TABLE `tb_vote`  (
  `tea_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老师id',
  `tea_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vote` int NULL DEFAULT NULL,
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_vote
-- ----------------------------
INSERT INTO `tb_vote` VALUES ('1001', '张老师', 89);
INSERT INTO `tb_vote` VALUES ('1002', '李老师', 64);
INSERT INTO `tb_vote` VALUES ('1003', '咕咕咕', 63);
INSERT INTO `tb_vote` VALUES ('1004', 'MC', 7);
INSERT INTO `tb_vote` VALUES ('1005', '益达', 1);

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : ALISeverMysql
 Source Server Type    : MySQL
 Source Server Version : 50631
 Source Host           : 39.96.26.57:3306
 Source Schema         : epidemic

 Target Server Type    : MySQL
 Target Server Version : 50631
 File Encoding         : 65001

 Date: 17/03/2020 20:38:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for stu_epidemic
-- ----------------------------
DROP TABLE IF EXISTS `stu_epidemic`;
CREATE TABLE `stu_epidemic`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `stuno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `stuname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `phone` char(22) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `colleage` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院',
  `classname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `fillintdate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '填报日期',
  `isabroad` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否留学生',
  `ishubei` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否湖北籍(不含武汉学生)',
  `iwuhan` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否武汉籍',
  `inwuhan` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否在武汉',
  `ishubeicontact` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '14天与湖北籍疫区人员接触过',
  `iswuhancontact` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '14天与武汉籍疫区人员接触过',
  `inhubei` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否在湖北',
  `isgotoschool` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否今天从外地返校',
  `isdistrust` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否疑似病例',
  `isdiagnose` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否确诊',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_epidemic
-- ----------------------------
INSERT INTO `stu_epidemic` VALUES (158444821698539, '100001', '杨荣庆', '15352125529', '计算机科学与工程学院', '2017级计算机科学与技术', '2020-03-17', '否', '否', '否', '否', '否', '是', '否', '是', '否', '否');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `stuno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码 默认学号',
  `stuname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `phone` char(22) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `colleage` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院',
  `classname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  PRIMARY KEY (`stuno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '100001', '123456', '杨荣庆', '15352125529', '计算机科学与工程学院', '2017级计算机科学与技术');

SET FOREIGN_KEY_CHECKS = 1;

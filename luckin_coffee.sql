/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : luckin_coffee

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 25/12/2022 15:39:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `areaCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `county` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `isDefault` int DEFAULT '0',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `addressDetail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of address
-- ----------------------------
BEGIN;
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (25, '130202', '唐山市', '路南区', 0, '测试', '河北省', '15177386668', '撒大大');
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (26, '130102', '石家庄市', '长安区', 0, '新增', '河北省', '15177386668', '阿撒打算大');
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (27, '150925', '乌兰察布市', '凉城县', 0, '黄俊炜', '内蒙古自治区', '15177386668', '科大分校');
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (31, '110101', '北京市', '东城区', 1, 'huangjunwei', '北京市', '15177386668', '13123');
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (32, '120102', '天津市', '河东区', 1, 'ceshi', '天津市', '15177386668', '123');
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (33, '110101', '北京市', '东城区', 0, '打个', '北京市', '15177386668', '随便');
INSERT INTO `address` (`id`, `areaCode`, `city`, `county`, `isDefault`, `name`, `province`, `tel`, `addressDetail`) VALUES (34, '110119', '北京市', '延庆区', 1, '肾大侠', '北京市', '15177386668', '收货地址1111');
COMMIT;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `origin_price` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `thumb` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (2, '橙之海', '清新香橙芝士蛋糕', 22.1, '35', 'https://inews.gtimg.com/newsapp_bt/0/15374405403/1000');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (3, '土耳其榛巧拿铁', '榛香浓郁，黑巧风味', 22.5, '35', 'https://bkimg.cdn.bcebos.com/pic/eaf81a4c510fd9f9a452ad1a2b2dd42a2834a478');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (4, '圣诞烤布丁拿铁', '流动的法式布丁', 21.5, '35', 'https://inews.gtimg.com/newsapp_bt/0/15466083963/1000');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (5, '丝绒拿铁', '超丝滑、年度重磅', 20.5, '32', 'https://qny.smzdm.com/202206/27/62b9467474e584197.jpg_d250.jpg');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (6, '生椰拿铁', '人气|yyds,无限回购', 20.1, '32', 'https://img.xianjichina.com/editer/20210902/image/e9a22278dd98e9804e42faa0e961cab2.jpg');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (7, '椰云拿铁', '一口吞云，轻盈飘逸', 21.52, '32', 'https://img.shangyexinzhi.com/xztest-image/article/55d8ac1311f0400a2810d7bec40fc4db.jpeg');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (8, '生椰爱摩卡', '经典口味', 21.66, '35', 'http://5b0988e595225.cdn.sohucs.com/images/20190426/4d858e9b4a5c49be8d05c8a379dbce9c.jpeg');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (16, '测试11', '好喝', 8.5, '19.9', 'http://5b0988e595225.cdn.sohucs.com/images/20190426/4d858e9b4a5c49be8d05c8a379dbce9c.jpeg');
INSERT INTO `goods` (`id`, `title`, `detail`, `price`, `origin_price`, `thumb`) VALUES (17, '白开水', '多喝热水', 1.5, '2.9', 'http://5b0988e595225.cdn.sohucs.com/images/20190426/4d858e9b4a5c49be8d05c8a379dbce9c.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `path` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` (`id`, `title`, `path`) VALUES (1, '人气top', '/menu');
INSERT INTO `menu` (`id`, `title`, `path`) VALUES (2, '生酪拿铁', '/menu/slnt');
INSERT INTO `menu` (`id`, `title`, `path`) VALUES (3, '丝绒拿铁', '/menu/srnt');
INSERT INTO `menu` (`id`, `title`, `path`) VALUES (4, '生椰拿铁', '/menu/synt');
INSERT INTO `menu` (`id`, `title`, `path`) VALUES (5, '圣诞限定', '/menu/sdxd');
COMMIT;

-- ----------------------------
-- Table structure for menu_goods
-- ----------------------------
DROP TABLE IF EXISTS `menu_goods`;
CREATE TABLE `menu_goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `menu_goods_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of menu_goods
-- ----------------------------
BEGIN;
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (2, 2, 2);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (3, 3, 3);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (4, 3, 4);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (5, 3, 5);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (6, 4, 6);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (7, 4, 7);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (8, 4, 8);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (15, 1, 5);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (22, 1, 16);
INSERT INTO `menu_goods` (`id`, `menu_id`, `goods_id`) VALUES (23, 5, 17);
COMMIT;

-- ----------------------------
-- Table structure for order_address
-- ----------------------------
DROP TABLE IF EXISTS `order_address`;
CREATE TABLE `order_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of order_address
-- ----------------------------
BEGIN;
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (6, '20221212153643118390', 26);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (7, '20221212154815996114', 26);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (8, '20221212154941766808', 26);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (9, '20221212155025613129', 25);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (10, '20221213102758591831', 25);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (11, '20221222135759854406', 25);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (12, '20221222135933363741', 25);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (13, '20221222140321428537', 26);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (14, '2022122315355380457', 33);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (15, '20221223154316586601', 33);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (16, '20221223211600911179', 34);
INSERT INTO `order_address` (`id`, `order_id`, `address_id`) VALUES (17, '20221223212438622234', 34);
COMMIT;

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `sugar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cup` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `temperature` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
BEGIN;
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (23, '20221212153643118390', 3, '半糖', '中杯', '热', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (24, '20221212154815996114', 5, '标准塘', '中杯', '冰', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (25, '20221212154941766808', 4, '半糖', '大杯', '冰', 2);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (26, '20221212154941766808', 5, '标准塘', '大杯', '热', 4);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (27, '20221212155025613129', 5, '半糖', '大杯', '热', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (28, '20221213102758591831', 6, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (29, '20221222135759854406', 1, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (30, '20221222135933363741', 3, '标准塘', '中杯', '热', 3);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (31, '20221222140321428537', 1, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (32, '2022122315355380457', 5, '标准塘', '大杯', '热', 3);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (33, '2022122315355380457', 4, '标准塘', '大杯', '冰', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (34, '20221223154316586601', 16, '半糖', '中杯', '冰', 4);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (35, '20221223154316586601', 5, '标准塘', '大杯', '热', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (36, '20221223211600911179', 5, '不加糖', '大杯', '热', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (37, '20221223211600911179', 5, '标准塘', '中杯', '冰', 1);
INSERT INTO `order_goods` (`id`, `order_id`, `goods_id`, `sugar`, `cup`, `temperature`, `count`) VALUES (38, '20221223212438622234', 17, '不加糖', '大杯', '热', 1);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `name`, `code`) VALUES (1, '管理员', 'admin');
INSERT INTO `role` (`id`, `name`, `code`) VALUES (2, '普通用户', 'member');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `tel`, `create_time`) VALUES (1, 'qiuyue', 'c6641d02deff8564ba9c6151b29b1229', '15177386668', '2022-12-06 18:41:05');
INSERT INTO `user` (`id`, `username`, `password`, `tel`, `create_time`) VALUES (2, 'test', 'c6641d02deff8564ba9c6151b29b1229', '18877265681', '2022-12-07 09:11:41');
INSERT INTO `user` (`id`, `username`, `password`, `tel`, `create_time`) VALUES (3, 'qiuyue1111', 'c6641d02deff8564ba9c6151b29b1229', '213123123', '2022-12-08 16:46:56');
INSERT INTO `user` (`id`, `username`, `password`, `tel`, `create_time`) VALUES (4, 'qiuyue888', '15def767724ff28a1f504e17c6eca3f9', '18877265682', '2022-12-09 14:50:04');
INSERT INTO `user` (`id`, `username`, `password`, `tel`, `create_time`) VALUES (5, '18877266668', '4a832de8114d65b4b86df74fc075755d', '18877266662', '2022-12-09 15:05:57');
INSERT INTO `user` (`id`, `username`, `password`, `tel`, `create_time`) VALUES (6, '测试888', '15def767724ff28a1f504e17c6eca3f9', '18877261111', '2022-12-09 15:09:31');
COMMIT;

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user_address
-- ----------------------------
BEGIN;
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (21, 6, 25);
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (22, 6, 26);
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (23, 6, 27);
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (27, 1, 31);
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (28, 1, 32);
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (29, 1, 33);
INSERT INTO `user_address` (`id`, `user_id`, `address_id`) VALUES (30, 1, 34);
COMMIT;

-- ----------------------------
-- Table structure for user_like
-- ----------------------------
DROP TABLE IF EXISTS `user_like`;
CREATE TABLE `user_like` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user_like
-- ----------------------------
BEGIN;
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (5, 6, 4);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (8, 6, 2);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (12, 6, 8);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (13, 6, 1);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (14, 1, 1);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (16, 1, 16);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (17, 1, 5);
INSERT INTO `user_like` (`id`, `user_id`, `goods_id`) VALUES (18, 1, 17);
COMMIT;

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `order_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user_order
-- ----------------------------
BEGIN;
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (14, 6, '20221212153643118390', '2022-12-12 15:36:44');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (15, 6, '20221212154815996114', '2022-12-12 15:48:16');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (16, 6, '20221212154941766808', '2022-12-12 15:49:42');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (17, 6, '20221212155025613129', '2022-12-12 15:50:25');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (18, 6, '20221213102758591831', '2022-12-13 10:27:59');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (20, 6, '20221222135933363741', '2022-12-22 13:59:33');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (22, 1, '2022122315355380457', '2022-12-23 15:35:54');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (23, 1, '20221223154316586601', '2022-12-23 15:43:16');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (24, 1, '20221223211600911179', '2022-12-23 21:16:00');
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `create_time`) VALUES (25, 1, '20221223212438622234', '2022-12-23 21:24:39');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (1, 1, 1);
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (2, 2, 2);
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (3, 5, 2);
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (4, 6, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

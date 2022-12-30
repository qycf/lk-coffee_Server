/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : luckin_coffee

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/12/2022 20:25:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `areaCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `county` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `isDefault` int NULL DEFAULT 0,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `addressDetail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (25, '130202', '唐山市', '路南区', 0, '测试', '河北省', '15177386668', '撒大大');
INSERT INTO `address` VALUES (26, '130102', '石家庄市', '长安区', 0, '新增', '河北省', '15177386668', '阿撒打算大');
INSERT INTO `address` VALUES (27, '150925', '乌兰察布市', '凉城县', 0, '黄俊炜', '内蒙古自治区', '15177386668', '科大分校');
INSERT INTO `address` VALUES (31, '110101', '北京市', '东城区', 0, 'huangjunwei', '北京市', '15177386668', '13123');
INSERT INTO `address` VALUES (32, '120102', '天津市', '河东区', 0, 'ceshi', '天津市', '15177386668', '123');
INSERT INTO `address` VALUES (33, '110101', '北京市', '东城区', 0, '打个', '北京市', '15177386668', '随便');
INSERT INTO `address` VALUES (34, '110119', '北京市', '延庆区', 0, '肾大侠', '北京市', '15177386668', '收货地址1111');
INSERT INTO `address` VALUES (36, '450202', '柳州市', '城中区', 1, '黄俊炜', '广西壮族自治区', '15177386668', '广西科技大学');
INSERT INTO `address` VALUES (37, '120101', '天津市', '和平区', 1, '测试', '天津市', '15177386668', '1号楼33房间');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `origin_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `thumb` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (2, '橙之海', '清新香橙芝士蛋糕', 22.1, '35', 'https://inews.gtimg.com/newsapp_bt/0/15374405403/1000');
INSERT INTO `goods` VALUES (3, '土耳其榛巧拿铁', '榛香浓郁，黑巧风味', 22.5, '35', 'https://bkimg.cdn.bcebos.com/pic/eaf81a4c510fd9f9a452ad1a2b2dd42a2834a478');
INSERT INTO `goods` VALUES (4, '圣诞烤布丁拿铁', '流动的法式布丁', 21.5, '35', 'https://inews.gtimg.com/newsapp_bt/0/15466083963/1000');
INSERT INTO `goods` VALUES (5, '丝绒拿铁', '超丝滑、年度重磅', 20.5, '32', 'https://qny.smzdm.com/202206/27/62b9467474e584197.jpg_d250.jpg');
INSERT INTO `goods` VALUES (6, '生椰拿铁', '人气|yyds,无限回购', 20.1, '32', 'https://img.xianjichina.com/editer/20210902/image/e9a22278dd98e9804e42faa0e961cab2.jpg');
INSERT INTO `goods` VALUES (7, '椰云拿铁', '一口吞云，轻盈飘逸', 21.52, '32', 'https://img.shangyexinzhi.com/xztest-image/article/55d8ac1311f0400a2810d7bec40fc4db.jpeg');
INSERT INTO `goods` VALUES (8, '生椰爱摩卡', '经典口味', 21.66, '35', 'http://5b0988e595225.cdn.sohucs.com/images/20190426/4d858e9b4a5c49be8d05c8a379dbce9c.jpeg');
INSERT INTO `goods` VALUES (16, '测试11', '好喝', 8.5, '19.9', 'http://5b0988e595225.cdn.sohucs.com/images/20190426/4d858e9b4a5c49be8d05c8a379dbce9c.jpeg');
INSERT INTO `goods` VALUES (17, '白开水', '多喝热水', 1.5, '2.9', 'http://5b0988e595225.cdn.sohucs.com/images/20190426/4d858e9b4a5c49be8d05c8a379dbce9c.jpeg');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (0, '人气top', '/menu/top');
INSERT INTO `menu` VALUES (1, '生酪拿铁', '/menu/slnt');
INSERT INTO `menu` VALUES (2, '丝绒拿铁', '/menu/srnt');
INSERT INTO `menu` VALUES (3, '生椰拿铁', '/menu/synt');
INSERT INTO `menu` VALUES (4, '圣诞限定', '/menu/sdxd');
INSERT INTO `menu` VALUES (26, '新增测试', '/menu/new');

-- ----------------------------
-- Table structure for menu_goods
-- ----------------------------
DROP TABLE IF EXISTS `menu_goods`;
CREATE TABLE `menu_goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NULL DEFAULT NULL,
  `goods_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goods_id`(`goods_id` ASC) USING BTREE,
  CONSTRAINT `menu_goods_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_goods
-- ----------------------------
INSERT INTO `menu_goods` VALUES (2, 1, 2);
INSERT INTO `menu_goods` VALUES (3, 2, 3);
INSERT INTO `menu_goods` VALUES (4, 2, 4);
INSERT INTO `menu_goods` VALUES (5, 2, 5);
INSERT INTO `menu_goods` VALUES (6, 3, 6);
INSERT INTO `menu_goods` VALUES (7, 3, 7);
INSERT INTO `menu_goods` VALUES (8, 3, 8);
INSERT INTO `menu_goods` VALUES (15, 0, 5);
INSERT INTO `menu_goods` VALUES (22, 0, 16);
INSERT INTO `menu_goods` VALUES (23, 4, 17);

-- ----------------------------
-- Table structure for order_address
-- ----------------------------
DROP TABLE IF EXISTS `order_address`;
CREATE TABLE `order_address`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_address
-- ----------------------------
INSERT INTO `order_address` VALUES (6, '20221212153643118390', 26);
INSERT INTO `order_address` VALUES (7, '20221212154815996114', 26);
INSERT INTO `order_address` VALUES (8, '20221212154941766808', 26);
INSERT INTO `order_address` VALUES (9, '20221212155025613129', 25);
INSERT INTO `order_address` VALUES (10, '20221213102758591831', 25);
INSERT INTO `order_address` VALUES (11, '20221222135759854406', 25);
INSERT INTO `order_address` VALUES (12, '20221222135933363741', 25);
INSERT INTO `order_address` VALUES (13, '20221222140321428537', 26);
INSERT INTO `order_address` VALUES (14, '2022122315355380457', 33);
INSERT INTO `order_address` VALUES (15, '20221223154316586601', 33);
INSERT INTO `order_address` VALUES (16, '20221223211600911179', 34);
INSERT INTO `order_address` VALUES (17, '20221223212438622234', 34);
INSERT INTO `order_address` VALUES (18, '20221225185654617082', 31);
INSERT INTO `order_address` VALUES (20, '2022122916392766642', 36);
INSERT INTO `order_address` VALUES (21, '20221229183205888915', 36);
INSERT INTO `order_address` VALUES (22, '20221229183509123732', 36);
INSERT INTO `order_address` VALUES (23, '20221229183748736707', 36);
INSERT INTO `order_address` VALUES (24, '20221230172938773421', 37);
INSERT INTO `order_address` VALUES (25, '20221230174635490759', 36);

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_id` int NULL DEFAULT NULL,
  `sugar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cup` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `temperature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES (23, '20221212153643118390', 3, '半糖', '中杯', '热', 1);
INSERT INTO `order_goods` VALUES (24, '20221212154815996114', 5, '标准塘', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (25, '20221212154941766808', 4, '半糖', '大杯', '冰', 2);
INSERT INTO `order_goods` VALUES (26, '20221212154941766808', 5, '标准塘', '大杯', '热', 4);
INSERT INTO `order_goods` VALUES (27, '20221212155025613129', 5, '半糖', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (28, '20221213102758591831', 6, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (29, '20221222135759854406', 1, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (30, '20221222135933363741', 3, '标准塘', '中杯', '热', 3);
INSERT INTO `order_goods` VALUES (31, '20221222140321428537', 1, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (32, '2022122315355380457', 5, '标准塘', '大杯', '热', 3);
INSERT INTO `order_goods` VALUES (33, '2022122315355380457', 4, '标准塘', '大杯', '冰', 1);
INSERT INTO `order_goods` VALUES (34, '20221223154316586601', 16, '半糖', '中杯', '冰', 4);
INSERT INTO `order_goods` VALUES (35, '20221223154316586601', 5, '标准塘', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (36, '20221223211600911179', 5, '不加糖', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (37, '20221223211600911179', 5, '标准塘', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (38, '20221223212438622234', 17, '不加糖', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (39, '20221225185654617082', 5, '半糖', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (40, '2022122916392766642', 4, '半糖', '中杯', '冰', 3);
INSERT INTO `order_goods` VALUES (41, '20221229183205888915', 16, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (42, '20221229183509123732', 16, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (43, '20221229183748736707', 5, '不加糖', '中杯', '冰', 1);
INSERT INTO `order_goods` VALUES (44, '20221230172938773421', 16, '不加糖', '中杯', '冰', 3);
INSERT INTO `order_goods` VALUES (45, '20221230172938773421', 8, '不加糖', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (46, '20221230174635490759', 16, '不加糖', '大杯', '热', 1);
INSERT INTO `order_goods` VALUES (47, '20221230174635490759', 7, '半糖', '大杯', '热', 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 'admin');
INSERT INTO `role` VALUES (2, '普通用户', 'member');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '这个人很懒',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'qiuyue2525', '8ce935537e9232a995c1e81c93a49adc', '15177386661', '12312312', 'https://cdn1.zcsuper.cn/lk/c113e6db-44cf-4e29-9d11-36f60a24056b.jpg', '2022-12-06 18:41:05');
INSERT INTO `user` VALUES (6, '测试888', '15def767724ff28a1f504e17c6eca3f9', '18877261111', NULL, NULL, '2022-12-09 15:09:31');
INSERT INTO `user` VALUES (9, '15177386668', '8ce935537e9232a995c1e81c93a49adc', '15177386668', '新的签名~~~', NULL, '2022-12-30 17:22:16');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `address_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (21, 6, 25);
INSERT INTO `user_address` VALUES (22, 6, 26);
INSERT INTO `user_address` VALUES (23, 6, 27);
INSERT INTO `user_address` VALUES (27, 1, 31);
INSERT INTO `user_address` VALUES (28, 1, 32);
INSERT INTO `user_address` VALUES (29, 1, 33);
INSERT INTO `user_address` VALUES (30, 1, 34);
INSERT INTO `user_address` VALUES (31, 1, 36);
INSERT INTO `user_address` VALUES (32, 9, 37);

-- ----------------------------
-- Table structure for user_like
-- ----------------------------
DROP TABLE IF EXISTS `user_like`;
CREATE TABLE `user_like`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `goods_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_like
-- ----------------------------
INSERT INTO `user_like` VALUES (5, 6, 4);
INSERT INTO `user_like` VALUES (8, 6, 2);
INSERT INTO `user_like` VALUES (12, 6, 8);
INSERT INTO `user_like` VALUES (13, 6, 1);
INSERT INTO `user_like` VALUES (14, 1, 1);
INSERT INTO `user_like` VALUES (18, 1, 17);
INSERT INTO `user_like` VALUES (52, 1, 5);
INSERT INTO `user_like` VALUES (57, 9, 16);

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_order
-- ----------------------------
INSERT INTO `user_order` VALUES (14, 6, '20221212153643118390', 0, '2022-12-12 15:36:44');
INSERT INTO `user_order` VALUES (15, 6, '20221212154815996114', 0, '2022-12-12 15:48:16');
INSERT INTO `user_order` VALUES (16, 6, '20221212154941766808', 0, '2022-12-12 15:49:42');
INSERT INTO `user_order` VALUES (17, 6, '20221212155025613129', 0, '2022-12-12 15:50:25');
INSERT INTO `user_order` VALUES (18, 6, '20221213102758591831', 0, '2022-12-13 10:27:59');
INSERT INTO `user_order` VALUES (20, 6, '20221222135933363741', 1, '2022-12-22 13:59:33');
INSERT INTO `user_order` VALUES (22, 1, '2022122315355380457', 1, '2022-12-23 15:35:54');
INSERT INTO `user_order` VALUES (23, 1, '20221223154316586601', 1, '2022-12-23 15:43:16');
INSERT INTO `user_order` VALUES (24, 1, '20221223211600911179', 1, '2022-12-23 21:16:00');
INSERT INTO `user_order` VALUES (25, 1, '20221223212438622234', 1, '2022-12-23 21:24:39');
INSERT INTO `user_order` VALUES (26, 1, '20221225185654617082', 1, '2022-12-25 18:56:55');
INSERT INTO `user_order` VALUES (28, 1, '2022122916392766642', 1, '2022-12-29 16:39:28');
INSERT INTO `user_order` VALUES (29, 1, '20221229183205888915', 1, '2022-12-29 18:32:06');
INSERT INTO `user_order` VALUES (30, 1, '20221229183509123732', 1, '2022-12-29 18:35:09');
INSERT INTO `user_order` VALUES (31, 1, '20221229183748736707', 1, '2022-12-29 18:37:49');
INSERT INTO `user_order` VALUES (32, 9, '20221230172938773421', 1, '2022-12-30 17:29:39');
INSERT INTO `user_order` VALUES (33, 1, '20221230174635490759', 0, '2022-12-30 17:46:35');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 5, 2);
INSERT INTO `user_role` VALUES (4, 6, 2);
INSERT INTO `user_role` VALUES (5, 7, 2);
INSERT INTO `user_role` VALUES (6, 8, 2);
INSERT INTO `user_role` VALUES (7, 9, 2);

SET FOREIGN_KEY_CHECKS = 1;

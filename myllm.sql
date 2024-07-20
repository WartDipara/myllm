/*
 Navicat Premium Data Transfer

 Source Server         : ela
 Source Server Type    : MySQL
 Source Server Version : 80038 (8.0.38)
 Source Host           : localhost:3306
 Source Schema         : myllm

 Target Server Type    : MySQL
 Target Server Version : 80038 (8.0.38)
 File Encoding         : 65001

 Date: 20/07/2024 17:22:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records`  (
  `rec_id` int NOT NULL AUTO_INCREMENT,
  `rec_user_id` int NULL DEFAULT NULL,
  `rec_token` int NULL DEFAULT NULL,
  `rec_time` datetime NULL DEFAULT NULL,
  `rec_pay` int NULL DEFAULT NULL,
  `rec_ask` varchar(255) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL,
  `rec_response` varchar(255) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rec_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of records
-- ----------------------------
INSERT INTO `records` VALUES (1, 11, 38, '2024-07-18 14:17:34', 0, 'null', 'null');
INSERT INTO `records` VALUES (2, 11, 38, '2024-07-18 14:18:31', 0, 'null', 'null');
INSERT INTO `records` VALUES (3, 11, 38, '2024-07-18 14:40:49', 0, 'null', 'null');
INSERT INTO `records` VALUES (4, 11, 13, '2024-07-18 14:42:34', 0, 'null', 'null');
INSERT INTO `records` VALUES (5, 11, 18, '2024-07-18 15:28:29', 0, 'null', 'null');
INSERT INTO `records` VALUES (6, 11, 14, '2024-07-18 15:32:37', 0, '1 1=？', '1');
INSERT INTO `records` VALUES (7, 11, 62, '2024-07-18 16:37:15', 0, '123', 'The number 123 is an integer and a three-digit number. It comes after 122 and before 124 in the numerical sequence. It can be written as 1 hundred, 2 tens, and 3 ones.');
INSERT INTO `records` VALUES (8, 11, 48, '2024-07-18 16:53:36', 0, 'dd', 'I\'m sorry, but your message is too short for me to understand or provide a relevant response. Please feel free to ask a specific question or provide more context so I can assist you better.');
INSERT INTO `records` VALUES (9, 11, 30, '2024-07-18 16:57:43', 0, '测试', '你好，这是一个测试回复。如果你有任何问题或需要帮助，请随时告诉我，我会尽力提供支持。');
INSERT INTO `records` VALUES (10, 11, 30, '2024-07-18 16:59:19', 0, '测试', '你好，这是一个测试回复。如果你有任何问题或需要帮助，请随时告诉我，我会尽力提供支持。');
INSERT INTO `records` VALUES (11, 11, 30, '2024-07-18 17:01:27', 0, '测试\n', '你好，这是一个测试回复。如果你有任何问题或需要帮助，请随时告诉我，我会尽力提供支持。');
INSERT INTO `records` VALUES (12, 11, 62, '2024-07-18 17:02:55', 0, '123', 'The number 123 is an integer and a three-digit number. It comes after 122 and before 124 in the numerical sequence. It can be written as 1 hundred, 2 tens, and 3 ones.');
INSERT INTO `records` VALUES (13, 11, 30, '2024-07-18 17:14:23', 0, '测试', '你好，这是一个测试回复。如果你有任何问题或需要帮助，请随时告诉我，我会尽力提供支持。');
INSERT INTO `records` VALUES (14, 11, 103, '2024-07-18 17:15:00', 1, '测试凭证', '您好，您提到的\"测试凭证\"可能是指在某些特定场景下，用于验证身份、权限或测试功能的凭证。这些凭证可能包括登录凭证（如用户名和密码）、API密钥、测试代码、模拟令牌等。如果您需要帮助测试或管理这些凭证，请提供更详细的信息，我会尽力协助您。但请注意，对于任何敏感信息，如实际的账号密码，请务必保密，不要在公开场合分享。');
INSERT INTO `records` VALUES (15, 11, 30, '2024-07-18 17:15:16', 0, '测试', '你好，这是一个测试回复。如果你有任何问题或需要帮助，请随时告诉我，我会尽力提供支持。');
INSERT INTO `records` VALUES (16, 11, 30, '2024-07-18 17:15:28', 0, '测试', '你好，这是一个测试回复。如果你有任何问题或需要帮助，请随时告诉我，我会尽力提供支持。');
INSERT INTO `records` VALUES (17, 11, 38, '2024-07-18 20:36:09', 0, 'test', 'I am an AI language model, and I am here to help you with any questions or tasks you have. How can I assist you today?');
INSERT INTO `records` VALUES (18, 11, 38, '2024-07-18 20:38:02', 0, 'test', 'I am an AI language model, and I am here to help you with any questions or tasks you have. How can I assist you today?');
INSERT INTO `records` VALUES (19, 11, 38, '2024-07-18 20:43:46', 0, 'test', 'I am an AI language model, and I am here to help you with any questions or tasks you have. How can I assist you today?');
INSERT INTO `records` VALUES (20, 11, 50, '2024-07-18 21:08:53', 0, '来点色图', '');
INSERT INTO `records` VALUES (21, 11, 50, '2024-07-18 21:09:00', 0, '测试', '');
INSERT INTO `records` VALUES (22, 11, 50, '2024-07-18 21:09:50', 0, 'test', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (23, 11, 50, '2024-07-18 21:10:16', 0, '安全发送测试', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (24, 11, 56, '2024-07-19 10:27:16', 0, 'eee', 'I\'m sorry, but it seems like you have entered an incomplete or unclear request. If you have any questions, need assistance, or would like to discuss a topic, please provide more information, and I\'ll be happy to help.');
INSERT INTO `records` VALUES (25, 11, 50, '2024-07-19 11:12:15', 0, 'w', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (26, 11, 50, '2024-07-19 11:13:06', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (27, 11, 50, '2024-07-19 11:13:06', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (28, 11, 50, '2024-07-19 11:13:06', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (29, 11, 50, '2024-07-19 11:13:06', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (30, 11, 50, '2024-07-19 11:13:06', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (31, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (32, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (33, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (34, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (35, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (36, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (37, 11, 50, '2024-07-19 11:13:07', 0, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (38, 11, 50, '2024-07-19 11:14:00', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (39, 11, 50, '2024-07-19 11:14:00', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (40, 11, 50, '2024-07-19 11:14:01', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (41, 11, 50, '2024-07-19 11:14:01', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (42, 11, 50, '2024-07-19 11:14:01', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (43, 11, 50, '2024-07-19 11:14:01', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (44, 11, 50, '2024-07-19 11:14:01', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (45, 11, 50, '2024-07-19 11:14:01', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (46, 11, 50, '2024-07-19 11:14:02', 5, '', 'https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067');
INSERT INTO `records` VALUES (47, 11, 10, '2024-07-19 11:39:49', 1, 'a', 'b');
INSERT INTO `records` VALUES (48, 11, 10, '2024-07-19 11:46:00', 1, 'a', 'b');
INSERT INTO `records` VALUES (49, 11, 10, '2024-07-19 11:46:21', 1, 'a', 'b');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_nickname` varchar(50) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL,
  `user_loginname` varchar(50) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL,
  `user_loginpwd` varchar(100) CHARACTER SET utf32 COLLATE utf32_general_ci NULL DEFAULT NULL,
  `user_score` int NULL DEFAULT NULL,
  `user_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `UQ_loginname`(`user_loginname` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'test', 'test', 'test', NULL, NULL);
INSERT INTO `users` VALUES (2, 'test1', 'test1', 'test1', NULL, NULL);
INSERT INTO `users` VALUES (3, 'test2', 'test2', 'test2', NULL, NULL);
INSERT INTO `users` VALUES (4, 'test3', 'test3', 'test3', NULL, NULL);
INSERT INTO `users` VALUES (5, 'e1', 'e1', 'e1', NULL, NULL);
INSERT INTO `users` VALUES (6, 'r1', 'r1', 'r1', NULL, NULL);
INSERT INTO `users` VALUES (7, 't1', 't1', 't1', NULL, NULL);
INSERT INTO `users` VALUES (8, 'y1', 'y1', 'y1', NULL, NULL);
INSERT INTO `users` VALUES (9, 'test8', 'test8', 'test8', 50, NULL);
INSERT INTO `users` VALUES (10, 'nikoniko', 'nikoniko', 'niko123', 50, NULL);
INSERT INTO `users` VALUES (11, 'kfk', 'kfk', 'kfk', 1, NULL);
INSERT INTO `users` VALUES (12, 'popc', 'popc', 'popc', 50, NULL);
INSERT INTO `users` VALUES (13, 'abi', 'abi', 'abi', 50, NULL);
INSERT INTO `users` VALUES (14, 'pal', 'pal', 'pal', 50, NULL);
INSERT INTO `users` VALUES (15, 'iv', 'iv', 'iv', 50, 'hanbird.jpg');
INSERT INTO `users` VALUES (16, 'e', 'e', 'e', 50, '微信图片_20240208141939.png');
INSERT INTO `users` VALUES (17, 'koko', 'koko', 'koko', 50, 'koko.jpg');
INSERT INTO `users` VALUES (28, 'tiko', 'tiko', 'tiko', 50, 'tiko.jpg');
INSERT INTO `users` VALUES (29, 'i1', 'i1', 'i1', 50, 'i1.png');
INSERT INTO `users` VALUES (30, 'i2', 'i2', 'i2', 50, 'i2.jpg');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : mysqldump

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 26/04/2020 22:46:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mysql_dump
-- ----------------------------
DROP TABLE IF EXISTS `mysql_dump`;
CREATE TABLE `mysql_dump`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备份路径',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备份文件名',
  `uuid_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '随机文件名',
  `database_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名',
  `default_character_set` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符编码',
  `is_compact` tinyint(4) NULL DEFAULT 0 COMMENT '压缩模式',
  `is_comments` tinyint(4) NULL DEFAULT 0 COMMENT '注释信息',
  `is_complete_insert` tinyint(4) NULL DEFAULT 0 COMMENT '使用完整的insert语句',
  `is_lock_tables` tinyint(4) NOT NULL DEFAULT 0 COMMENT '备份前，锁定所有数据库表',
  `is_no_create_db` tinyint(4) NULL DEFAULT 0 COMMENT '禁止生成创建数据库语句',
  `is_force` tinyint(4) NULL DEFAULT 0 COMMENT '当出现错误时仍然继续备份操作',
  `is_add_drop_database` tinyint(4) NULL DEFAULT 0 COMMENT '每个数据库创建之前添加drop数据库语句',
  `is_add_drop_table` tinyint(4) NULL DEFAULT 0 COMMENT '每个数据库创建之前添加drop数据库语句',
  `command` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终执行的命令',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1正常 2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mysql_dump
-- ----------------------------
INSERT INTO `mysql_dump` VALUES (1, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/08aca6c6_0bbf_471f_afdf_0d787936674f.sql', 'sunday_base', '08aca6c6_0bbf_471f_afdf_0d787936674f', 'sunday_base', 'utf8', 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, '2020-04-26 15:34:00', 1);
INSERT INTO `mysql_dump` VALUES (2, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/239cd67d_4f02_468a_9f4d_90e3b3f6f3df.sql', 'sunday_test', '239cd67d_4f02_468a_9f4d_90e3b3f6f3df', 'sunday_test', 'utf8', 1, 0, 0, 0, 0, 1, 0, 0, NULL, NULL, '2020-04-26 17:01:56', 1);
INSERT INTO `mysql_dump` VALUES (3, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/396aa95b_f507_4f78_a9c4_151c98a299e7.sql', 'ssm', '396aa95b_f507_4f78_a9c4_151c98a299e7', 'ssm', 'utf8', 1, 0, 0, 0, 0, 1, 0, 0, NULL, NULL, '2020-04-26 17:03:30', 1);
INSERT INTO `mysql_dump` VALUES (4, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/b506c3fc_0a03_49ac_ba5d_1e2380fdb85a.sql', 'test', 'b506c3fc_0a03_49ac_ba5d_1e2380fdb85a', 'test', 'utf8', 1, 0, 0, 0, 0, 1, 0, 0, NULL, NULL, '2020-04-26 17:04:27', 1);
INSERT INTO `mysql_dump` VALUES (5, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/77c6c2b1_0132_4935_92bb_2dfd2eef8663.sql', 'test2', '77c6c2b1_0132_4935_92bb_2dfd2eef8663', 'test', 'utf8', 1, 0, 0, 0, 1, 1, 0, 0, NULL, NULL, '2020-04-26 17:22:09', 1);
INSERT INTO `mysql_dump` VALUES (6, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/8e82cb5b_5648_4022_ae5f_2b774325b5b3.sql', '测试Drop', '8e82cb5b_5648_4022_ae5f_2b774325b5b3', 'sunday_test', 'utf8', 1, 0, 0, 0, 0, 1, 1, 1, NULL, NULL, '2020-04-26 17:33:32', 1);
INSERT INTO `mysql_dump` VALUES (7, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/4028201c_b108_4cdc_9967_48e94e0cadc1.sql', '测试备份文件', '4028201c_b108_4cdc_9967_48e94e0cadc1', 'test', 'utf8', 1, 0, 0, 0, 0, 1, 1, 1, NULL, NULL, '2020-04-26 17:42:38', 1);
INSERT INTO `mysql_dump` VALUES (8, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/b185cb56_2e47_410e_b0d6_436bae61d953.sql', '测试备份文件', 'b185cb56_2e47_410e_b0d6_436bae61d953', 'test', 'utf8', 1, 0, 0, 0, 0, 1, 1, 1, NULL, NULL, '2020-04-26 20:22:17', 1);
INSERT INTO `mysql_dump` VALUES (9, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/9409d224_fbc0_4943_80af_033e0d13ddee.sql', '无Drop库', '9409d224_fbc0_4943_80af_033e0d13ddee', 'test', 'utf8', 1, 0, 0, 0, 0, 1, 0, 1, NULL, NULL, '2020-04-26 21:04:31', 1);
INSERT INTO `mysql_dump` VALUES (10, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/b8fed6d4_9ab9_4382_b6f6_179b27ee5203.sql', '有Drop库', 'b8fed6d4_9ab9_4382_b6f6_179b27ee5203', 'test', 'utf8', 1, 0, 0, 0, 0, 1, 1, 1, NULL, NULL, '2020-04-26 21:05:52', 1);
INSERT INTO `mysql_dump` VALUES (11, '127.0.0.1', 3306, 'root', '123456', '/default/2020/04/26/d25def5d_00fd_4138_aa78_bfeba0804ece.sql', '有建库语句', 'd25def5d_00fd_4138_aa78_bfeba0804ece', 'test', 'utf8', 1, 0, 0, 0, 1, 1, 1, 1, NULL, NULL, '2020-04-26 21:08:24', 1);

-- ----------------------------
-- Table structure for mysql_recover
-- ----------------------------
DROP TABLE IF EXISTS `mysql_recover`;
CREATE TABLE `mysql_recover`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dump_id` int(11) NOT NULL COMMENT '备份文件id',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `database_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名',
  `is_create_db` tinyint(4) NULL DEFAULT NULL COMMENT '是否创建新库',
  `command` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终执行的命令',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1正常 2删除',
  PRIMARY KEY (`id`, `dump_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mysql_recover
-- ----------------------------
INSERT INTO `mysql_recover` VALUES (1, 0, '127.0.0.1', 3306, 'root', '123456', 'test', 0, 'cmd /c  mysql -h127.0.0.1 -P3306 -uroot -p123456 test < D:/Workspace/IDEAWorkspace/mysqldump/mysqldump-static/default/2020/04/26/d25def5d_00fd_4138_aa78_bfeba0804ece.sql', '2020-04-26 22:13:42', 1);
INSERT INTO `mysql_recover` VALUES (2, 0, '127.0.0.1', 3306, 'root', '123456', 'test', 0, 'cmd /c  mysql -h127.0.0.1 -P3306 -uroot -p123456 test < D:/Workspace/IDEAWorkspace/mysqldump/mysqldump-static/default/2020/04/26/b8fed6d4_9ab9_4382_b6f6_179b27ee5203.sql', '2020-04-26 22:16:52', 1);

SET FOREIGN_KEY_CHECKS = 1;

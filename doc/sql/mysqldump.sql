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

 Date: 28/04/2020 22:46:28
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
  `is_specify_table` tinyint(4) NULL DEFAULT NULL COMMENT '是否指定备份表',
  `specify_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指定标明，多个使用\" \"隔开',
  `command` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终执行的命令',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1正常 2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

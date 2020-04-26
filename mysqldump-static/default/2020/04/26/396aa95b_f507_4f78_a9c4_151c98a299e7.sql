
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `tb_customer` VALUES (1,'张三丰','18386545500','3210054449@qq.com','贵州省贵阳市观山湖区云潭南路3号'),(2,'王歌','13498066695','1234566@cn.gg','北京市海淀区中关村北大街清华大学'),(3,'刘子昂','16509899000','42394023@dd.cn','贵州省普安县窝沿乡关田村红花组'),(5,'韩信','13498066695','42394023@dd.cn','贵阳市南明区富源中路龙家寨'),(6,'上官婉儿 ','18594945860','42394023@dd.cn','贵州省遵义市务川县涪洋镇当阳村鱼田溪组'),(7,'李白','13498066695','42394023@dd.cn','贵州省安龙县栖凤街道办事处西河村段石街组116号'),(8,'妲己','18594945860','1234566@cn.gg','贵州省纳雍县百兴镇新街村新街组'),(9,'蔡徐坤','18594945860','560000@11.com','贵州省普安县青山镇范家寨村黑树林组'),(10,'迪丽热巴','18386474459','1234566@cn.gg','贵州省罗甸县逢亭镇拱里村二组15号'),(11,'刘亦菲','13498066695','1234566@cn.gg','贵州省凯里市西门街梁子巷');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `tb_user` VALUES (1,'tellsea','123456');


/*!40000 DROP DATABASE IF EXISTS `sunday_test`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sunday_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sunday_test`;
DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `student` VALUES (1,'tellsea'),(2,'susan'),(3,'tony');

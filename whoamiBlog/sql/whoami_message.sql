CREATE DATABASE  IF NOT EXISTS `whoami` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `whoami`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: whoami
-- ------------------------------------------------------
-- Server version	5.2.0-falcon-alpha-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `context` text NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `data_time` varchar(45) NOT NULL,
  `see` int(11) DEFAULT '1',
  PRIMARY KEY (`m_id`),
  KEY `u_id_idx` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (4,'我的第一篇日记','做这个东西，从最开始的不懂，真的是太不容易了。哎。。。。。。。。。。。。竣工',NULL,'2016/01/03 15:37:51',1),(5,'呵呵','其实这是想用来写学术性文章的，但是今天心情确实是不怎么舒服。哎。。。就是想不通。。。。烦烦烦',NULL,'2016/01/07 13:30:04',0),(6,'生活','&nbsp; 有时候真是无趣的在活着。人活着，是为了什么，还不是为了有一个好的生活。人的生命里到底应该有些什么才算完美啊。我也有我的理想。我不想我的理想成为炮灰，所以我得努力，更加的努力。有时候我真的不知道 我到底该做些什么。只想说呵呵哒。预习吧，过两天考试了。',NULL,'2016/01/08 00:09:52',1);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-09 22:04:49

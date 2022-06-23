-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: status
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `class`
--
use fan;
DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `cno` char(10) NOT NULL,
  `snumber` int DEFAULT NULL,
  `dno` char(10) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `C1` (`dno`),
  CONSTRAINT `C1` FOREIGN KEY (`dno`) REFERENCES `department` (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('002001',0,'10000'),('002002',0,'10000'),('012001',0,'10001'),('012002',0,'10001'),('022001',0,'10002'),('032001',0,'10003'),('042001',0,'10004'),('042002',0,'10004'),('052001',0,'10005'),('062001',0,'10006'),('062002',0,'10006');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `kno` char(10) NOT NULL,
  `kname` char(20) DEFAULT NULL,
  PRIMARY KEY (`kno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('00001','高等数学'),('000010','数学分析'),('000011','几何数学'),('000012','诗歌鉴赏'),('00002','C语言'),('00003','离散数学'),('00004','数据库'),('00005','大学英语'),('00006','大学体育'),('00007','形势与政策'),('00008','数据结构'),('00009','概率统计');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dno` char(10) NOT NULL,
  `dname` char(20) DEFAULT NULL,
  PRIMARY KEY (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('10000','计算机学院'),('10001','数统学院'),('10002','经管学院'),('10003','文学院'),('10004','外国语学院'),('10005','心理学学院'),('10006','法学院');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `mno` char(10) NOT NULL,
  `mname` char(20) DEFAULT NULL,
  `dno` char(10) DEFAULT NULL,
  PRIMARY KEY (`mno`),
  KEY `M1` (`dno`),
  CONSTRAINT `M1` FOREIGN KEY (`dno`) REFERENCES `department` (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES ('100001','计算机科学','10000'),('100002','信息安全','10000'),('100003','软件工程','10000'),('100004','物联网','10000'),('100011','统计学','10001'),('100012','应用数学','10001'),('100013','信息科学','10001'),('100021','经济学','10002'),('100022','金融学','10002'),('100031','中国语言文学','10003'),('100032','外国语言文学','10003'),('100041','英语','10004'),('100042','法语','10004'),('100043','日语','10004'),('100044','西班牙语','10004'),('100051','心理学','10005'),('100052','应用心理学','10005'),('100061','法学','10006'),('100062','社会学','10006');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `sno` char(10) NOT NULL,
  `kno` char(10) NOT NULL,
  `score` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`sno`,`kno`),
  KEY `SS2` (`kno`),
  CONSTRAINT `SS1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`),
  CONSTRAINT `SS2` FOREIGN KEY (`kno`) REFERENCES `course` (`kno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES ('200001','00001',90.00),('200001','00002',88.50),('200001','00004',94.00),('200002','00001',85.70),('200002','00003',90.00),('200002','00005',83.50),('200003','00001',90.00),('200003','00002',90.00),('200003','00004',84.00),('200004','00001',90.00),('200004','00007',86.00),('200004','00008',83.00);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `srandp`
--

DROP TABLE IF EXISTS `srandp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `srandp` (
  `sno` char(10) NOT NULL,
  `time` date NOT NULL,
  `rpname` char(20) NOT NULL,
  PRIMARY KEY (`sno`,`time`,`rpname`),
  CONSTRAINT `R1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `srandp`
--

LOCK TABLES `srandp` WRITE;
/*!40000 ALTER TABLE `srandp` DISABLE KEYS */;
INSERT INTO `srandp` VALUES ('200001','2020-09-11','学习积极分子'),('200001','2020-10-11','博雅银桂奖'),('200002','2020-10-01','国家奖学金'),('200002','2021-05-11','优秀团员'),('200003','2020-10-01','国家助学金'),('200004','2020-10-11','博雅金桂奖'),('200005','2021-03-11','留校察看'),('200006','2021-06-17','警告处分'),('200007','2021-09-20','学习积极分子'),('200008','2021-09-21','励志奖学金'),('200009','2021-09-20','学习积极分子'),('200010','2020-05-11','记过处分'),('200011','2021-10-11','博雅丹桂奖'),('200015','2021-09-21','学习积极分子'),('200018','2021-09-12','博雅树人奖');
/*!40000 ALTER TABLE `srandp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `sno` char(10) NOT NULL,
  `sname` char(10) DEFAULT NULL,
  `ssex` char(4) NOT NULL,
  `sage` int DEFAULT NULL,
  `birth` char(15) DEFAULT NULL,
  `na` char(10) DEFAULT NULL,
  `address` char(20) DEFAULT NULL,
  `cno` char(10) DEFAULT NULL,
  `mno` char(10) DEFAULT NULL,
  PRIMARY KEY (`sno`),
  KEY `S1` (`cno`),
  KEY `S2` (`mno`),
  CONSTRAINT `S1` FOREIGN KEY (`cno`) REFERENCES `class` (`cno`),
  CONSTRAINT `S2` FOREIGN KEY (`mno`) REFERENCES `major` (`mno`),
  CONSTRAINT `student_chk_1` CHECK (((`ssex` = _utf8mb4'男') or (`ssex` = _utf8mb4'女')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('200001','张明','男',19,'2003-03-24','汉','云南省','002001','100001'),('200002','李月','女',19,'2003-05-30','汉','江苏省','002001','100001'),('200003','田娜娜','女',20,'2002-08-20','汉','广西省','002002','100002'),('200004','张丽','女',17,'2005-08-13','汉','广东省','002001','100003'),('200005','李小乐','男',19,'2003-06-30','回族','宁夏省','062001','100061'),('200006','刘轩','男',20,'2002-11-13','汉','云南省','002002','100003'),('200007','于欢','男',18,'2004-05-05','汉','甘肃省','002001','100004'),('200008','黄澄澄','女',19,'2003-12-03','汉','四川省','002002','100002'),('200009','李飞','男',20,'2002-03-24','汉','青海省','002001','100001'),('200010','赵琦','女',19,'2003-08-24','汉','四川省','052001','100052'),('200011','张琪','女',19,'2003-06-24','汉','甘肃省','012001','100012'),('200012','张玉','女',19,'2003-03-04','汉','东北省','032001','100031'),('200013','李倩','女',19,'2003-12-24','汉','云南省','012001','100011'),('200014','万滕','男',20,'2002-07-13','汉','江西省','002001','100001'),('200015','赵芳','女',19,'2003-04-23','汉','江西省','002002','100003'),('200016','张元','男',19,'2003-11-25','汉','云南省','002001','100001'),('200017','于家','女',18,'2004-03-24','汉','陕西省','022001','100022'),('200018','李晓','女',19,'2003-02-13','汉','四川省','002001','100001'),('200019','赵敏','女',19,'2003-05-05','汉','广东省','032001','100031'),('200020','李华','男',19,'2003-10-24','汉','广西省','022001','100021');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-02 21:31:06

CREATE TRIGGER IN_trigger
    AFTER INSERT ON Student
    FOR EACH ROW
BEGIN
    UPDATE Class SET snumber =snumber+ 1 where cno=NEW.cno;
END;

CREATE TRIGGER DE_trigger
    AFTER DELETE ON Student
    FOR EACH ROW
BEGIN
    UPDATE Class SET snumber =snumber- 1
    where cno=OLD.cno;
END;

CREATE TRIGGER Up_trigger
    AFTER UPDATE ON Student
    FOR EACH ROW
BEGIN
    UPDATE Class SET snumber =snumber-1 where cno=OLD.cno;
    UPDATE Class SET snumber =snumber+ 1 where cno=NEW.cno;
END;

delimiter $$
create procedure Query(in ss char(10))
    begin select Student.sno,Student.sname,Course.kname,score.score from Student,Score,Course
                                                                    where Student.sno=Score.sno and Score.kno=Course.kno and ss=Score.sno;
end$$;

create view S_mes(sno,sname,cno,mname,dname)
AS
select Student.sno,Student.sname,Student.cno,Major.mname,Department.dname
from Student,Class,Major,Department
where Student.cno=Class.cno and Student.mno=Major.mno and Major.dno=Department.dno with check option;
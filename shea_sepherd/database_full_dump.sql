CREATE DATABASE  IF NOT EXISTS `ghostnets` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ghostnets`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: ghostnets
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `geisternetz`
--

DROP TABLE IF EXISTS `geisternetz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `geisternetz` (
  `id` bigint NOT NULL,
  `geschaetzteGroesse` int NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `status` enum('GEMELDET','BERGUNG_BEVORSTEHEND','GEBORGEN','VERSCHOLLEN') DEFAULT NULL,
  `berger_id` bigint DEFAULT NULL,
  `melder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhnnfti76uqn7ir4f6e2sals8y` (`berger_id`),
  KEY `FKsldl5d7stom957dp95rcf7y4v` (`melder_id`),
  CONSTRAINT `FKhnnfti76uqn7ir4f6e2sals8y` FOREIGN KEY (`berger_id`) REFERENCES `person` (`id`),
  CONSTRAINT `FKsldl5d7stom957dp95rcf7y4v` FOREIGN KEY (`melder_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geisternetz`
--

LOCK TABLES `geisternetz` WRITE;
/*!40000 ALTER TABLE `geisternetz` DISABLE KEYS */;
INSERT INTO `geisternetz` VALUES (1,100,34.123445,54.233445,'GEMELDET',NULL,4),(2,250,89.877665,-30.877656,'GEMELDET',NULL,5),(52,122,23.346534,59.433185,'GEMELDET',NULL,52),(53,33,76.432153,-87.327516,'GEMELDET',NULL,53),(152,6,-78.294736,19.482784,'BERGUNG_BEVORSTEHEND',2,152),(153,56,-88.472647,176.374625,'BERGUNG_BEVORSTEHEND',2,153),(154,3,64.837163,-177.483726,'BERGUNG_BEVORSTEHEND',2,154);
/*!40000 ALTER TABLE `geisternetz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geisternetz_seq`
--

DROP TABLE IF EXISTS `geisternetz_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `geisternetz_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geisternetz_seq`
--

LOCK TABLES `geisternetz_seq` WRITE;
/*!40000 ALTER TABLE `geisternetz_seq` DISABLE KEYS */;
INSERT INTO `geisternetz_seq` VALUES (251);
/*!40000 ALTER TABLE `geisternetz_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` bigint NOT NULL,
  `nutzername` varchar(255) DEFAULT NULL,
  `telefonnummer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Donald','001202666'),(2,'TestPerson','1234'),(4,'Barrack',''),(5,'Bill',''),(52,'Angela','01726354'),(53,'Olaf',''),(152,'M.S.Öder','00497263524'),(153,'Armin','017987625364'),(154,'Anna-Lena','');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_seq`
--

DROP TABLE IF EXISTS `person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_seq`
--

LOCK TABLES `person_seq` WRITE;
/*!40000 ALTER TABLE `person_seq` DISABLE KEYS */;
INSERT INTO `person_seq` VALUES (251);
/*!40000 ALTER TABLE `person_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-05 12:21:29

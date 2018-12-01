-- MySQL dump 10.16  Distrib 10.1.28-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: wu
-- ------------------------------------------------------
-- Server version	10.1.28-MariaDB

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
-- Table structure for table `dziekanat`
--

DROP TABLE IF EXISTS `dziekanat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dziekanat` (
  `id_pracownika` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `haslo` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL,
  PRIMARY KEY (`id_pracownika`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dziekanat`
--

LOCK TABLES `dziekanat` WRITE;
/*!40000 ALTER TABLE `dziekanat` DISABLE KEYS */;
INSERT INTO `dziekanat` VALUES (1,'Justyna','Kara','abc',89010256743),(2,'Janina','Dyba','abc',78015566743),(3,'Michalina','Kontakt','abc',77121256743),(4,'Katarzyna','Sztuka','abc',89060279811),(5,'Urszula','Wanio','abc',66040602517);
/*!40000 ALTER TABLE `dziekanat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oceny`
--

DROP TABLE IF EXISTS `oceny`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oceny` (
  `id_oceny` int(11) NOT NULL,
  `ocena` int(1) NOT NULL,
  `id_wykladowcy` int(11) NOT NULL,
  `nr_indeksu` int(11) NOT NULL,
  `nazwa` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id_oceny`),
  KEY `nr_indeksu` (`nr_indeksu`) USING BTREE,
  KEY `nazwa` (`nazwa`),
  KEY `id_wykladowcy` (`id_wykladowcy`),
  CONSTRAINT `oceny_ibfk_1` FOREIGN KEY (`id_wykladowcy`) REFERENCES `wykladowca` (`id_wykladowcy`),
  CONSTRAINT `oceny_ibfk_3` FOREIGN KEY (`nr_indeksu`) REFERENCES `student` (`nr_indeksu`),
  CONSTRAINT `oceny_ibfk_4` FOREIGN KEY (`nazwa`) REFERENCES `przedmioty` (`nazwa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oceny`
--

LOCK TABLES `oceny` WRITE;
/*!40000 ALTER TABLE `oceny` DISABLE KEYS */;
INSERT INTO `oceny` VALUES (1,2,3,964611,'Matematyka'),(2,5,4,964634,'Sieci'),(3,4,4,964567,'Informatyka'),(4,2,1,964567,'Matematyka'),(5,2,3,964611,'Ekonomia');
/*!40000 ALTER TABLE `oceny` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `przedmioty`
--

DROP TABLE IF EXISTS `przedmioty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `przedmioty` (
  `id_przedmiotu` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `id_wykladowcy` int(11) NOT NULL,
  `nr_indeksu` int(11) NOT NULL,
  PRIMARY KEY (`id_przedmiotu`),
  KEY `nr_indeksu` (`nr_indeksu`),
  KEY `nazwa` (`nazwa`),
  KEY `id_wykladowcy` (`id_wykladowcy`),
  CONSTRAINT `przedmioty_ibfk_1` FOREIGN KEY (`id_wykladowcy`) REFERENCES `wykladowca` (`id_wykladowcy`),
  CONSTRAINT `przedmioty_ibfk_2` FOREIGN KEY (`nr_indeksu`) REFERENCES `student` (`nr_indeksu`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `przedmioty`
--

LOCK TABLES `przedmioty` WRITE;
/*!40000 ALTER TABLE `przedmioty` DISABLE KEYS */;
INSERT INTO `przedmioty` VALUES (1,'Matematyka',1,964634),(2,'Informatyka',3,964567),(3,'Ekonomia',4,964634),(4,'Ekonometria',5,964611),(5,'Sieci',3,964567);
/*!40000 ALTER TABLE `przedmioty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id_studenta` int(11) NOT NULL AUTO_INCREMENT,
  `haslo` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL,
  `kierunek_s` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `ulica` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nr_domu` varchar(5) COLLATE utf8_polish_ci NOT NULL,
  `kod_p` char(6) COLLATE utf8_polish_ci NOT NULL,
  `miejscowosc` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nr_tel` int(9) NOT NULL,
  `nr_indeksu` int(11) NOT NULL,
  PRIMARY KEY (`id_studenta`),
  KEY `nr_indeksu` (`nr_indeksu`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'abc','Jan','Nowak',96060502512,'Informatyka','Rolna','22','37-232','Rzeszow',697243321,964646),(2,'abc','Janusz','Akida',96060552512,'Matematyka','Slowackiego','1','37-212','Lublin',666243321,966746),(3,'abc','Kamil','Maak',96060502555,'Ekonometria','Poznanska','14','35-500','Poznan',687543123,964611),(4,'abc','Mateusz','Mleczko',96060662555,'Ekonometria','Lipowa','12','22-522','Warszawa',687543857,964567),(5,'abc','Adam','Person',96062202555,'Informatyka','Wspolna','45','35-600','Krakow',654643123,964634);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wniosek`
--

DROP TABLE IF EXISTS `wniosek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wniosek` (
  `id_wniosku` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `nr_indeksu` int(11) NOT NULL,
  `id_pracownika` int(11) NOT NULL,
  PRIMARY KEY (`id_wniosku`),
  KEY `nr_indeksu` (`nr_indeksu`),
  KEY `id_pracownika` (`id_pracownika`),
  CONSTRAINT `wniosek_ibfk_1` FOREIGN KEY (`id_pracownika`) REFERENCES `dziekanat` (`id_pracownika`),
  CONSTRAINT `wniosek_ibfk_2` FOREIGN KEY (`nr_indeksu`) REFERENCES `student` (`nr_indeksu`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wniosek`
--

LOCK TABLES `wniosek` WRITE;
/*!40000 ALTER TABLE `wniosek` DISABLE KEYS */;
INSERT INTO `wniosek` VALUES (1,'2018-11-08',966746,1),(2,'2018-11-15',964634,3),(3,'2018-11-18',966746,1),(4,'2018-11-02',964567,2),(5,'2018-11-24',964567,5);
/*!40000 ALTER TABLE `wniosek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wykladowca`
--

DROP TABLE IF EXISTS `wykladowca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wykladowca` (
  `id_wykladowcy` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `haslo` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL,
  PRIMARY KEY (`id_wykladowcy`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wykladowca`
--

LOCK TABLES `wykladowca` WRITE;
/*!40000 ALTER TABLE `wykladowca` DISABLE KEYS */;
INSERT INTO `wykladowca` VALUES (1,'Antoni','abc','Bugaj',70060502512),(2,'Jan','abc','Ciskoj',65060222598),(3,'Jacek','abc','Dynia',70064578512),(4,'Mariusz','abc','Jasny',77060467512),(5,'Tomasz','abc','Raczek',7006045321);
/*!40000 ALTER TABLE `wykladowca` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-01 15:06:27

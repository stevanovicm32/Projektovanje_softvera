/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.40 : Database - masastevanovicproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`masastevanovicproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `masastevanovicproject`;

/*Table structure for table `destinacija` */

DROP TABLE IF EXISTS `destinacija`;

CREATE TABLE `destinacija` (
  `iddestinacije` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nazivdestinacije` varchar(30) NOT NULL,
  `opisdestinacije` varchar(100) NOT NULL,
  `drzava` varchar(30) NOT NULL,
  `kontinent` varchar(30) NOT NULL,
  PRIMARY KEY (`iddestinacije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `idklijenta` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `telefon` varchar(14) NOT NULL,
  `email` varchar(100) NOT NULL,
  `adresa` varchar(100) NOT NULL,
  `idnacionalnosti` bigint unsigned NOT NULL,
  PRIMARY KEY (`idklijenta`),
  KEY `klijent_ibfk_1` (`idnacionalnosti`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`idnacionalnosti`) REFERENCES `nacionalnost` (`idnacionalnosti`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `nacionalnost` */

DROP TABLE IF EXISTS `nacionalnost`;

CREATE TABLE `nacionalnost` (
  `idnacionalnosti` bigint unsigned NOT NULL AUTO_INCREMENT,
  `privilegije` varchar(100) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idnacionalnosti`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `idrezervacije` bigint unsigned NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `idagencije` bigint unsigned NOT NULL,
  `idklijenta` bigint unsigned NOT NULL,
  `cena` bigint DEFAULT NULL,
  PRIMARY KEY (`idrezervacije`),
  KEY `idagencije` (`idagencije`),
  KEY `idklijenta` (`idklijenta`),
  CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`idagencije`) REFERENCES `turistickaagencija` (`idagencije`) ON UPDATE RESTRICT,
  CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`idklijenta`) REFERENCES `klijent` (`idklijenta`) ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `stavkarezervacije` */

DROP TABLE IF EXISTS `stavkarezervacije`;

CREATE TABLE `stavkarezervacije` (
  `idrezervacije` bigint unsigned NOT NULL,
  `idstavke` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nazivstavke` varchar(50) NOT NULL,
  `opisstavke` varchar(100) NOT NULL,
  `iddestinacije` bigint unsigned NOT NULL,
  PRIMARY KEY (`idrezervacije`,`idstavke`),
  KEY `idstavke` (`idstavke`),
  KEY `iddestinacije` (`iddestinacije`),
  CONSTRAINT `stavkarezervacije_ibfk_1` FOREIGN KEY (`idrezervacije`) REFERENCES `rezervacija` (`idrezervacije`) ON UPDATE RESTRICT,
  CONSTRAINT `stavkarezervacije_ibfk_2` FOREIGN KEY (`iddestinacije`) REFERENCES `destinacija` (`iddestinacije`) ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `tavu` */

DROP TABLE IF EXISTS `tavu`;

CREATE TABLE `tavu` (
  `idagencije` bigint unsigned NOT NULL,
  `idvrstausluge` bigint unsigned NOT NULL,
  `idtavu` bigint unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idagencije`,`idvrstausluge`),
  KEY `idtavu` (`idtavu`),
  KEY `idvrstausluge` (`idvrstausluge`),
  CONSTRAINT `tavu_ibfk_1` FOREIGN KEY (`idagencije`) REFERENCES `turistickaagencija` (`idagencije`) ON UPDATE RESTRICT,
  CONSTRAINT `tavu_ibfk_2` FOREIGN KEY (`idvrstausluge`) REFERENCES `vrstausluge` (`idvrstausluge`) ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `turistickaagencija` */

DROP TABLE IF EXISTS `turistickaagencija`;

CREATE TABLE `turistickaagencija` (
  `idagencije` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nazivagencije` varchar(50) DEFAULT NULL,
  `adresaagencije` varchar(100) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idagencije`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `vrstausluge` */

DROP TABLE IF EXISTS `vrstausluge`;

CREATE TABLE `vrstausluge` (
  `idvrstausluge` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nazivusluge` varchar(30) NOT NULL,
  `opisusluge` varchar(100) NOT NULL,
  PRIMARY KEY (`idvrstausluge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

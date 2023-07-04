CREATE DATABASE  IF NOT EXISTS `bd_proyecto_hotel_dawii` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_proyecto_hotel_dawii`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_proyecto_hotel_dawii
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cargo` (
  `cod_crg` int NOT NULL,
  `nom_crg` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_crg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargo`
--

LOCK TABLES `tb_cargo` WRITE;
/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` VALUES (1,'Mesero(a)'),(2,'Limpieza'),(3,'Recepcionista'),(4,'Anfitrion(a)'),(5,'Bartender'),(6,'Administrador(a)');
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_clientes` (
  `cod_cli` int NOT NULL AUTO_INCREMENT,
  `nom_cli` varchar(50) DEFAULT NULL,
  `ape_cli` varchar(50) DEFAULT NULL,
  `dni_cli` char(9) DEFAULT NULL,
  `ruc_cli` char(11) DEFAULT NULL,
  `cel_cli` varchar(9) DEFAULT NULL,
  `email_cli` varchar(50) DEFAULT NULL,
  `dir_cli` varchar(50) DEFAULT NULL,
  `cod_tip_cli` int DEFAULT NULL,
  `cod_disp` int DEFAULT NULL,
  PRIMARY KEY (`cod_cli`),
  KEY `FKgbrdshfcq2rjgcx09o9vwq5ob` (`cod_disp`),
  KEY `FKft6xgabkclnem3r08yavb9wiv` (`cod_tip_cli`),
  CONSTRAINT `FKft6xgabkclnem3r08yavb9wiv` FOREIGN KEY (`cod_tip_cli`) REFERENCES `tb_tipocliente` (`cod_tip_cli`),
  CONSTRAINT `FKgbrdshfcq2rjgcx09o9vwq5ob` FOREIGN KEY (`cod_disp`) REFERENCES `tb_disponibilidad` (`cod_disp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES (1,'Leonel','Guzman Ramirez','45251241','12541236524','954854123','leonel@gmail.com','av los paltos 123',1,1),(2,'Angel','Mendez','71222521','71251521142','957484484','angel@gmail.com','av los manzanos 123',1,1);
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_disponibilidad`
--

DROP TABLE IF EXISTS `tb_disponibilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_disponibilidad` (
  `cod_disp` int NOT NULL,
  `disponibilidad` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`cod_disp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_disponibilidad`
--

LOCK TABLES `tb_disponibilidad` WRITE;
/*!40000 ALTER TABLE `tb_disponibilidad` DISABLE KEYS */;
INSERT INTO `tb_disponibilidad` VALUES (1,'si'),(2,'no');
/*!40000 ALTER TABLE `tb_disponibilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleado` (
  `cod_emp` int NOT NULL AUTO_INCREMENT,
  `nom_emp` varchar(50) DEFAULT NULL,
  `ape_emp` varchar(50) DEFAULT NULL,
  `dni_emp` char(9) DEFAULT NULL,
  `email_emp` varchar(50) DEFAULT NULL,
  `cel_emp` varchar(9) DEFAULT NULL,
  `dir_emp` varchar(50) DEFAULT NULL,
  `fec_nac_emp` date DEFAULT NULL,
  `hijos_emp` int DEFAULT NULL,
  `prof_emp` varchar(15) DEFAULT NULL,
  `sueldo_emp` decimal(10,0) DEFAULT NULL,
  `cod_crg` int DEFAULT NULL,
  `cod_con` int DEFAULT NULL,
  `cod_disp` int DEFAULT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `FK1cf8j9irfv3cntlcj7www3msm` (`cod_crg`),
  KEY `FK5kixqkjanv2yrnn747yscwqrp` (`cod_disp`),
  KEY `FKdc5bt0iunhamei70icd0endhv` (`cod_con`),
  CONSTRAINT `FK1cf8j9irfv3cntlcj7www3msm` FOREIGN KEY (`cod_crg`) REFERENCES `tb_cargo` (`cod_crg`),
  CONSTRAINT `FK5kixqkjanv2yrnn747yscwqrp` FOREIGN KEY (`cod_disp`) REFERENCES `tb_disponibilidad` (`cod_disp`),
  CONSTRAINT `FKdc5bt0iunhamei70icd0endhv` FOREIGN KEY (`cod_con`) REFERENCES `tb_tipocontrato` (`cod_con`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` VALUES (1,'Angel','Mendez','71252121','angel@gmail.com','974154154','av los manzanos 123','2002-09-14',0,'Informatico',1500,6,3,1);
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `cod_est` int NOT NULL,
  `des_est` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_est`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'Saldo 0%'),(2,'Saldo 50%'),(3,'Saldo 100%');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_habitaciones`
--

DROP TABLE IF EXISTS `tb_habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_habitaciones` (
  `cod_hab` int NOT NULL AUTO_INCREMENT,
  `num_hab` varchar(5) DEFAULT NULL,
  `nom_hab` varchar(50) DEFAULT NULL,
  `cod_pab` int DEFAULT NULL,
  `cod_tip_hab` int DEFAULT NULL,
  `cod_pis` int DEFAULT NULL,
  `cod_disp` int DEFAULT NULL,
  PRIMARY KEY (`cod_hab`),
  KEY `FKhsrrsmnxqwn0h9y1jn0pf41dw` (`cod_disp`),
  KEY `FKe9b3s4pribhb64qd6gks8lndr` (`cod_pab`),
  KEY `FKc5ffpnqrl6qrb9bxiure5m3ve` (`cod_pis`),
  KEY `FKf7blj8wh7an6s7gtm7lwd64w0` (`cod_tip_hab`),
  CONSTRAINT `FKc5ffpnqrl6qrb9bxiure5m3ve` FOREIGN KEY (`cod_pis`) REFERENCES `tb_pisos` (`cod_pis`),
  CONSTRAINT `FKe9b3s4pribhb64qd6gks8lndr` FOREIGN KEY (`cod_pab`) REFERENCES `tb_pabellon` (`cod_pab`),
  CONSTRAINT `FKf7blj8wh7an6s7gtm7lwd64w0` FOREIGN KEY (`cod_tip_hab`) REFERENCES `tb_tipohabitacion` (`cod_tip_hab`),
  CONSTRAINT `FKhsrrsmnxqwn0h9y1jn0pf41dw` FOREIGN KEY (`cod_disp`) REFERENCES `tb_disponibilidad` (`cod_disp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_habitaciones`
--

LOCK TABLES `tb_habitaciones` WRITE;
/*!40000 ALTER TABLE `tb_habitaciones` DISABLE KEYS */;
INSERT INTO `tb_habitaciones` VALUES (1,'101','Los Lucumos',2,4,1,2),(2,'102','Las Paltos',1,1,1,2);
/*!40000 ALTER TABLE `tb_habitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_origen`
--

DROP TABLE IF EXISTS `tb_origen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_origen` (
  `cod_orig` int NOT NULL,
  `des_orig` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_orig`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_origen`
--

LOCK TABLES `tb_origen` WRITE;
/*!40000 ALTER TABLE `tb_origen` DISABLE KEYS */;
INSERT INTO `tb_origen` VALUES (1,'En espera'),(2,'Ocupada'),(3,'Salida');
/*!40000 ALTER TABLE `tb_origen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pabellon`
--

DROP TABLE IF EXISTS `tb_pabellon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pabellon` (
  `cod_pab` int NOT NULL,
  `des_pab` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_pab`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pabellon`
--

LOCK TABLES `tb_pabellon` WRITE;
/*!40000 ALTER TABLE `tb_pabellon` DISABLE KEYS */;
INSERT INTO `tb_pabellon` VALUES (1,'P - 1'),(2,'P - 2'),(3,'P - 3');
/*!40000 ALTER TABLE `tb_pabellon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pago`
--

DROP TABLE IF EXISTS `tb_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pago` (
  `cod_pago` int NOT NULL,
  `des_pago` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pago`
--

LOCK TABLES `tb_pago` WRITE;
/*!40000 ALTER TABLE `tb_pago` DISABLE KEYS */;
INSERT INTO `tb_pago` VALUES (1,'Tarjeta'),(2,'Efectivo'),(3,'Transferencia');
/*!40000 ALTER TABLE `tb_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pais`
--

DROP TABLE IF EXISTS `tb_pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pais` (
  `cod_pais` int NOT NULL AUTO_INCREMENT,
  `nom_pais` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pais`
--

LOCK TABLES `tb_pais` WRITE;
/*!40000 ALTER TABLE `tb_pais` DISABLE KEYS */;
INSERT INTO `tb_pais` VALUES (1,'Peru'),(2,'Argentina'),(3,'España'),(4,'Colombia'),(5,'EEUU'),(6,'Brazil');
/*!40000 ALTER TABLE `tb_pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pisos`
--

DROP TABLE IF EXISTS `tb_pisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pisos` (
  `cod_pis` int NOT NULL,
  `nom_pis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_pis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pisos`
--

LOCK TABLES `tb_pisos` WRITE;
/*!40000 ALTER TABLE `tb_pisos` DISABLE KEYS */;
INSERT INTO `tb_pisos` VALUES (1,'Primer piso'),(2,'Segundo piso'),(3,'Tercer piso');
/*!40000 ALTER TABLE `tb_pisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `cod_prov` int NOT NULL AUTO_INCREMENT,
  `ruc_prov` char(11) DEFAULT NULL,
  `nom_prov` varchar(45) DEFAULT NULL,
  `rep_legal_prov` varchar(45) DEFAULT NULL,
  `dir_prov` varchar(50) DEFAULT NULL,
  `tlf_prov` varchar(12) DEFAULT NULL,
  `email_prov` varchar(45) DEFAULT NULL,
  `fec_reg_prov` date DEFAULT NULL,
  `cod_pais` int DEFAULT NULL,
  `cod_sed` int DEFAULT NULL,
  `suc_prov` varchar(30) DEFAULT NULL,
  `cod_disp` int DEFAULT NULL,
  PRIMARY KEY (`cod_prov`),
  KEY `FK39h4dte8oynpbm3gvauheqh08` (`cod_disp`),
  KEY `FK1q61h8im4vsgyrf89req2mg74` (`cod_pais`),
  KEY `FKm8i9gnetslnqa0hxnfvc4ov7h` (`cod_sed`),
  CONSTRAINT `FK1q61h8im4vsgyrf89req2mg74` FOREIGN KEY (`cod_pais`) REFERENCES `tb_pais` (`cod_pais`),
  CONSTRAINT `FK39h4dte8oynpbm3gvauheqh08` FOREIGN KEY (`cod_disp`) REFERENCES `tb_disponibilidad` (`cod_disp`),
  CONSTRAINT `FKm8i9gnetslnqa0hxnfvc4ov7h` FOREIGN KEY (`cod_sed`) REFERENCES `tb_sede` (`cod_sed`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'10121335321','Coca Cola','Juan Marquina','av centro 124','04495','coca_cola@hotmail.com','2022-10-10',2,7,'centro',1),(4,'74514545161','Gloria','gloria Arboleda','av los manzanos 123','957484484','gloria@gmail.com','2023-06-15',1,1,'Principal',1);
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reserva`
--

DROP TABLE IF EXISTS `tb_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reserva` (
  `cod_res` int NOT NULL AUTO_INCREMENT,
  `check_in` varchar(255) DEFAULT NULL,
  `check_out` varchar(255) DEFAULT NULL,
  `pre_res` double DEFAULT NULL,
  `cod_cli` int DEFAULT NULL,
  `cod_est` int DEFAULT NULL,
  `cod_hab` int DEFAULT NULL,
  `cod_orig` int DEFAULT NULL,
  `cod_pago` int DEFAULT NULL,
  PRIMARY KEY (`cod_res`),
  KEY `cod_cli` (`cod_cli`),
  KEY `cod_est` (`cod_est`),
  KEY `cod_hab` (`cod_hab`),
  KEY `cod_orig` (`cod_orig`),
  KEY `cod_pago` (`cod_pago`),
  CONSTRAINT `tb_reserva_ibfk_1` FOREIGN KEY (`cod_cli`) REFERENCES `tb_clientes` (`cod_cli`),
  CONSTRAINT `tb_reserva_ibfk_2` FOREIGN KEY (`cod_est`) REFERENCES `tb_estado` (`cod_est`),
  CONSTRAINT `tb_reserva_ibfk_3` FOREIGN KEY (`cod_hab`) REFERENCES `tb_habitaciones` (`cod_hab`),
  CONSTRAINT `tb_reserva_ibfk_4` FOREIGN KEY (`cod_orig`) REFERENCES `tb_origen` (`cod_orig`),
  CONSTRAINT `tb_reserva_ibfk_5` FOREIGN KEY (`cod_pago`) REFERENCES `tb_pago` (`cod_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reserva`
--

LOCK TABLES `tb_reserva` WRITE;
/*!40000 ALTER TABLE `tb_reserva` DISABLE KEYS */;
INSERT INTO `tb_reserva` VALUES (2,'2023-06-22','2023-06-25',50,1,1,1,1,1),(3,'2023-06-22','2023-06-26',50,1,3,1,3,1),(4,'2023-06-26','2023-06-28',100,2,1,2,1,1),(5,'2023-06-26','2023-06-28',100,2,1,1,1,1);
/*!40000 ALTER TABLE `tb_reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles`
--

DROP TABLE IF EXISTS `tb_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_roles` (
  `cod_roles` int NOT NULL AUTO_INCREMENT,
  `nom_roles` varchar(30) DEFAULT NULL,
  `cod_usuarios` int DEFAULT NULL,
  PRIMARY KEY (`cod_roles`),
  KEY `FK7pfkpwxsloco7wdmmr6jrmycq` (`cod_usuarios`),
  CONSTRAINT `FK7pfkpwxsloco7wdmmr6jrmycq` FOREIGN KEY (`cod_usuarios`) REFERENCES `tb_usuarios` (`cod_usuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles`
--

LOCK TABLES `tb_roles` WRITE;
/*!40000 ALTER TABLE `tb_roles` DISABLE KEYS */;
INSERT INTO `tb_roles` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_RECEPCION',1),(3,'ROLE_RECEPCION',2),(4,'ROLE_VENTAS',NULL),(5,'ROLE_ALMACEN',NULL);
/*!40000 ALTER TABLE `tb_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sede`
--

DROP TABLE IF EXISTS `tb_sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sede` (
  `cod_sed` int NOT NULL AUTO_INCREMENT,
  `nom_sed` varchar(30) DEFAULT NULL,
  `cod_pais` int DEFAULT NULL,
  PRIMARY KEY (`cod_sed`),
  KEY `FKiqwxwjquusub8sdi3wc53ky44` (`cod_pais`),
  CONSTRAINT `FKiqwxwjquusub8sdi3wc53ky44` FOREIGN KEY (`cod_pais`) REFERENCES `tb_pais` (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sede`
--

LOCK TABLES `tb_sede` WRITE;
/*!40000 ALTER TABLE `tb_sede` DISABLE KEYS */;
INSERT INTO `tb_sede` VALUES (1,'Lima',1),(2,'Trujillo',1),(3,'Arequipa',1),(4,'Ica',1),(5,'Cuzco',1),(6,'Piura',1),(7,'Buenos Aires',2),(8,'La Plata',2),(9,'Rosario',2),(10,'Ciudad de Santa Fe',2),(11,'Mendoza',2),(12,'Barcelona',3),(13,'Madrid',3),(14,'Valencia',3),(15,'Sevilla',3),(16,'Granada',3),(17,'Medellin',4),(18,'Cali',4),(19,'Barranquilla',4),(20,'Bogota',4),(21,'Cúcuta',4),(22,'Washington DC',5),(23,'New York',5),(24,'Los Angeles',5),(25,'Detroit',5),(26,'Boston',5),(27,'Brasilia',6),(28,'Rio de Janeiro',6),(29,'Manau',6),(30,'Recife',6),(31,'Curitiva',6),(32,'Belén',6);
/*!40000 ALTER TABLE `tb_sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_servicio`
--

DROP TABLE IF EXISTS `tb_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_servicio` (
  `cod_serv` int NOT NULL AUTO_INCREMENT,
  `des_serv` varchar(50) DEFAULT NULL,
  `cod_tip_serv` int DEFAULT NULL,
  `pre_serv` decimal(10,2) DEFAULT NULL,
  `cod_disp` int DEFAULT NULL,
  PRIMARY KEY (`cod_serv`),
  KEY `FKgtx1qufvye1sd2y3tf7rn5jv6` (`cod_disp`),
  KEY `FK9l0sn15xf6odr5uovj2skqenm` (`cod_tip_serv`),
  CONSTRAINT `FK9l0sn15xf6odr5uovj2skqenm` FOREIGN KEY (`cod_tip_serv`) REFERENCES `tb_tip_servicio` (`cod_tip_serv`),
  CONSTRAINT `FKgtx1qufvye1sd2y3tf7rn5jv6` FOREIGN KEY (`cod_disp`) REFERENCES `tb_disponibilidad` (`cod_disp`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_servicio`
--

LOCK TABLES `tb_servicio` WRITE;
/*!40000 ALTER TABLE `tb_servicio` DISABLE KEYS */;
INSERT INTO `tb_servicio` VALUES (1,'Daiquiri',1,20.00,1),(2,'Mojito',1,20.00,1),(3,'Pato Guisado',2,35.00,1);
/*!40000 ALTER TABLE `tb_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stock`
--

DROP TABLE IF EXISTS `tb_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_stock` (
  `cod_stock` int NOT NULL AUTO_INCREMENT,
  `nom_stock` varchar(50) DEFAULT NULL,
  `cant_stock` int DEFAULT NULL,
  `cod_tip_stock` int DEFAULT NULL,
  `pre_venta_stock` decimal(10,2) DEFAULT NULL,
  `pre_compra_stock` decimal(10,2) DEFAULT NULL,
  `cod_prov` int DEFAULT NULL,
  `cod_disp` int DEFAULT NULL,
  PRIMARY KEY (`cod_stock`),
  KEY `FK2wb6ka0uvducad1u77iylm3sk` (`cod_disp`),
  KEY `FKpb6gakisvd9ui8vtq9pnf6rg0` (`cod_prov`),
  KEY `FKcg1yn4nphfrf3iyuik2o9wygd` (`cod_tip_stock`),
  CONSTRAINT `FK2wb6ka0uvducad1u77iylm3sk` FOREIGN KEY (`cod_disp`) REFERENCES `tb_disponibilidad` (`cod_disp`),
  CONSTRAINT `FKcg1yn4nphfrf3iyuik2o9wygd` FOREIGN KEY (`cod_tip_stock`) REFERENCES `tb_tipo_stock` (`cod_tip_stock`),
  CONSTRAINT `FKpb6gakisvd9ui8vtq9pnf6rg0` FOREIGN KEY (`cod_prov`) REFERENCES `tb_proveedor` (`cod_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stock`
--

LOCK TABLES `tb_stock` WRITE;
/*!40000 ALTER TABLE `tb_stock` DISABLE KEYS */;
INSERT INTO `tb_stock` VALUES (1,'Coca Cola',50,4,5.00,2.50,1,1);
/*!40000 ALTER TABLE `tb_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tip_servicio`
--

DROP TABLE IF EXISTS `tb_tip_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tip_servicio` (
  `cod_tip_serv` int NOT NULL AUTO_INCREMENT,
  `nom_tip_serv` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_tip_serv`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tip_servicio`
--

LOCK TABLES `tb_tip_servicio` WRITE;
/*!40000 ALTER TABLE `tb_tip_servicio` DISABLE KEYS */;
INSERT INTO `tb_tip_servicio` VALUES (1,'Tragos'),(2,'Almuerzo'),(3,'Cena');
/*!40000 ALTER TABLE `tb_tip_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_stock`
--

DROP TABLE IF EXISTS `tb_tipo_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_stock` (
  `cod_tip_stock` int NOT NULL,
  `nom_tip_stock` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tip_stock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_stock`
--

LOCK TABLES `tb_tipo_stock` WRITE;
/*!40000 ALTER TABLE `tb_tipo_stock` DISABLE KEYS */;
INSERT INTO `tb_tipo_stock` VALUES (1,'Snacks'),(2,'Galletas'),(3,'Dulces'),(4,'Bebidas'),(5,'Licores');
/*!40000 ALTER TABLE `tb_tipo_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocliente`
--

DROP TABLE IF EXISTS `tb_tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipocliente` (
  `cod_tip_cli` int NOT NULL,
  `nom_tip_cli` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tip_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocliente`
--

LOCK TABLES `tb_tipocliente` WRITE;
/*!40000 ALTER TABLE `tb_tipocliente` DISABLE KEYS */;
INSERT INTO `tb_tipocliente` VALUES (1,'Huesped'),(2,'Full Day');
/*!40000 ALTER TABLE `tb_tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocontrato`
--

DROP TABLE IF EXISTS `tb_tipocontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipocontrato` (
  `cod_con` int NOT NULL,
  `des_con` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_con`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocontrato`
--

LOCK TABLES `tb_tipocontrato` WRITE;
/*!40000 ALTER TABLE `tb_tipocontrato` DISABLE KEYS */;
INSERT INTO `tb_tipocontrato` VALUES (1,'Temporal'),(2,'Part-time'),(3,'Indeterminado');
/*!40000 ALTER TABLE `tb_tipocontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipohabitacion`
--

DROP TABLE IF EXISTS `tb_tipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipohabitacion` (
  `cod_tip_hab` int NOT NULL,
  `nom_tip_hab` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tip_hab`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipohabitacion`
--

LOCK TABLES `tb_tipohabitacion` WRITE;
/*!40000 ALTER TABLE `tb_tipohabitacion` DISABLE KEYS */;
INSERT INTO `tb_tipohabitacion` VALUES (1,'Matrimonial'),(2,'Triple'),(3,'Cuadrupe'),(4,'Quintuple');
/*!40000 ALTER TABLE `tb_tipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `cod_usuarios` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `clave` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`cod_usuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'admin','$2a$10$TkVh2e32SPAIfnTNQdQCXOPV06vnfFDvYlIsTIBJkcOx8knMP98.q'),(2,'recepcion','$2a$10$83A0gdYaeUBTo7p36ZtycudWS1n1rZn30vHqj6wlImFWIN8V.9cdK');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-26 12:50:57

-- TRIGGER PARA RECALCULAR DISPO
--
delimiter $$
create  trigger recalcularHabiTrigger
after insert on tb_reserva
for each row
begin
		declare codHab int ;
        set codHab = new.cod_hab;
		update tb_habitaciones set cod_disp = 2 where cod_hab = codHab;
end

$$

delimiter $$
create  trigger recalcularDispoTrigger
after update on tb_reserva
for each row
    begin
        declare codHab int ;
        set codHab = new.cod_hab;

        if new.cod_orig = 3 
        then
            update tb_habitaciones set cod_disp = 1 where cod_hab = codHab;
        end if;
end;

create table tb_boleta
(
cod_bol 	serial primary key ,
cod_cli		int references tb_clientes,
cod_usuarios	int references tb_usuarios,
fecha		date,
total_bol	decimal(10,2)
);

create table tb_det_boleta
(
cod_bol 	int references tb_boleta,
cod_stock	int references tb_stock,
precio		decimal(10,2),
cantidad 	int,
cod_pago	int references tb_pago,
primary key (cod_bol,cod_stock)
);

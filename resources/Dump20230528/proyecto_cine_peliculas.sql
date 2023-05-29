-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_cine
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
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas` (
  `idPelicula` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  `año` int NOT NULL,
  `duracion` int NOT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(100) DEFAULT NULL,
  `sinopsis` varchar(1000) DEFAULT NULL,
  `cartel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPelicula`),
  UNIQUE KEY `idPelicula_UNIQUE` (`idPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (1,'La llegada','Denis Villeneuve',2016,116,13,'Ciencia ficción','Un grupo de expertos en lingüística es contratado por el gobierno de EE.UU. para establecer contacto con unos extraterrestres que han llegado a la Tierra en una nave espacial.','https://pics.filmaffinity.com/arrival-150207636-mmed.jpg'),(2,'Pulp Fiction','Quentin Tarantino',1994,154,18,'Crimen,Comedia negra,Película de gangsters','La película sigue la vida de varios personajes, todos ellos relacionados de alguna manera con el mundo del crimen organizado.','https://pics.filmaffinity.com/Pulp_Fiction-210382116-mmed.jpg'),(3,'V de Vendetta','James McTeigue',2006,132,16,'Acción,Ciencia ficción,Thriller político','En un futuro distópico, un misterioso enmascarado conocido como \"V\" lucha contra un régimen fascista en el Reino Unido.','https://pics.filmaffinity.com/V_de_Vendetta-296729466-mmed.jpg'),(4,'Dune','Denis Villeneuve',2021,155,13,'Ciencia ficción,Aventura,Acción','En un futuro lejano, un joven noble llamado Paul Atreides debe liderar a su pueblo en una lucha por el control del planeta desierto Arrakis, también conocido como Dune.','https://pics.filmaffinity.com/Dune-209834814-large.jpg');
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-28 10:41:15

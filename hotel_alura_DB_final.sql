-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.33 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for hotel_alura
DROP DATABASE IF EXISTS `hotel_alura`;
CREATE DATABASE IF NOT EXISTS `hotel_alura` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel_alura`;

-- Dumping structure for table hotel_alura.huesped
DROP TABLE IF EXISTS `huesped`;
CREATE TABLE IF NOT EXISTS `huesped` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fechanacimiento` date NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `idreserva` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table hotel_alura.huesped: ~2 rows (approximately)
INSERT INTO `huesped` (`id`, `nombre`, `apellido`, `fechanacimiento`, `nacionalidad`, `telefono`, `idreserva`) VALUES
	(9, 'karlo', 'sosa', '2023-05-17', 'Perú', 'asdfasdf', 1),
	(10, 'ivonne', 'lino', '1974-11-06', 'El Salvador', '651651651', 2);

-- Dumping structure for table hotel_alura.reserva
DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fechaentrada` date NOT NULL,
  `fechasalida` date NOT NULL,
  `valor` int NOT NULL,
  `formapago` varchar(45) NOT NULL,
  `huesped` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table hotel_alura.reserva: ~1 rows (approximately)
INSERT INTO `reserva` (`id`, `fechaentrada`, `fechasalida`, `valor`, `formapago`, `huesped`) VALUES
	(1, '2023-05-09', '2023-05-16', 14000, 'Tarjeta de Crédito', NULL),
	(2, '2023-05-25', '2023-05-27', 40, 'Tarjeta de Crédito', NULL);

-- Dumping structure for table hotel_alura.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `usuario` varchar(25) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nivel_acceso` varchar(25) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table hotel_alura.usuarios: ~2 rows (approximately)
INSERT INTO `usuarios` (`usuario`, `password`, `nivel_acceso`) VALUES
	('Karen987', '12345', 'Recepcionista'),
	('Karlo', '12345', 'Gerente');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

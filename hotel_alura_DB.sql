CREATE DATABASE  IF NOT EXISTS `hotel_alura`;
USE `hotel_alura`;


DROP TABLE IF EXISTS `huesped`;
DROP TABLE IF EXISTS `reserva`;

CREATE TABLE `reserva` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fechaentrada` date NOT NULL,
  `fechasalida` date NOT NULL,
/*  `valor` decimal(9,2) NOT NULL,*/
	`valor` int(8) NOT NULL,
  `formapago` varchar(45) NOT NULL,
  `huesped` varchar(45) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*LOCK TABLES `reserva` WRITE;

INSERT INTO `hotel_alura`.`reserva` (`id`, `ingreso`, `egreso`, `precio`, `pago`, `huesped`) VALUES (1, '2022-06-01','2022-06-23',12121.78,'Dinero en Efectivo','1'),(2,'2022-06-01','2022-06-17',8815.84,'Tarjeta de Débito','2'),(3,'2022-06-03','2022-09-15',57302.96,'Tarjeta de Débito','4'),(4,'2022-06-22','2022-06-25',1652.97,'Tarjeta de Débito','8'),(5,'2022-06-01','2022-06-30',15978.71,'Dinero en Efectivo','6'),(6,'2022-06-08','2022-06-23',8264.85,'Dinero en Efectivo','7');

UNLOCK TABLES;*/



CREATE TABLE `huesped` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fechanacimiento` date NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `idreserva` int,
  PRIMARY KEY (`id`)
  /*,KEY `id_reserva` (`idreserva`)
  ,CONSTRAINT `huesped_k` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`)*/
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*LOCK TABLES `huesped` WRITE;
INSERT INTO `huesped` VALUES (3,'Ángelica','Flores Diaz','1987-02-17','Mexican – mexicano','33-33-22-44-33',1),(4,'Francisco','Lopez Rodi','1976-09-23','Nicaraguan – nicaraguense','22-11-22-33-44',2),(5,'Ana','Lopez Bautista','1987-06-27','Guatemalan – guatemalteco','22-33-44-43-33',3),(6,'Raquel','Dominguez Salazar','1987-06-18','Colombian – colombiano','44-33-22-33-44',4),(7,'Eduardo','Reyes Hernández','1998-03-18','Mexican – mexicano','44-33-44-33-44',5),(8,'Paloma','Dominguez Sanchez','1977-06-10','Argentinian – argentino','33-44-33-22-44',6);
UNLOCK TABLES;

DROP TABLE IF EXISTS `usuarios`;*/

CREATE TABLE `usuarios` (
  
  `usuario` varchar(25) NOT NULL,
  `password` varchar(30) NOT NULL,  
  `nivel_acceso` varchar(25) NOT NULL,
   PRIMARY KEY (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `usuarios` WRITE;

INSERT INTO `usuarios` VALUES ('Karlo','12345','Gerente'),('Karen987','12345','Recepcionista');

UNLOCK TABLES;

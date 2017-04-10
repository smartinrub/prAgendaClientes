# pragendaclientes

This project uses the following technologies:

- J2EE
- Spring Boot MVC
- Spring Security
- REST
- JPA
- AngularJS
- JQuery
- Bootstrap
- JUnit
- JMockit
- Mockito

MySQL database: two tables, one for clientes and another one for pedidos

CREATE TABLE agenda;

USE agenda;

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contacto_frio` tinyint(1) DEFAULT '0',
  `referencia` tinyint(1) DEFAULT '0',
  `recibio_cmcp` tinyint(1) DEFAULT '0',
  `fue_anfitriona` tinyint(1) DEFAULT '0',
  `sesion_color` tinyint(1) DEFAULT '0',
  `sesion_fragancias` tinyint(1) DEFAULT '0',
  `comparti_oportunidad` tinyint(1) DEFAULT '0',
  `asistio_evento` tinyint(1) DEFAULT '0',
  `personalidad` enum('dominante','familiar','perfeccionista','social') DEFAULT NULL,
  `observaciones` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `producto` varchar(100) NOT NULL,
  `precio` double DEFAULT NULL,
  `dto` double DEFAULT '0',
  `ac` double DEFAULT '0',
  `cobrado` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id_cliente_idx` (`cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

When you have everything set up and the .jar file has been generated you can deploy the application by typing the following command into your unix terminal:

java -jar prAgendaClientes-1.0.jar

You also can run this application at startup by adding the previos command into /etc/rc.local

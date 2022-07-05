-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2022 a las 14:47:15
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL,
  `idTipoHabitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `nroHabitacion` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `idHuesped` int(11) NOT NULL,
  `dniHuesped` int(10) NOT NULL,
  `nombreHuesped` varchar(255) NOT NULL,
  `apellidoHuesped` varchar(255) NOT NULL,
  `domicilioHuesped` varchar(255) NOT NULL,
  `emailHuesped` varchar(255) NOT NULL,
  `celularHuesped` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`idHuesped`, `dniHuesped`, `nombreHuesped`, `apellidoHuesped`, `domicilioHuesped`, `emailHuesped`, `celularHuesped`) VALUES
(1, 28921938, 'Pablo Ezequiel', 'Tripicchio', 'calle colon', 'pablo@gmail.com', '266487863'),
(2, 21212121, 'Huesped nombre2', 'Apellido2', 'calle colon', 'pablo@gmail.com', '266487866'),
(3, 22222222, 'Huesped nombre3', 'Apellido3', 'calle colon', 'pablo@gmail.com', '266422222'),
(5, 24242424, 'Huesped nombre5', 'Apellido5', 'calle colon', 'pablo@gmail.com', '266444444'),
(6, 333, 'maca', 'infante', 'blabla', 'bleble', '123456'),
(7, 37724353, 'Macarena', 'Infante', 'blablablA', 'maqi@blabla', '2664360626');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idHuesped` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `cantidadPers` int(4) NOT NULL,
  `checkIn` date NOT NULL,
  `checkOut` date NOT NULL,
  `total` double NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE `tipo_habitacion` (
  `idTipoHabitacion` int(11) NOT NULL,
  `cantidadPers` int(3) NOT NULL,
  `cantCamas` int(11) NOT NULL,
  `tipoCamas` varchar(255) NOT NULL,
  `nombreTipoHabitacion` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_habitacion`
--

INSERT INTO `tipo_habitacion` (`idTipoHabitacion`, `cantidadPers`, `cantCamas`, `tipoCamas`, `nombreTipoHabitacion`, `precio`, `activo`) VALUES
(1, 2, 1, 'KS', 'Doble', 1000, 0),
(2, 3, 3, 'Simples', 'Triple', 1550, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`),
  ADD KEY `id_tipo_habitacion` (`idTipoHabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`idHuesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `id_huesped` (`idHuesped`),
  ADD KEY `id_habitacion` (`idHabitacion`);

--
-- Indices de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD PRIMARY KEY (`idTipoHabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idHabitacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `idHuesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  MODIFY `idTipoHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`idTipoHabitacion`) REFERENCES `tipo_habitacion` (`idTipoHabitacion`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idHuesped`) REFERENCES `huesped` (`idHuesped`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

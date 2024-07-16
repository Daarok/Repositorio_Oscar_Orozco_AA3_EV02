-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-07-2024 a las 19:20:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario_mirror_elite`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Diseño` varchar(100) DEFAULT NULL,
  `Dimensiones` varchar(50) DEFAULT NULL,
  `Forma` varchar(50) DEFAULT NULL,
  `Material` varchar(50) DEFAULT NULL,
  `Color` varchar(50) DEFAULT NULL,
  `peso` float NOT NULL,
  `precio` double NOT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Fecha_entrada` date DEFAULT NULL,
  `Proveedor` varchar(100) DEFAULT NULL,
  `Descripcion` text DEFAULT NULL,
  `Nombre_archivo_imagen` varchar(100) DEFAULT NULL,
  `Categoria` varchar(50) DEFAULT NULL,
  `archivo_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `Nombre`, `Diseño`, `Dimensiones`, `Forma`, `Material`, `Color`, `peso`, `precio`, `Stock`, `Fecha_entrada`, `Proveedor`, `Descripcion`, `Nombre_archivo_imagen`, `Categoria`, `archivo_image`) VALUES
(1, 'Espejo Luna', 'Diseño lunar', '100x100 cm', 'Redondo', 'Metal', 'Plateado', 5.5, 120, 10, '2024-01-15', 'Lunar Mirrors', 'Espejo con diseño de la luna en metal plateado.', 'espejo_luna.jpg', 'Astronómico', NULL),
(2, 'Espejo Moderno', 'Diseño contemporáneo', '80x120 cm', 'Rectangular', 'Madera', 'Negro', 6, 150, 5, '2024-01-20', 'Modern Mirrors', 'Espejo rectangular con un marco de madera negra.', 'espejo_moderno.jpg', 'Moderno', NULL),
(3, 'Espejo Vintage', 'Diseño retro', '70x90 cm', 'Ovalado', 'Hierro', 'Bronce', 4.8, 130, 8, '2024-01-25', 'Vintage Mirrors', 'Espejo ovalado con un marco de hierro bronceado.', 'espejo_vintage.jpg', 'Vintage', NULL),
(4, 'Espejo Rústico', 'Diseño rural', '90x110 cm', 'Cuadrado', 'Madera', 'Marrón', 7.2, 140, 12, '2024-01-30', 'Rustic Mirrors', 'Espejo cuadrado con un marco de madera marrón rústico.', 'espejo_rustico.jpg', 'Rústico', NULL),
(5, 'Espejo Minimalista', 'Diseño simple', '60x80 cm', 'Rectangular', 'Aluminio', 'Blanco', 3.5, 100, 15, '2024-02-01', 'Minimal Mirrors', 'Espejo rectangular con un marco de aluminio blanco.', 'espejo_minimalista.jpg', 'Minimalista', NULL),
(6, 'Espejo Barroco', 'Diseño ornamentado', '110x140 cm', 'Ovalado', 'Madera', 'Dorado', 8.5, 200, 7, '2024-02-05', 'Baroque Mirrors', 'Espejo ovalado con un marco de madera dorada ornamentada.', 'espejo_barroco.jpg', 'Barroco', NULL),
(7, 'Espejo Industrial', 'Diseño robusto', '120x150 cm', 'Rectangular', 'Metal', 'Gris', 10, 180, 9, '2024-02-10', 'Industrial Mirrors', 'Espejo rectangular con un marco de metal gris robusto.', 'espejo_industrial.jpg', 'Industrial', NULL),
(8, 'Espejo Clásico', 'Diseño tradicional', '100x130 cm', 'Redondo', 'Madera', 'Blanco', 6.2, 160, 11, '2024-02-12', 'Classic Mirrors', 'Espejo redondo con un marco de madera blanca tradicional.', 'espejo_clasico.jpg', 'Clásico', NULL),
(9, 'Espejo Art Deco', 'Diseño geométrico', '85x115 cm', 'Rectangular', 'Metal', 'Negro', 5.7, 175, 10, '2024-02-14', 'Deco Mirrors', 'Espejo rectangular con un diseño geométrico en el marco de metal negro.', 'espejo_art_deco.jpg', 'Art Deco', NULL),
(10, 'Espejo Contemporáneo', 'Diseño moderno', '90x120 cm', 'Ovalado', 'Plástico', 'Transparente', 4.5, 110, 14, '2024-02-20', 'Contemporary Mirrors', 'Espejo ovalado con un marco de plástico transparente moderno.', 'espejo_contemporaneo.jpg', 'Contemporáneo', NULL),
(11, 'Espejo Elegante', 'Diseño sofisticado', '95x150 cm', 'Redondo', 'Vidrio', 'Plateado', 6.8, 1500000, 13, '2024-02-22', 'Elegant Mirrors', 'Espejo redondo con un marco de vidrio plateado.', 'espejo_elegante.jpg', 'Elegante', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

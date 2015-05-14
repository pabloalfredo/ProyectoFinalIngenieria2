-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2015 a las 22:58:34
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbproyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE IF NOT EXISTS `boleta` (
  `num_bol` varchar(8) NOT NULL,
  `cod_cli` varchar(6) NOT NULL,
  `pre_tot` varchar(10) NOT NULL,
  `fecha` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `boleta`
--

INSERT INTO `boleta` (`num_bol`, `cod_cli`, `pre_tot`, `fecha`) VALUES
('00000001', 'CC0001', '20.4', '04/05/2013'),
('00000002', 'CC0002', '17.0', '04/05/2013'),
('00000003', 'CC0002', '10.0', '06/05/2013'),
('00000004', 'CC0003', '83.2', '10/05/2013'),
('00000005', 'CC0004', '15.5', '11/05/2013');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `cod_cli` varchar(6) NOT NULL,
  `nom_cli` varchar(30) NOT NULL,
  `ape_cli` varchar(30) NOT NULL,
  `sexo_cli` varchar(1) NOT NULL,
  `dni_cli` varchar(8) NOT NULL,
  `tel_cli` varchar(9) NOT NULL,
  `ruc_cli` varchar(11) NOT NULL,
  `email_cli` varchar(30) NOT NULL,
  `dir_cli` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cli`, `nom_cli`, `ape_cli`, `sexo_cli`, `dni_cli`, `tel_cli`, `ruc_cli`, `email_cli`, `dir_cli`) VALUES
('CC0002', 'manuela', 'gonzales prada', 'F', '46789822', '956844787', '1040502030', 'manuelgp@hotmail.com', 'pampa '),
('CC0003', 'jorge carlo', 'vaca antay', 'M', '45987896', '99485765', '10203040501', 'jorge_vaca@hotmail.com', 'miramar e- 25 parte prima'),
('CC0004', 'jesus ricardo', 'romero lopez', 'M', '47464748', '053457690', '102030404', 'jesusrrl@hotmail.com', 'ciudad nueva j-4'),
('CC0005', 'luis carlos', 'sanchez peralta', 'M', '46788998', '053481804', '20202020202', 'luis@hotmail.com', 'nuevo ilo'),
('CC0007', 'luis', 'roque paredes', 'M', '46768990', '053788990', '20200100100', 'luis@hotmail.com', 'miramar e-18 parte prima'),
('CC0008', 'maria', 'rosales ginez', 'F', '47778902', '488990', '20100100030', 'maria@hotmail.com', 'villa del mar ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleboleta`
--

CREATE TABLE IF NOT EXISTS `detalleboleta` (
  `num_bol` varchar(10) NOT NULL,
  `cod_pro` varchar(6) NOT NULL,
  `des_pro` varchar(30) NOT NULL,
  `cant_pro` varchar(3) NOT NULL,
  `pre_unit` varchar(10) NOT NULL,
  `pre_venta` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE IF NOT EXISTS `detallefactura` (
  `num_fac` varchar(10) NOT NULL,
  `cod_pro` varchar(6) NOT NULL,
  `des_pro` varchar(30) NOT NULL,
  `cant_pro` varchar(3) NOT NULL,
  `pre_unit` varchar(10) NOT NULL,
  `pre_tot` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detallefactura`
--

INSERT INTO `detallefactura` (`num_fac`, `cod_pro`, `des_pro`, `cant_pro`, `pre_unit`, `pre_tot`) VALUES
('00000008', 'CP0002', 'ron', '4', '15.00', '60.0'),
('00000008', 'CP0003', 'ariel', '5', '7.00', '35.0'),
('00000009', 'CP0002', 'ron', '5', '15.00', '75.0'),
('00000009', 'CP0004', 'atun', '4', '3.00', '12.0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `num_fac` varchar(8) NOT NULL,
  `cod_cli` varchar(6) NOT NULL,
  `ruc_cli` varchar(11) NOT NULL,
  `subtotal` varchar(10) NOT NULL,
  `igv` varchar(40) NOT NULL,
  `total` varchar(20) NOT NULL,
  `fec_fac` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`num_fac`, `cod_cli`, `ruc_cli`, `subtotal`, `igv`, `total`, `fec_fac`) VALUES
('00000001', 'CC0002', '1040502030', '67.0', '12.06', '79.06', '04/05/2013'),
('00000003', 'CC0004', '102030404', '66.0', '11.88', '77.88', '06/05/2013'),
('00000004', 'CC0003', '10203040501', '68.0', '12.24', '80.24', '08/05/2013'),
('00000005', 'CC0002', '1040502030', '45.5', '8.19', '53.69', '10/05/2013'),
('00000006', 'CC0004', '102030404', '24.0', '4.32', '28.32', '11/05/2013'),
('00000007', 'CC0005', '20202020202', '19.5', '3.51', '23.01', '11/05/2013'),
('00000008', 'CC0004', '102030404', '95.0', '17.1', '112.1', '14/09/2013'),
('00000009', 'CC0003', '10203040501', '87.0', '15.66', '102.66', '15/10/2013');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `cod_pro` varchar(6) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `precio` varchar(10) NOT NULL,
  `Stock` varchar(10) NOT NULL,
  `idtip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_pro`, `descripcion`, `precio`, `Stock`, `idtip`) VALUES
('CP0001', 'cocacola', '2.00', '20', 4),
('CP0002', 'ron', '15.00', '11', 5),
('CP0003', 'ariel', '7.00', '10', 3),
('CP0004', 'atun', '3.00', '16', 5),
('CP0005', '', '', '', 3),
('CP0006', 'ff', 'f', 'ff', 3),
('CP0007', 'azucar', '2.5', '10', 5),
('CP0008', 'huevos', '1.0', '20', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblarticulos`
--

CREATE TABLE IF NOT EXISTS `tblarticulos` (
  `codigoProducto` bigint(13) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `idCategoriaProducto` int(2) NOT NULL,
  `idMarcaProducto` int(2) NOT NULL,
  `idUnidadmedida` int(2) NOT NULL,
  `costo` double NOT NULL,
  `efectivo` double NOT NULL,
  `stockMaximo` int(11) NOT NULL,
  `stockMinimo` int(11) NOT NULL,
  `existencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblarticulos`
--

INSERT INTO `tblarticulos` (`codigoProducto`, `descripcion`, `idCategoriaProducto`, `idMarcaProducto`, `idUnidadmedida`, `costo`, `efectivo`, `stockMaximo`, `stockMinimo`, `existencia`) VALUES
(7462955102886, 'Cuaderno Eco', 1, 1, 1, 30, 45, 10, 10, 0),
(2849325645124, '', 1, 1, 1, 270, 320, 5, 4, 0),
(2849325645124, '', 1, 1, 1, 270, 320, 5, 4, 0),
(1726030386, 'Sepillo de Diente', 7, 1, 5, 15, 25, 10, 100, 0),
(1854383482, 'UNA COSA', 1, 1, 1, 45, 45, 3, 24, 0),
(1854383482, 'UNA COSA', 1, 1, 1, 45, 45, 3, 24, 0),
(1963987831, 'ffdsfsdfdf', 1, 1, 1, 44, 54, 434, 43, 0),
(1777043084, 'fsdfsfd', 1, 1, 1, 45, 34, 21, 65, 0),
(1395270474, 'Bocina Box', 7, 5, 6, 45, 554, 45, 45, 0),
(1286125368, 'probando este', 1, 1, 1, 4, 5, 44, 44, 0),
(1971246937, 'asdfsdfds', 1, 1, 1, 456, 5, 45, 4, 0),
(1086644994, 'fdffdgdfg', 1, 1, 1, 4.56564567, 456, 3453, 4, 0),
(1709279053, 'ddsfs', 1, 1, 1, 444, 444, 45, 4, 0),
(1494622405, '', 1, 1, 1, 55, 55, 5, 5, 0),
(1872308448, 'Motor', 2, 4, 4, 34, 54, 3, 3, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcategoriaproducto`
--

CREATE TABLE IF NOT EXISTS `tblcategoriaproducto` (
`idCategoriaProducto` int(11) NOT NULL,
  `Descripcion` varchar(60) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `tblcategoriaproducto`
--

INSERT INTO `tblcategoriaproducto` (`idCategoriaProducto`, `Descripcion`) VALUES
(1, 'Embutido'),
(2, 'Pamper'),
(3, 'Embutido'),
(4, 'Detergente'),
(5, 'Comida'),
(6, 'Refrigerio'),
(7, 'Otros'),
(8, 'la otra'),
(9, 'Frutas'),
(10, 'kkkkkkkkkk');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblciudades`
--

CREATE TABLE IF NOT EXISTS `tblciudades` (
`idCiudad` int(11) NOT NULL,
  `descripcion` varchar(60) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tblciudades`
--

INSERT INTO `tblciudades` (`idCiudad`, `descripcion`) VALUES
(1, 'San Francisco De Macoris'),
(2, 'La Vega '),
(3, 'San Juan'),
(4, 'San Pedro '),
(5, 'Santiago'),
(6, 'Nagua');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblclientes`
--

CREATE TABLE IF NOT EXISTS `tblclientes` (
  `codigoCliente` int(10) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `estadoCivil` varchar(10) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `idCiudad` int(2) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `email` varchar(40) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `ocupacion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblclientes`
--

INSERT INTO `tblclientes` (`codigoCliente`, `nombres`, `apellidos`, `fechaNacimiento`, `sexo`, `estadoCivil`, `cedula`, `idCiudad`, `direccion`, `email`, `celular`, `ocupacion`) VALUES
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '402-2001396-1', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmarcaproducto`
--

CREATE TABLE IF NOT EXISTS `tblmarcaproducto` (
`idMarcaProducto` int(11) NOT NULL,
  `Descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `tblmarcaproducto`
--

INSERT INTO `tblmarcaproducto` (`idMarcaProducto`, `Descripcion`) VALUES
(1, 'Nestle'),
(2, 'Induveca'),
(3, 'Mayita'),
(4, 'Nido'),
(5, 'Yocaju'),
(6, ''),
(7, ''),
(8, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproveedor`
--

CREATE TABLE IF NOT EXISTS `tblproveedor` (
  `codigoProveedor` int(10) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `estadoCivil` varchar(10) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `idCiudad` int(2) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `email` varchar(40) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `ocupacion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblproveedor`
--

INSERT INTO `tblproveedor` (`codigoProveedor`, `nombres`, `apellidos`, `fechaNacimiento`, `sexo`, `estadoCivil`, `cedula`, `idCiudad`, `direccion`, `email`, `celular`, `ocupacion`) VALUES
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '___-_______-_', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion'),
(27701788, 'Elizabeth', 'De La Cruz', '08/12/1990', 'Femenino', 'Soltero', '837-7448838-4', 2, 'Bandera #53', 'elizabethd@gmail.com', '(809)-883-7474', 'Lic en Bionalisis');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipousuario`
--

CREATE TABLE IF NOT EXISTS `tbltipousuario` (
`idTipoUsuario` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tbltipousuario`
--

INSERT INTO `tbltipousuario` (`idTipoUsuario`, `descripcion`) VALUES
(1, 'Administador'),
(2, 'Caja'),
(3, 'Digitador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblunidadmedida`
--

CREATE TABLE IF NOT EXISTS `tblunidadmedida` (
`idUnidadMedida` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tblunidadmedida`
--

INSERT INTO `tblunidadmedida` (`idUnidadMedida`, `Descripcion`) VALUES
(1, 'Libra'),
(2, 'Onza'),
(3, 'Galon'),
(4, 'Caja'),
(5, 'Paquete'),
(6, 'Otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE IF NOT EXISTS `tblusuario` (
  `nombreUsuario` varchar(30) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` varchar(12) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `pConfiguracion` tinyint(1) NOT NULL,
  `pBackup` tinyint(1) NOT NULL,
  `pNUsuario` tinyint(1) NOT NULL,
  `pCUsuario` tinyint(1) NOT NULL,
  `pSalirSistema` tinyint(1) NOT NULL,
  `pRVenta` tinyint(1) NOT NULL,
  `pCVenta` tinyint(1) NOT NULL,
  `pRCompra` tinyint(1) NOT NULL,
  `pCCompra` tinyint(1) NOT NULL,
  `pNArticulo` tinyint(1) NOT NULL,
  `pCArticulo` tinyint(1) NOT NULL,
  `pNCliente` tinyint(1) NOT NULL,
  `pCCliente` tinyint(1) NOT NULL,
  `pNProveedores` tinyint(1) NOT NULL,
  `pCProveedores` tinyint(1) NOT NULL,
  `pTablasAxu` tinyint(1) NOT NULL,
  `pReporteVenta` tinyint(1) NOT NULL,
  `pReporteCompras` tinyint(1) NOT NULL,
  `pRArticulo` tinyint(1) NOT NULL,
  `pRCliente` tinyint(1) NOT NULL,
  `pRProveedores` tinyint(1) NOT NULL,
  `pCajaDiaria` tinyint(1) NOT NULL,
  `pInformeVentaD` tinyint(1) NOT NULL,
  `pBusquedaFactura` tinyint(1) NOT NULL,
  `pListaArti` tinyint(1) NOT NULL,
  `pManualUsu` tinyint(1) NOT NULL,
  `pAcercaApli` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblusuario`
--

INSERT INTO `tblusuario` (`nombreUsuario`, `contrasena`, `tipoUsuario`, `nombre`, `apellidos`, `fechaNacimiento`, `telefono`, `email`, `pConfiguracion`, `pBackup`, `pNUsuario`, `pCUsuario`, `pSalirSistema`, `pRVenta`, `pCVenta`, `pRCompra`, `pCCompra`, `pNArticulo`, `pCArticulo`, `pNCliente`, `pCCliente`, `pNProveedores`, `pCProveedores`, `pTablasAxu`, `pReporteVenta`, `pReporteCompras`, `pRArticulo`, `pRCliente`, `pRProveedores`, `pCajaDiaria`, `pInformeVentaD`, `pBusquedaFactura`, `pListaArti`, `pManualUsu`, `pAcercaApli`) VALUES
('pabloalfredo', 'alfredo1234', 1, 'Pablo Alfredo', 'De La Cruz Medina', '13/051990', '(809)-961-8021', 'pdelacruzmedina@gmail.com', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproducto`
--

CREATE TABLE IF NOT EXISTS `tipoproducto` (
`idtip` int(11) NOT NULL,
  `descrip` varchar(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `tipoproducto`
--

INSERT INTO `tipoproducto` (`idtip`, `descrip`) VALUES
(1, 'bebidas'),
(2, 'lacteos'),
(3, 'limpieza'),
(4, 'tragos'),
(5, 'abarrotes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`idusuario` int(11) NOT NULL,
  `nick` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `tipousuario` varchar(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nick`, `password`, `tipousuario`) VALUES
(1, 'juan', 'juancho17', 'Administrador'),
(2, 'maria', 'peru', 'Invitado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
 ADD PRIMARY KEY (`num_bol`), ADD KEY `cod_cli` (`cod_cli`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`cod_cli`);

--
-- Indices de la tabla `detalleboleta`
--
ALTER TABLE `detalleboleta`
 ADD KEY `num_bol` (`num_bol`), ADD KEY `cod_pro` (`cod_pro`);

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
 ADD KEY `num_fac` (`num_fac`), ADD KEY `cod_pro` (`cod_pro`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
 ADD PRIMARY KEY (`num_fac`), ADD KEY `cod_cli` (`cod_cli`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
 ADD PRIMARY KEY (`cod_pro`,`descripcion`), ADD KEY `idtip` (`idtip`);

--
-- Indices de la tabla `tblcategoriaproducto`
--
ALTER TABLE `tblcategoriaproducto`
 ADD PRIMARY KEY (`idCategoriaProducto`);

--
-- Indices de la tabla `tblciudades`
--
ALTER TABLE `tblciudades`
 ADD PRIMARY KEY (`idCiudad`);

--
-- Indices de la tabla `tblmarcaproducto`
--
ALTER TABLE `tblmarcaproducto`
 ADD PRIMARY KEY (`idMarcaProducto`);

--
-- Indices de la tabla `tbltipousuario`
--
ALTER TABLE `tbltipousuario`
 ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indices de la tabla `tblunidadmedida`
--
ALTER TABLE `tblunidadmedida`
 ADD PRIMARY KEY (`idUnidadMedida`);

--
-- Indices de la tabla `tipoproducto`
--
ALTER TABLE `tipoproducto`
 ADD PRIMARY KEY (`idtip`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblcategoriaproducto`
--
ALTER TABLE `tblcategoriaproducto`
MODIFY `idCategoriaProducto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `tblciudades`
--
ALTER TABLE `tblciudades`
MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `tblmarcaproducto`
--
ALTER TABLE `tblmarcaproducto`
MODIFY `idMarcaProducto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `tbltipousuario`
--
ALTER TABLE `tbltipousuario`
MODIFY `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tblunidadmedida`
--
ALTER TABLE `tblunidadmedida`
MODIFY `idUnidadMedida` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `tipoproducto`
--
ALTER TABLE `tipoproducto`
MODIFY `idtip` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleboleta`
--
ALTER TABLE `detalleboleta`
ADD CONSTRAINT `detalleboleta_ibfk_1` FOREIGN KEY (`num_bol`) REFERENCES `boleta` (`num_bol`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `detalleboleta_ibfk_2` FOREIGN KEY (`cod_pro`) REFERENCES `producto` (`cod_pro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
ADD CONSTRAINT `detallefactura_ibfk_1` FOREIGN KEY (`num_fac`) REFERENCES `factura` (`num_fac`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `detallefactura_ibfk_2` FOREIGN KEY (`cod_pro`) REFERENCES `producto` (`cod_pro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`cod_cli`) REFERENCES `cliente` (`cod_cli`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idtip`) REFERENCES `tipoproducto` (`idtip`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

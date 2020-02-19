-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 18 fév. 2020 à 16:09
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `testevent`
--

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `idEvent` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `nbrplaces` int(11) NOT NULL,
  `localisation` varchar(50) NOT NULL,
  `hdebut` float NOT NULL,
  `hfin` float NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `event`
--

INSERT INTO `event` (`idEvent`, `idUser`, `titre`, `nbrplaces`, `localisation`, `hdebut`, `hfin`, `prix`) VALUES
(2, 7, 'chasse lapin', 25, 'ain drahem', 8, 18, 80);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateReservation` datetime NOT NULL,
  `quantite` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `seat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `payer` int(11) DEFAULT NULL,
  `nomReservation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `dateReservation`, `quantite`, `total`, `type`, `seat`, `payer`, `nomReservation`, `idUser`, `idEvent`) VALUES
(5, '2019-02-16 11:42:54', 2, 0, 'normale', 'A4', NULL, NULL, 0, 0),
(6, '2019-02-16 11:42:54', 1, 0, 'VIP', 'B1', 1, NULL, 0, 0),
(9, '2019-02-17 16:54:09', 2, 24, 'Normal', 'C3', 1, NULL, 0, 0),
(10, '2019-02-17 21:59:07', 2, 24, 'VIP', 'B6', NULL, 'sdsds', 0, 0),
(11, '2019-02-17 22:02:38', 1, 12, 'Noramle', 'A3', 1, 'Billionaire', 0, 0),
(12, '2019-02-17 23:44:52', 2, 24, 'VIP', 'A9', 1, 'Billionaire', 0, 0),
(13, '2019-03-20 01:43:12', 1, NULL, 'Guest', 'B', NULL, NULL, 0, 0),
(14, '2019-03-20 17:22:33', 1, NULL, 'Normale', 'A', NULL, NULL, 0, 0),
(15, '2019-03-20 17:23:30', 1, NULL, 'Guest', 'C', NULL, NULL, 0, 0),
(16, '2019-03-20 20:15:57', 1, NULL, 'Normale', 'A', NULL, NULL, 0, 0),
(17, '2019-03-21 22:20:19', 1, NULL, 'Normale', 'A', NULL, NULL, 0, 0),
(18, '2019-03-21 22:21:18', 1, NULL, 'Normale', 'A', NULL, NULL, 0, 0),
(19, '2019-03-22 12:18:43', 2, NULL, 'Guest', 'C', NULL, NULL, 0, 0),
(20, '2019-03-22 12:25:28', 2, NULL, 'Guest', 'C', NULL, NULL, 0, 0),
(21, '2019-03-22 12:26:01', 2, NULL, 'VIP', 'B', NULL, NULL, 0, 0),
(22, '2019-03-22 12:27:33', 2, NULL, 'VIP', 'B', NULL, NULL, 0, 0),
(23, '2019-03-22 12:44:31', 1, NULL, 'Normale', 'B', NULL, NULL, 0, 0),
(24, '2019-03-23 05:05:04', 2, NULL, 'VIP', 'B', NULL, NULL, 0, 0),
(25, '2019-03-24 06:30:13', 1, NULL, 'VIP', 'A', NULL, NULL, 0, 0),
(32, '2019-03-25 12:10:08', 3, NULL, 'VIP', 'A', NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE IF NOT EXISTS `sponsor` (
  `idSponsor` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `confirmation` tinyint(1) NOT NULL,
  `mailSponsor` varchar(60) NOT NULL,
  PRIMARY KEY (`idSponsor`),
  KEY `idEvent` (`idEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL,
  `role` tinyint(1) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `role`) VALUES
(7, 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `sponsor`
--
ALTER TABLE `sponsor`
  ADD CONSTRAINT `sponsor_ibfk_1` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

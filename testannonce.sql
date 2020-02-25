-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 18 fév. 2020 à 18:52
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `testannonce`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `idAnnonce` int(11) NOT NULL AUTO_INCREMENT,
  `idAnnonceRS` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `nomAnnonce` varchar(20) NOT NULL,
  `descriptionAnnonce` text NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  UNIQUE KEY `idAnnonceRS` (`idAnnonceRS`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`idAnnonce`, `idAnnonceRS`, `idUser`, `nomAnnonce`, `descriptionAnnonce`) VALUES
(8, 428, 2, 'ffffff', 'fffffffffffffffffffffff'),
(9, 65, 2, 'Annonce mech normale', 'Annonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normaleAnnonce mech normale'),
(12, 98, 3, 'http://localhost/', 'http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/http://localhost/'),
(14, 953, 1, 'oppaa', 'imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen imen ');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `idCommentaireRS` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idAnnonceRS` int(11) NOT NULL,
  `champCommentaire` text NOT NULL,
  `dateCommentaire` varchar(20) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`idCommentaire`),
  KEY `idUser` (`idUser`),
  KEY `commentaire_ibfk_1` (`idAnnonceRS`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`idCommentaire`, `idCommentaireRS`, `idUser`, `idAnnonceRS`, `champCommentaire`, `dateCommentaire`) VALUES
(2, 25, 2, 428, 'commentaire modifiéé', '2020-02-16 15:18:36');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`) VALUES
(1),
(2),
(3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`idAnnonceRS`) REFERENCES `annonce` (`idAnnonceRS`),
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

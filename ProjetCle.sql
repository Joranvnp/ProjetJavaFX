-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 02 mai 2023 à 08:17
-- Version du serveur :  10.5.6-MariaDB-1:10.5.6+maria~stretch
-- Version de PHP : 7.3.19-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ProjetCle`
--

-- --------------------------------------------------------

--
-- Structure de la table `cle`
--

CREATE TABLE `cle` (
  `numero` int(11) NOT NULL,
  `couleur` varchar(500) NOT NULL,
  `ouverture` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cle`
--

INSERT INTO `cle` (`numero`, `couleur`, `ouverture`) VALUES
(11, 'bleu', 'e211'),
(12, 'rouge', 'e204'),
(13, 'aa', 'aa'),
(14, 'aa', 'aa'),
(15, 'aer', 'ae'),
(16, 'aa', 'aa'),
(17, 'aa', 'aa'),
(18, 'aa', 'aa'),
(19, 'a', 'aa'),
(20, 'cle', 'cle'),
(21, 'zfe', 'zfe'),
(22, 'rouge', 'e204');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(500) NOT NULL,
  `password` varchar(500) NOT NULL,
  `droit` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `droit`) VALUES
(1, 'admin', '9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08', '1');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cle`
--
ALTER TABLE `cle`
  ADD PRIMARY KEY (`numero`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cle`
--
ALTER TABLE `cle`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

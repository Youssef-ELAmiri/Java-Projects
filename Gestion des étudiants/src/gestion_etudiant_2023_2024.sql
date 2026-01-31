-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 03 mai 2025 à 21:10
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_etudiant_2023/2024`
--

-- --------------------------------------------------------

--
-- Structure de la table `cp1`
--

CREATE TABLE `cp1` (
  `nbr` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `Probabilité_Statistiques` decimal(4,2) NOT NULL,
  `Analyse` decimal(4,2) NOT NULL,
  `Electronique_A_N` decimal(4,2) NOT NULL,
  `Algebre` decimal(4,2) NOT NULL,
  `Espagne` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cp1`
--

INSERT INTO `cp1` (`nbr`, `nom`, `date`, `email`, `Probabilité_Statistiques`, `Analyse`, `Electronique_A_N`, `Algebre`, `Espagne`) VALUES
(1, 'EL-AMIRI YOUSSEF', '2004-09-04', 'youssef.elamiri@usmba.ac.ma', 11.00, 10.00, 15.00, 11.00, 12.00),
(2, 'Ahmed_Rachidi', '2004-01-11', 'Ahmed.Rachidi@usmba.ac.ma', 14.00, 11.00, 9.00, 16.00, 13.00),
(4, 'Mohamed_Alami', '2004-11-25', 'Mohamed.Alami@gmail.com', 15.00, 0.00, 12.00, 11.00, 0.00);

-- --------------------------------------------------------

--
-- Structure de la table `cp2`
--

CREATE TABLE `cp2` (
  `nbr` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `Analyse` int(11) NOT NULL,
  `Thermodynamique` int(11) NOT NULL,
  `Chimie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cp2`
--

INSERT INTO `cp2` (`nbr`, `nom`, `date`, `email`, `Analyse`, `Thermodynamique`, `Chimie`) VALUES
(2, 'Kamal_benabdellah', '2003-05-20', 'Kamal_benabdellah@hotmail.fr', 10, 15, 9),
(12, 'Khadija_Benani', '2003-09-14', 'Khadija.Benani@usmba.ac.ma', 15, 13, 14);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cp1`
--
ALTER TABLE `cp1`
  ADD PRIMARY KEY (`nbr`);

--
-- Index pour la table `cp2`
--
ALTER TABLE `cp2`
  ADD PRIMARY KEY (`nbr`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

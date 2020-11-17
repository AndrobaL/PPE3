-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : mar. 17 nov. 2020 à 13:32
-- Version du serveur :  5.7.32
-- Version de PHP : 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ppe`
--

-- --------------------------------------------------------

--
-- Structure de la table `Agents`
--

CREATE TABLE `Agents` (
  `id_agent` int(11) NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `firstname` varchar(50) COLLATE utf8_bin NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `profile` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `id_profile` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `Agents`
--

INSERT INTO `Agents` (`id_agent`, `password`, `name`, `firstname`, `mail`, `phone_number`, `profile`, `id_profile`) VALUES
(1, 'toto', 'admin', 'admin', 'admin', 612121212, '', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Clients`
--

CREATE TABLE `Clients` (
  `id_client` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `Clients`
--

INSERT INTO `Clients` (`id_client`, `name`, `mail`, `phone_number`) VALUES
(200, 'test858', 'email de test', 1095),
(226, 'test684', 'email de test', 1403),
(227, 'test229', 'email de test', 1082),
(228, 'test765', 'email de test', 1213),
(229, 'Client name', 'Mail', 0),
(230, 'test1248', 'email de test', 1854),
(231, 'test1673', 'email de test', 1126),
(232, 'test116', 'email de test', 1872),
(233, 'test894', 'email de test', 1664),
(234, 'test1187', 'email de test', 1616),
(235, 'test896', 'email de test', 1835),
(236, 'test1195', 'email de test', 1905),
(237, 'test1603', 'email de test', 1659),
(238, 'test1976', 'email de test', 1886),
(239, 'test852', 'email de test', 1357),
(240, 'test1781', 'email de test', 1603);

-- --------------------------------------------------------

--
-- Structure de la table `Commande`
--

CREATE TABLE `Commande` (
  `id_commande` int(11) NOT NULL,
  `transaction` datetime DEFAULT NULL,
  `state` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `id_agent` int(11) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `Contenir`
--

CREATE TABLE `Contenir` (
  `id_produit` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `size` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `id_categorie`
--

CREATE TABLE `id_categorie` (
  `id_categorie` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `id_categorie`
--

INSERT INTO `id_categorie` (`id_categorie`, `name`) VALUES
(0, 'Bukkit'),
(1, 'Spigot');

-- --------------------------------------------------------

--
-- Structure de la table `Produits`
--

CREATE TABLE `Produits` (
  `id_produit` int(11) NOT NULL,
  `name` varchar(25) COLLATE utf8_bin NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `picture` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `popularity` decimal(2,1) DEFAULT NULL,
  `id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `Produits`
--

INSERT INTO `Produits` (`id_produit`, `name`, `price`, `stock`, `picture`, `popularity`, `id_categorie`) VALUES
(1, 'TestPlugin', '125.00', 2, 'no', '5.0', 0);

-- --------------------------------------------------------

--
-- Structure de la table `Profiles`
--

CREATE TABLE `Profiles` (
  `id_profile` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `perm` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `Profiles`
--

INSERT INTO `Profiles` (`id_profile`, `name`, `perm`) VALUES
(1, 'admin', 1),
(2, 'user', 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Agents`
--
ALTER TABLE `Agents`
  ADD PRIMARY KEY (`id_agent`),
  ADD KEY `id_profile` (`id_profile`);

--
-- Index pour la table `Clients`
--
ALTER TABLE `Clients`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `Commande`
--
ALTER TABLE `Commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `id_agent` (`id_agent`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `Contenir`
--
ALTER TABLE `Contenir`
  ADD PRIMARY KEY (`id_produit`,`id_commande`),
  ADD KEY `id_commande` (`id_commande`);

--
-- Index pour la table `id_categorie`
--
ALTER TABLE `id_categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `Produits`
--
ALTER TABLE `Produits`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `uuid` (`id_categorie`);

--
-- Index pour la table `Profiles`
--
ALTER TABLE `Profiles`
  ADD PRIMARY KEY (`id_profile`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Agents`
--
ALTER TABLE `Agents`
  MODIFY `id_agent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `Clients`
--
ALTER TABLE `Clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=241;

--
-- AUTO_INCREMENT pour la table `Commande`
--
ALTER TABLE `Commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `id_categorie`
--
ALTER TABLE `id_categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Produits`
--
ALTER TABLE `Produits`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `Profiles`
--
ALTER TABLE `Profiles`
  MODIFY `id_profile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Agents`
--
ALTER TABLE `Agents`
  ADD CONSTRAINT `Agents_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `Profiles` (`id_profile`);

--
-- Contraintes pour la table `Commande`
--
ALTER TABLE `Commande`
  ADD CONSTRAINT `Commande_ibfk_1` FOREIGN KEY (`id_agent`) REFERENCES `Agents` (`id_agent`),
  ADD CONSTRAINT `Commande_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `Clients` (`id_client`);

--
-- Contraintes pour la table `Contenir`
--
ALTER TABLE `Contenir`
  ADD CONSTRAINT `Contenir_ibfk_1` FOREIGN KEY (`id_produit`) REFERENCES `Produits` (`id_produit`),
  ADD CONSTRAINT `Contenir_ibfk_2` FOREIGN KEY (`id_commande`) REFERENCES `Commande` (`id_commande`);

--
-- Contraintes pour la table `Produits`
--
ALTER TABLE `Produits`
  ADD CONSTRAINT `Produits_ibfk_1` FOREIGN KEY (`id_categorie`) REFERENCES `id_categorie` (`id_categorie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

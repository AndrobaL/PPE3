
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

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


INSERT INTO `Agents` (`id_agent`, `password`, `name`, `firstname`, `mail`, `phone_number`, `profile`, `id_profile`) VALUES
(1, 'toto', 'admin', 'admin', 'admin', 612121212, '', 1);

CREATE TABLE `Clients` (
  `id_client` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `Clients` (`id_client`, `name`, `mail`, `phone_number`) VALUES
(155, 'test972', 'email de test', 1699),
(160, 'test1617', 'email de test', 1244),
(162, 'test1322', 'email de test', 1331),
(169, 'test1852', 'email de test', 1162),
(170, 'test1367', 'email de test', 1844),
(193, 'test1921', 'email de test', 1762),
(195, 'test1171', 'email de test', 1965),
(196, 'test1822', 'email de test', 1035),
(197, 'test168', 'email de test', 1508),
(198, 'test1492', 'email de test', 1561),
(199, 'test1189', 'email de test', 1173),
(200, 'test858', 'email de test', 1095),
(201, 'test1504', 'email de test', 1564),
(202, 'test1436', 'email de test', 1892),
(203, 'test128', 'email de test', 1877),
(204, 'test1053', 'email de test', 1932),
(205, 'test339', 'email de test', 1314),
(206, 'test1250', 'email de test', 1644),
(207, 'test1170', 'email de test', 1714),
(208, 'test1260', 'email de test', 1774),
(209, 'test147', 'email de test', 1044),
(210, 'test815', 'email de test', 1359),
(211, 'test623', 'email de test', 1716),
(212, 'test658', 'email de test', 1787),
(213, 'test276', 'email de test', 1624),
(214, 'test213', 'email de test', 1140),
(215, 'test1125', 'email de test', 1048),
(216, 'test1655', 'email de test', 1693),
(217, 'test1446', 'email de test', 1976),
(218, 'test1546', 'email de test', 1126),
(219, 'test202', 'email de test', 1301);


CREATE TABLE `Commande` (
  `id_commande` int(11) NOT NULL,
  `transaction` datetime DEFAULT NULL,
  `state` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `id_agent` int(11) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `Contenir` (
  `id_produit` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `size` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `id_categorie` (
  `id_categorie` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `id_categorie` (`id_categorie`, `name`) VALUES
(0, 'Bukkit'),
(1, 'Spigot');


CREATE TABLE `Produits` (
  `id_produit` int(11) NOT NULL,
  `name` varchar(25) COLLATE utf8_bin NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `picture` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `popularity` decimal(2,1) DEFAULT NULL,
  `id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `Produits` (`id_produit`, `name`, `price`, `stock`, `picture`, `popularity`, `id_categorie`) VALUES
(1, 'TestPlugin', '125.00', 2, 'no', '5.0', 0);

CREATE TABLE `Profiles` (
  `id_profile` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `perm` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `Profiles` (`id_profile`, `name`, `perm`) VALUES
(1, 'admin', 1),
(2, 'user', 0);

ALTER TABLE `Agents`
  ADD PRIMARY KEY (`id_agent`),
  ADD KEY `id_profile` (`id_profile`);

ALTER TABLE `Clients`
  ADD PRIMARY KEY (`id_client`);

ALTER TABLE `Commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `id_agent` (`id_agent`),
  ADD KEY `id_client` (`id_client`);

ALTER TABLE `Contenir`
  ADD PRIMARY KEY (`id_produit`,`id_commande`),
  ADD KEY `id_commande` (`id_commande`);

ALTER TABLE `id_categorie`
  ADD PRIMARY KEY (`id_categorie`);

ALTER TABLE `Produits`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `uuid` (`id_categorie`);

ALTER TABLE `Profiles`
  ADD PRIMARY KEY (`id_profile`);

ALTER TABLE `Agents`
  MODIFY `id_agent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `Clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220;

ALTER TABLE `Commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `id_categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `Produits`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `Profiles`
  MODIFY `id_profile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `Agents`
  ADD CONSTRAINT `Agents_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `Profiles` (`id_profile`);

ALTER TABLE `Commande`
  ADD CONSTRAINT `Commande_ibfk_1` FOREIGN KEY (`id_agent`) REFERENCES `Agents` (`id_agent`),
  ADD CONSTRAINT `Commande_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `Clients` (`id_client`);

ALTER TABLE `Contenir`
  ADD CONSTRAINT `Contenir_ibfk_1` FOREIGN KEY (`id_produit`) REFERENCES `Produits` (`id_produit`),
  ADD CONSTRAINT `Contenir_ibfk_2` FOREIGN KEY (`id_commande`) REFERENCES `Commande` (`id_commande`);

ALTER TABLE `Produits`
  ADD CONSTRAINT `Produits_ibfk_1` FOREIGN KEY (`id_categorie`) REFERENCES `id_categorie` (`id_categorie`);
COMMIT;

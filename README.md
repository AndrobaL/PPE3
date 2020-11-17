# Projet PPE3

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

### C'est quoi ce projet ? 🔣
C'est une projet basic qui à l'aider du language MYSQL et Java permet de gérer une structure comportant des ventes, factures, comptes clients/admins ainsi que des produits de différentes catégorie (dans notre cas des plugins Bukkit/Spigot) avec quelques fonctiones jackie tuning comme du RGB ou autre.

Ce projet a été créé pour le cours de BTS SIO 2

### Ca permet quoi ?

  * Gérer des produits
  * Gérer des ventes
  * Gérer des factures
  * Gérer des comptes client/admin

### A faire
Presque terminées, les opérations suivantes doivent être effectuées:
  - ???

### Credits
* [Killyan](https://github.com/AndrobaL) - Concepteur du projet

### Installation ✏️
```sh
mkdir PPE3
cd /PPE3
git clone -b https://github.com/AndrobaL/PPE3
```

Pour que le logiciel soit fonctionnel, il vous faut installer MySQL et PHPMyAdmin, il est possible de les installer grâce à WAMP (Windows), pour les utilisateurs de Linux voici un tutoriel: http://elisabeth.pointal.org/doc/code/server/lamp/phpmyadmin

Il vous faudra ensuite installer la base de données du logiciel:

### Connectez vous sur PHPMyAdmin
Allez sur la page Importer
Cliquez sur choisir un fichier (cela vous ouvre un Explorateur de fichiers)
Rendez-vous dans le dossier PPE3 que nous avons fait auparavant
Séléctionnez le fichier PPE3.sql
Cliquez sur le boutton "Go"
Ensuite, ouvrez le projet sur votre IDE, et maintenant, modifiez les informations de connexion au serveur MySQL (DataAccessObject.java), vous devrez changer:

L'IP par celle de votre serveur
Le port par celui que vous utilisez (si vous avez modifié le port de MySQL)
Les identifiants de connexion (username:password)

###### IMPORT le projet avec MAVEN
###### BUILD PROJECT🌀

### Documentation 📝

Développeur: https://docs.google.com/document/d/1fIwXDGY6eS4XxvsA6D5F1b3hMNemuo1o452MkgsSiaw/edit?usp=sharing

Utilisateur: 

 - Documentation - https://github.com/AndrobaL/PPE3/edit/master/README.md

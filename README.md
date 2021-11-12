# Test technique pour le poste de développeur backend - Stackinsat

### Vendredi 12 novembre 2021 de 17h00 à 18h30

### Réponses aux questions de la première partie

Retourner tous les éléments book
* //book 

Retourner tous les éléments title ayant comme parent un élément book avec un attribut type égal à roman 
* //book[@type=’roman’]/title 

Retourner le nombre d'éléments book ayant un attribut type égal à bd
* //book[@type=’bd’]

Que renvoie la requête XPath suivante :  /library/library/ancestor-or-self::library
* cette requête renvoie tous les éléments library qui sont des ancêtres du nœuds courant (élément library racine) et le nœud library courant lui-même (nœud library interne).

### Projet web correspondant à la deuxième partie du test technique
* projet implémenté sous la forme d'une API REST avec le framework spring boot
* la base de données choisie est une base de donnée embarquée H2
* Gestion des utilisateurs et des comptes qui leur seraient associés
* Les utilisateurs ont une contrainte d'âge qui nécessitent qu'ils aient moins de 150 ans pour être enregistrés
* Couche de sécurité avec un token jwt pour la connexion et l'accès aux différent points d'accès en fonction des rôles





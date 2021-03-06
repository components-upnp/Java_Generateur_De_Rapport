# Java_Report_Generator
Composant UPnP qui reçoit les résultats d'un vote et en affiche le rapport

<strong>Descritpion : </strong>

Ce composant est un programme JAVA avec une interface SWING et peut être utilisé pour générer des rapports ou graphiques,
à des questionnaires par exemple, depuis un fichier XML.

<strong>Lancement de l'application : </strong>

Pour lancer l'application il suffit de lancer le .jar se situant dans le répertoire build.
Voici un exemple d'exécution de l'application:

![alt tag](https://github.com/components-upnp/Java_Report_Generator/blob/master/CaptureGenerateurRapport.PNG)

Sur cette image on peut observer un exemple de réponse à une question, pour laquelle trois réponses possibles étaient proposées
et trois personnes ont répondu, deux pour la réponse 1 et une pour la 2.

<strong>Spécification UPnP : </strong>

Ce composant présente le service ReportGenerationService qui offre la méthode : 

  1) setVotes(String v) : où v est le fichier XML contenant les données, permet ensuite d'afficher le rapport.
  
Voici le schéma représentant le composant:

![alt tag](https://github.com/components-upnp/Java_Report_Generator/blob/master/ReportGenerator.png)

<strong>Maintenance : </strong>

C'est un projet Maven. Effectuer les modifications à faire,
ajouter une configuration d'éxecution Maven avec la phase "package" pour exporter en .jar
Executer cette commande.

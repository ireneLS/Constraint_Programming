# Constraint_Programming
Projet du module de programmation par contraintes de M1 ATAL/ALMA.
L'affiche du texte est pourrie sur github, donc pour + de lisibilité : soit vous l'importez, soit vous éditez le fichier sur github.

CONSIGNES POUR IMPORT/EXPORT :
J'ai mis les fichiers .project et .metadata pour que ça soit simple d'importer le projet dans eclipse. Vous avez juste à faire "Import..>Existing Project Into Workspace" et décocher "copy projects into workspace".

CONSIGNES POUR COMMIT/PUSH :
Pour commit un projet sur github : 
 - git add src/                              // Ca signale que vous avez avez modifier les fichiers dans src et que vous voulez les commit. 
 - git commit -m "Votre commentaire          // Ca commit sur votre version local. 
 - git push                                  // Ca commit sur internet. 
Et normalement c'est bon, vous avez juste à faire ça

CONSIGNES POUR PULL :
/!\ A faire dès le début, quand vous retravaillez sur le projet !!!
 - git pull          //...
Si vous avez un problème de fusion, vous avez plusieurs solutions :
 - git stash         // Ca annule tout s'que vous avez fait en local, du coup le pull est obligé de passé après
                  // Mon conseil : copier vos changements dans un dossier à part, git stash, git pull, coller vos changements, git add src/, git commit, git push.
 - Et les autres solutions, j'les connais pas... :D

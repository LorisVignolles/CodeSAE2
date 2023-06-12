#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void *a, const void *b) {
  const char *s1 = *(const char **)a;
  const char *s2 = *(const char **)b;
  const char *ordre = "ctexamplsrd";
  // Trouver la longueur minimale entre les deux mots
  int len = strlen(s1);
  if (strlen(s2) < len) {
    len = strlen(s2);
  }

  // Comparer les caractères lettre par lettre selon l'ordre donné
  for (int i = 0; i < len; i++) {
    char c1 = s1[i];
    char c2 = s2[i];
    int idx1 = -1, idx2 = -1;

    for (int j = 0; j < strlen(ordre); j++) {
      if (ordre[j] == c1) {
        idx1 = j;
      }
      if (ordre[j] == c2) {
        idx2 = j;
      }
    }

    if (idx1 != -1 && idx2 != -1) {
      if (idx1 != idx2) {
        return idx1 - idx2;
      }
    } else {
      if (idx1 == -1) {
        return 1; // Le mot s1 contient une lettre non présente dans l'ordre
      } else if (idx2 == -1) {
        return -1; // Le mot s2 contient une lettre non présente dans l'ordre
      }
    }
  }

  return strlen(s1) - strlen(s2);
}

void sortWords(char *texte, char *ordre) {
  char *mots[100]; // Tableau de pointeurs vers les mots
  int i = 0;

  // Découper le texte en mots et les stocker dans le tableau
  char *token = strtok(texte, " ");
  while (token != NULL) {
    mots[i++] = token;
    token = strtok(NULL, " ");
  }

  // Trier les mots selon l'ordre spécifié
  qsort(mots, i, sizeof(char *), compare);

  // Afficher les mots triés
  for (int j = 0; j < i; j++) {
    printf("%s ", mots[j]);
  }
  printf("\n");
}

int main() {
  char texte[] = "exemple de texte a classer";
  char ordre[] = {'c', 't', 'e', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd'};

  sortWords(texte, ordre);

  return 0;
}

/**
 * @file   aufgabe2-pointer.c
 * @brief  Aufgabe2 - Pointermanipulationen
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// Falls notwendig erweitern Sie die Liste der includes

/**
   @brief Aufgabe2a: Scannen durch einen String
   @param [in] char* input
   @return char*

Input ist ein String der aus alphanumerischen Zeichen besteht die
durch :: getrennt sein koennen. Als Beispiele betrachte man

<p>

<ul>
  <li> "Ha::ll::o"
  <li> "47::11"
</ul>

Ihre Aufgabe ist es eine Funktion zu schreiben die den 
laengsten suffix (Endung) liefert der kein :: enthaelt.
Laengste Endungen fuer unsere Beispiele:
<ul>
  <li> "o"
  <li> "11" 
</ul>

<p>

Input ist der String (char pointer), das Ergebnis soll als
return Wert geliefert werden, welcher ein Zeiger auf den
Anfang der laengsten Endung ohne :: ist.

 */

char* extract(char* input) {

    int counter = 0;
    while (input[counter] != '\0') {
        if (input[counter - 1] == ':' && input[counter] != ':') {
            input = &input[counter];
            counter = 0;
        }
        counter++;
    }

    return input; // Ihre Loesung
}

/**
   @brief Aufgabe2b: Variation von 2a
   @param [in] char* input
   @param [out] char** output

Das Ergebnis soll hier nicht als return Wert geliefert werden.
Anstatt wird ein pointer auf einen pointer verwendet.
Wieso reicht ein pointer nicht aus?
 */

void extract2(char* input, char** output) {
    int counter = 0;
    while (input[counter] != '\0') {
        if (input[counter - 1] == ':' && input[counter] != ':') {
            *output = &input[counter];
            counter = 0;
        }
        counter++;
    }
}

/**
   @brief Aufgabe2c: Weitere Variation von Scannen
   @param [in] char* input
   @return int

Input ist ein String der aus einer Liste von alphanumerischen Woertern
die durch Leerzeichen (white-space) getrennt sind.
Ihre Aufgabe ist es eine Funktion zu schreiben, die die Anzahl der
Woerter zaehlt.
<p>
Beispiel:  "Ha ll o 5"
<p>
Soll liefern 4
 */

int count(char* input) {
    int solution = 0;
    int counter = 0;
    while (input[counter] != '\0') {
        if (input[counter] == ' ') {
            solution = solution + 1;
        }
        if (solution != 0 && input[counter + 1] == '\0') {
            solution = solution + 1;
        }
        counter++;
    }
    return solution; // Muss durch Ihre Loesung ersetzt werden
}

/**
   @brief Aufgabe2d: Aufsammeln von Woertern. Erweiterung von Aufgabe2c.
   @param [in] char* line
   @param [in] int maxwords
   @param [out] char* words[]
   @return int Anzahl aufgesammelter Woerter

Gegeben (als Input) ist ein String der aus einer Liste von alphanumerischen 
Woertern die durch Leerzeichen (white-space) getrennt sind.
Ihre Aufgabe ist es die Woerter in einem Array von Strings aufzusammeln.
Das Array von Strings words wird pre-allokiert mit fester Groesse (maxwords).
Die Anzahl der aufgesammelten Woerter wird als return Wert zurueck
geliefert.

 */

int breakIntoWords(char *line, int maxwords, char *words[]) {
    int outerCounter = 0;
    int innerCounter = 0;
    int lineCounter = 0;

    words = *malloc();
    
    while(line[outerCounter] != '\0' && outerCounter < maxwords){
        innerCounter = innerCounter + 1;
        if(line[outerCounter] == ' '){
            words[outerCounter] = "outercounter";
            innerCounter = 0;
            lineCounter = lineCounter + 1;
            line = &line[outerCounter];
            outerCounter = 0;
        }
        if(line[outerCounter+1] == '\0' & lineCounter != 0){
            lineCounter = lineCounter + 1;
        }
        outerCounter = outerCounter + 1;
    }
    
    return lineCounter; // Ihre Loesung
}

int main() {
    // Ihre Testroutinen
    char hallo[50] = "HA::LL::OO::32::567::fdfeferrgw";
    char* ptr = hallo;
    printf("Das laengste Suffix ist: %s", extract(ptr));

    char hallo2[50] = "Ha ll oo ll oo ll oo";
    char* ptr2 = hallo2;
    printf("\nEs sind %d Woerter.\n\n\n", count(ptr2));
    
    int i;
    char line[] = "this is a test";
    int nwords;
    char* words[10];

    nwords = breakIntoWords(line, 10, words);
    printf("%d", nwords);
    for (i = 0; i < nwords; i++) {
        printf("%s", words[i]);
    }
    printf("%s\n", words[i]);
}
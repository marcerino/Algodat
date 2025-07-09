Anna Tamina von Stietcorn, Emanuel Reinking Florian,  Marcel Giller
___
(a) Definieren Sie geeignete Teilprobleme und geben Sie eine geeignete Rekursion
an. Erklären Sie Ihre Rekursion in einem Satz.
1. Teilproblem: ist die Zeichenfolge ein Wort
2. Teilproblem: Sind alle Zeichen in Wörtern. 
Sei b ein gesamter String, dann ist b0 ... bk ein Teil string. 0

Boolsche Tabelle:
x Achse: länge des Teilstrings
y Achse Start des Nächsten Wortes. 

Idee. 0,0 ist True, dann fragen wir ob der String startend von y position ein wort ist, sollte der String ab der y Position ein wort sein, überprüfen wir, ob der Substring von Index 0 bis y (also ohne Wort) Valide ist (also Teilproblem 2 erfüllt) wenn ja dann True sonst False. Sollte ein Eintrag True Sein so sind alle seine niedriger liegenden Einträge True. 

Gedanklich überprüfen wir ob wir ein Wort haben und wenn ja, ob alle Zeichen davor auch in Wörter eingeteilt werden Können

(b) Geben Sie Pseudocode für Ihren Algorithmus an. 
```
def istvalidersatz(b:String): Boolean = 
	mytable = Table(b.length,b.length)
	for b' in range(b.lenth) do
		for y in range(b') do
			if b' = 0 then
				mytable(0,0) == True
			else if y == 0 then
				if dict(b.substring(y,b')) == True && myTable(b'-(b'-y),b'-(b'-y) == True
					myTable(b',y) = True
					else myTable(b',y) = False
			else 
				if myTable(y-1,b') == True then myTable(b',y) = True
				else if dict(b.substring(y,b')) == True && myTable(b'-(b'-y),b'-(b'-y)
					myTable(y,b') = True
				else myTable(y,b') = False

	if myTable(b.length,b.length) == True return True
```

(c) Analysieren Sie die Laufzeit und Speicherplatzbedarf Ihres Algorithmus unter der Annahme, dass ein Aufruf von dict konstante Zeit benötigt.

Speicherplatz: 
	Der Algorithmus bedarf einen diskreten Speicherplatzbedarf von $O(b^2)$ für die Tabelle, es fallen keine weiteren Speicherplätze an.
Laufzeit:
	Teilaufrufe: In jeder Zelle wird 1 mal dict() aufgerufen $O(1)$, außerdem wird überprüft ob der vorgänger legitim ist $O(1)$ oder wir in der ersten Zeile sind $O(1)$ $\to 2*O(1) = O(1)$ 
	Wie oft werden Zellen Aufgerufen? Es gibt b' spalten und in jeder Spalte gibt es b' aufrufe (Kleiner Gauß)
	$$
\sum_{i=1}^{b} b_{i} = \frac{b*(b+1)}{2} = O\left( \frac{b^2}{2} \right) =O(b^{2}) 
$$
(d) beschreiben Sie in einem Satz, wie man eine gültige Wortfolge finden kann,
falls sie existiert.
Man speichere zusätzlich zu T auch das Wort welches gefunden wurde, wobei am ende das Wort genommen wird und Rückwärts immer die Validen Wörter gefunden werden.
___
**Aufgabe 3**:
Fakten: Die senke hat $Outdeg(v)= 0$ Bedeutet in der Adjazenzmatrix hat in der zugehörigen Zeile nur 0. Alle  anderen haben auf diese Zeile Zeigend immer 1.
Algorithmus:
Gehe in die erste Zeile. Solange 0 gehe ein Element nach Rechts, wenn 1 gehe einen nach unten. 
Wdh, bis in einer Zeile nur 0 en gefunden Werden. überprüfe, dann ob in der Spalte gehörog zu diesem Knoten nur 1 existiert (ausgenommen die Zeile selber), wenn ja, dann gefunden. Sollte die Spalte nicht nur aus 1 bestehen -> globale senke nicht existent. Sollte die letzte Zeile durchlaufen werden und diese nicht die Nullzeile sein -> nicht existent. Erreichen wir die Letzte Spalte ohne die Nullzeile zu finden -> nicht existent. 

Korrektheit:
*Fallunterscheidung*:
*Fall 1*: es Existiert eine globale senke:
Im Fall, dass es eine globale Senke gibt existiert genau eine Nullzeile. und alle anderen Zeilen haben in der zur senke gehörigen Spalte eine 1. 
Starten wir an erster Stelle so haben wir eine 0 oder 1. bei null gehen wir in die nächste Spalte, bei 1 in die nächste Zeile. Befinden wir uns in der Spalte die zur 0 Zeile gehört, so gehen wir solange nach unten bis wir in der Nullzeile ankommen. (Ist gegeben durch die oben genannten fakten). Sollten wir nicht in der zur globalen senke gehörigen Spalte sein, dann existiert mindestens 2 nullen (da nur ein Knoten $deg_{out}(v)=|V|-1$) in dieser Spalte. Somit kommen wir immer zur Nullzeile. Das überprüfen ob es in der Korrespondierenden Zeile immer eine 1 gibt stellt sicher dass alle Knoten auf diese Zeigen.
Fall 1.1 es existiert eine Nullzeile welche keine globale Senke ist -> es gibt keine globale senke, da jeder Knoten auf die senke Zeigen müsste, was diese nicht tut.
Fall 2:  Es existiert keine globale senke.
Fall 2.1: alle Zeigen auf ein element aber dieses zeigt auf andere. 
In diesem Fall kommen wir in die Korrospondierende Zeile, wie bei der Senke. da alle auf dies zeigen aber durch eine 1 in dieser zeile in die nächste Zeile und dann nach unten, wo überprüft und durch die Überprüfung sicher ist, dass keine 0 Zeile existiert, da wir nur in einer nullzeile stecken bleiben können.
Fall 2.2 Sonst
Wir erreichen Entweder Die unterste Zeile oder die rechteste Spalte zuerst. Unterste Zeile analog zu fall 2.1. Rechteste Zeile (außerhalb der Nullzeile): Alle elemente Zeigen auf die senke, somit muss es eine spalte geben die zur nullzeile führt. Sind wir in der letzten Spalte angekommen so haben alle vorherigen Spalten min eine 0 und führten nicht zur nulltzeile .Ist die Letzte Spalte erreicht worden ohne das die Nullzeile gefunden wurde, Zeigen nicht alle Elemente auf das gleiche element (ausgenommen die Senke). 

Laufzeit:
Worst Case ist dass die unterste Zeile die 0 Zeile ist und wir erst mit der letzten Spalte in diese geraten. Jede Zeile / Spalte hat $|V|$ Elemente. Wir überprüfen dann einmal die zeile komplett und danach die dazugehörige spalte.
$\implies |V|+ |V|+|V|=3*|V|=O(|V|)$
Strings
Spezielle Datenstrukturen 
Grundlegende Definitionen
	Spezielle Arten von Datentypen mit speziellen Algorithmen 
	Wichtig für bioinformstiker
Grundlagen.
	Benötigt ein Alphabet **Sigma** ist eine endliche nicht leere Menge.. die Elemente heißen Zeichen.

Bsp: 0,1 oder lateinische Alphabet oder Unicode
Ein **String** ist eine endliche Folge von Zeichen aus Sigma, der leere String ist Epsilon. Epsilon ist in jedem Alphabet

Die Länge einer Zeichenkette ist die Anzahl der Zeichen

Trie ist ein Verwurzelter mehrwegiger Baum der zur Implementation geordneter Wörterbücher für Zeichenketten über einem Alühabet Sigma zu verwenden.
Strucktur: 
	Jeder innere Knoten  hat zwoischen 0 und |sigma| kinder
Komprimierte Tries:
	Außer der Wurzel darf jeder Knoten 
___
Implementieren als ADT Geordnetes Wörterbuch, Falls schlüsselmenge Zeichenketten sind.
Was ist jetzt besonders?
	Die Schlüssel (die zeichenketten ) können beliebiglang sein. 
	Folglich ist es Unrealistisch, vergleiche in konstanter Zeit durchzuführen.
Was ist die Ordnung der Zeichenketten?
	Lexikographische Ordnung. oder Lege Ordnung für das Alphabet Fest. 
	Dann vergleich, gehe den String durch bis zum ersten unterschiedlichen zeichen. Dann nach Aphabethische Reihenfolge. Sollte ein Wort eher aufhören ist dieses das kleinere 
___
Lösung
	Die Struktur der Strings nutzen um eine Einfachere Datenstruktur zu finden.
# Tries Definition 
Ein Trie ist Datenstrucktur für geordnete Wörterbücher bei schlüsselmenge aus Zeichenketten besteht.
Trie kommt aus retrieval. 
Sei Sigma ein alphabet und S eine menge an schlüssel. Alphabet [A,...,Z] S = {hand, Hund,Hemd,Hell,Heu}

- Ein Trie ist ein gewurzelter Baum
- Jeder Knoten entspricht einem Anfangsstück (Präfix) von einer oder mehreren Zeichenketten in S. Die Wurzel entspricht dem Leeren Anfangsstück epsilon
- Die Blätter entsprechen den Zeichenketten in S.
- Kidner eines Knoten U sind all diejenigen Anfangsstücke die man erhält wenn man U um ein Knoten erweitert. Also Epsilon - H - Hu - Hun - Hund  ist eine Kette aus dem Trie des gegebenen Schlüsselmenge S Geordnet in der Schlüsselmenge der angehängten zeichen.
- Die Werte werden in die Blätter für die zugehörigen Schlüssel gespeichert 
___
Mit einem Trie lassen sich die Operationen des adt geordneten Wörterbuch direkt implementieren.
Laufzeit ist anshl der besuchenden knoten entspricht der Gesamtlänge der involvierten Zeichenketten
Zeit um von knoten zu korrektes Kind zu kommen ist höchstens Betrag Sigma
Gesamtlaufzeit  o Betrag Sigma mal gesamt Länge individueller Zeichenketten
Wenn ein Schlüssel von einem anderen Schlüssel als Präfix hat, dann
Lösung einführen eines besonderen Zeichen, welches das Ende eines Wortes  düsignalisiert und kleiner als alle anderen ist also 
Hemd€, Hund§ hell§
Lösung füge zusätzliches Zeichen ein und setzte dieses ans Ende aller Schlüssel.
Die anfangsstücke in der Kette werden nicht expliziet gespeichert Mann kann sie ableiten aus der Beschriftung der Kanten.
Komprimierter Trie, ist die Trie strucktur, wobei nur die Blätter erhalten bleiben wo Verzweigungen zu finden sind.
___
## String-Search 
Eingabe: T, P wobei T der gesamt Text ist und P das Muster(Pattern) beide elememte von Sigma
t hat länge n
p hat länge k
___
Beispiel: T = {Beispiel Beispiel} 
P = eis
stringsearch(t,p) = 2 da eis ab Stelle "2" beginnt (index startet bei normalerweise mit  0 beim programmiern)

````
Algorithmus 1 ("naiv"):
for := 1 to n-k+1 
	j = 1
	while j<= k und (Pj == ti-1+j)
		j++
	if j== k+1 then return match
return match nicht gefunden 
O(n*k)
Ideal wäre  O(n+k)

```

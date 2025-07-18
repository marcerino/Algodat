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
````
Ideen zur verbesserung
- bei teilweiser Übereinstimmung  können wir weiter als nur um 1 nach rechts springen.
- Statt Strings vergleichen wir nur "Fingerabdrücke" (Hashwerte)
```
Hash funktion h: Sigma auf A
Algorithmus2(t,h) =
hp = h(p)
for i = 1 to n-k+1
	h' = h(ti ti+1 ... ti+k-1)
	if hp == h' return i

Größere Menge an Strings auf kleinere Abgebildet. Möglichkeit zur Hashkollision und wir erhalten eine Schreckliche kollision. Verbesserung durch diskretes prüfen :) 
Algorithmus2(t,h) =
hp = h(p)
for i = 1 to n-k+1
	h' = h(ti ti+1 ... ti+k-1)
	if hp == h' 
		if (p1 ... pk == si ... s i + k-1)
Laufzeit O(n*k)
	da wordstcase alles überprüft wird.
	und laufzeit für h(ti ... ti+k-1)
```
Hashfunktionen:
Interpretiern sie Buchstaben als Ziffern:

B = |Sigma|
Das sigma ist eine interoretiert eine folge von [0,...B-1]
p = p1 bis pk abgebildet auf  B^k-1 * pi + B^k * p2 + ... + B * P k-1 + Pk Ist gleich Summe B^k-j * Pj
t = ti ... ti+i-1

h (x1 ... xk) = Summe {j=1}^{k} B ^k-j mod r wobei r eine Zufällige am anfang des Programms gewählte  Primzahl ist. 
h(p) -> O(k) Zeit

Dies geht effizienter: wenn h(ti-1 ... ti+k -2) bereits berechnet
	Siehe dir Rolling String nochmal zuhause.
	Sei  q^(i-1) = Summe{j=1}^{k} B^k-j ti+j-2
	h ^(i-1) = q^(i-1) mod r
	Dann gilt: q^(i) = Summe{j=1}^{k} B^k-j ti+j-2
	h' = h(q^(i)) = q(i) mod r
	q(i) = q^(i-1) - t i-1 * B^k-1) * B + ti-1+k 

ODer in Klartext gefasst. Wir parsen so gesehen den Hashwert immer. Wir entfernen den ersten und fügen die nächste Schneller auf.
```
Algorithmus2(Rabin-Karp):
	r= zufällige Primzahl r \in [2 k^2 logk log B]
	hp = h(p)
	q  = Sum{j=1}^{k} tj * B^k-j, h' = q mod r
	for i = 1 to n-k+1
		if  h == h' then
			if P == ti ... ti+k-1 
				return i
		if  i < n-k+1 // Ab hier wird der Hash  aktualisiert
			q = (q- ti*B^k-1) * B +ti + k
			h' = q mod r
	return "nicht gefunden"
Laufzeitanalyse:
	Primzahlen in [2,m] es ginbt m / logm Primzahlen.  Eine Zufällige Zahl in 2 bis m ist mit wsl 1/ logm prim.  
	In zufälliger Zeit von O(Logk) berechenn.
	h am anfang ausrechen ist h O(Logk) 
Wie of kommt es zu Hashkollisionen?
Das updaten der hasvalue ist nach dem ersten mal O(1)

Gesamtlaufzeit ist O(k) + summe der einzellaufzeiten wie oft überprüft werden muss ob h tatsächlich h' ist oder nur eine Hashkollision. 
Der erwartungswert Ti  <= k * Pr [hp==h'] +1 
	hp == h' ist  gegeben wenn summe ist gleich wenn (q-q') mod r  = 0 
	also r ist ein Primfaktor von q - q'
	wie viele Primfaktoren kann eine Zahl m maximal haben ? 
	Antwort log m 
	Die wsk das  q-q' maximal anzahl an primfaktoren hat ist log B^k = k*logB
	Pr[r Primfaktoren  von 2-2] = in der Menge k^2 log B gibt es klogB prifaktoren daraus schlieeßen wir dass Pr [r Prifaktor q - q'] = 1/k
	Die Erwartete laufzeit von Schritt Ti ist Konstant
	Somit ist die anzahl der Schritte länge des Textes = n
	Somit ist die laufzeit T[] = O(k + n)  k für die initialisierung der ersten Hashfunktion und n die Anzahl an Operationen, da in jedem Schrittt erwartet wird jeder Schritt nur k operationen.
```
___
**Algorithmus 3** (Knuth-Mornis-Pratt)

Dieser ist der Intelligente Skip. 
haben wir: 
t = ababababababababababab
p = ababx
wir haben ababx nicht aber wir können nach dem wir stelle 0 überprüft haben mit der stelle 2 weitermachen und das b als start der überprüfung skippen.

verschiebe Funktion  f(j): Bei  P j+1 wurde der Unterschied gefunden 
wie viele stellen in t sollen wir nach rechts rutschen?  Antwort 
Als nächsets wird P(q+1) mit der gleichen Stelle ti+j im Text verglichen.
p1 ... pq muss mit p j-2 .... j übererinstimmen

q+1 < j+1 <=> q < j 
q = f(j) ist die länge des längsten Präfixes.  p1 ... pq von P, der mit Suffix von pi, ..., pj übereinstimmt

Besipiel f(j) 
p= einstein Wir haben 8 Buchstaben das längste suffix ist einst da ein wieder ein suffix ist 
wir gehen linear durch den string durch und gucken ob wir bereits diese passage hatten. 
q = f(j) =  |0|0|0|0|0|1|2|3|
folglich
p = ababbaba
q = |0|0|1|2|0|1|2|3|
gucken wir an welcher stelle ein error exestiert? wenn an einer stelle einen error haben dan gehen wir in diese liste q sei error an stelle 6 dann können wir den 2. Buchstaben des schlüssels p mit der error stelle vergleichen. sei die stelle 6 in p 1, sei die stelle 1 oder 2 dann überprüfen wir die nächste stelle hinter x mit dem ersten.
___
**Laufzeit**:

Wir definieren eine Funktion Phi, Welche Zeigt, dass wir Fortschitt machen 
Phi = 2i-j <= 2i <= 2n als oberer Schranke
i = ist positiin in t 
j ist position in p

Phi = 1 im Anfang
Phi endet maximal bei 2n. (Worst case wir können nichts skippen)

Mit jedem schritt wird wird Phi größer

*Siehe den Beweis im Skript*

Maximal 2 n Schritte mit O(1) zeit, somit O(n)
___
# String Ähnlichkeiten 

String-Distanz:
2 Strings gegeben t, t' aus Sigma | t hat länge n t' hat länge m 

wie viele Schritte sind Nötig , um t in t' umzuwandeln?

Anwendung: 
- Bioinformatik, z.B. Distanz zwischen Genomen
- Quellcode vergleich  z.B.  diff, git
- Plagiatserkennung
## Teilsequenzen
Definiton Teilsequenz: 
	Eine Teilsequenz von t von länge k. wobei t i1, bis t ik geht  1 <=  i1 ... ik <= n
	Teilsequenz  != Teilstring  
	bpe ist teilsequenz  von besipiel  da bpe in in der reihenfolge zu finden sind

Def Längste gemeinsamme Teilsequenz von t, t':
	p ist p Teilsequenz von t , p teilsequenz von t' und |p| maximal

Def d(t,t') = Länge k novn der längsten gemeinsammen teilsequenz von t,t'
	es gibt Indizien 1 <= i1 < ... <ik <= n 
	es gibt Indizien 1 <= j1 < ... <jk <= n 
	sodass ti1 = tj1, ... , tik = tij  für die längste sequenz 
	Bsp: t = Beispiel t' basteln  d(t,t') = 4 da  "b,s,e,l" in Reihenfolge fallen

  gemeinsamme Teilsequenz von t und t' können wir als Matching vorstellen.  in the same order,
but not necessarily consecutively

def: diff(t,t')
	Wie viele schritte sind nötig um t in T' umzuwandeln: n+m - d(t,t') also länge string 1 + länge string 2 - längste gemeinsamme sequenz

### Algorithmus von Sequenzfinder = ) 
**Idee 1**: divide and conqour 
Funktioniert nicht da buchstaben in verschiedenne Teilbereichen funktionieren können.
**Idee 2**: Last buchstabe matchen
Wir suchen das Letzte match:  tm und tn, wenn gleich dann wissen wir dass diese Matchen 
Fall 1: tn = tm, 
	dann ist d(t,t') = 1 + (tn-1, t'm-1)
Fall 2:  tn != tm
	Wir gehen Rekursiv vor: wir neheme das maximum von d(t,t'(ohne das letzte)) und d(t ohne das letzte, t')
	Rekursions anker sind: (leere Menge , leere menge = 0 | string, leere menge  = 0 | leere Menge, string = 0)
		x = d(ti,tj) in der Rekursivität ist es die  Bildlich gesehen ist nun so gefasst ![[20250624_171424.jpg]]
	Laufzeit ist O(n* m) Der Speicherbedarf ist  ist (m) da wir 
___
Dynamsche Programmierung:
	Methode zur Lösung von komplexer Probleme indem sie in Teilmengen Aufgebaut werden.
		Nutze ein 2 Dimensionales Boolsche Array 
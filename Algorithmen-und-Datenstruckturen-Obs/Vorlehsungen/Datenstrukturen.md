Der **ADT** geordnetes Wörterbuch, **Ordered Dictionary** eine Menge von **Schlüsseln** K (Keys) Menge von **Werten** V (values)
Ziel: Speichere eine Menge von **Einträgen** (entries). Diese sind ein Paar (key, value), sodass jeder Schlüssel höchstens einmal vorkommt. 
Vorraussetzungen: k sind vergleichbar 
Operationen:
- **put (k,v)** -> Falls Schlüssel k nicht vorhanden erzeuge neuen Eintrag (k,v) sonst überschreiben
- **get(k)** -> suche nach dem Eintrag  Schlüssel k und gebe den wert v wieder, Fehler falls nicht vorhanden
- **delete(k)** -> entferne den Eintrag zu Schlüssel k
- **pred(k)** -> suche nach einem Predecessor (dient der schlüsselsuche in der nähe von eine m ggf nicht existierenden) (größte Schlüssel der kleiner ist)
- **succ(k)** ->suche nach einem Successor (dient der schlüsselsuche in der nähe von eine m ggf. nicht existierenden) kleinster Schlüssel der größer ist
put get delete O (logn)
____
## Binärer Suchbaum 
**Wie kann dieser Datentyp *Effizient* implementiert werden?**
Implementierung via **binärem Suchbaum**:
*Definition: Binärer Suchbaum* 
* Ist baum Werte sind in Knoten gespeichert
* Binärer Baum: Wurzel mit bis zu 2 Kinder
	Rekursive Definition:
	ein leerer Baum ist ein Binärbaum
	Seinen Tl und Te binäre baume, wir erhalten einen neuen  Baum T wenn wir einen Knoten v erzeugen und den Tl links und den Knoten Tr Rechts einsetzen 
	**alle!!! Elemente des Linken Teilbaums müssen kleiner als v sein** nicht nur Kinder 
	Rechter Teilbaum muss alle Schlüssel größer
Vokabeln:
	Knoten
	Knoten die im letzten Schritt erzeugt wurde ist die Wurzel (Knoten ganz oben)
	Kanten - Direkte Verbindung zwischen den Knoten
	Nachkommen - Sind die Knoten unter einem Knoten  
	Blatt: Knoten ohne Kinder
	Geschwister: anderes Kind des Elternknoten
____
Fortan folgt: Wert wird weggelassen, da nur die Schlüssel wichtig sind. Die leeren Blätter werden auch weggelassen
___
### Implementation
get(k):
	Start in der Wurzel, if k = v end  else v kleiner LinkerTeilbaum sonst Rechter TB 
		ähnelt Binarysearch 
put(k,x)
	gehe vor wie bei k um herauszufinden ob k im Baum vorhanden ist. finde ich den schlüssel k, überschreiben, laufe ich auf null, append knoten mit k = k und v = x
remove(k):
	gehe vor wie bei get um den knoten k zu finden. endet suche in null error
	dann: Fall 1: ist knoten Blatt -> setzte knoten = null | Fall 2: Knoten hat 1 kind, ersetze Knoten mit Kind |  Fall 3: Knoten hat 2 Kinder -> wir ändern den Eintrag in v -> finde den größten Eintrag im linken Teilbaum und ersetze den Knoten v mit dem knoten des größten linken Element (dieses hat max 1 Kind da kein größeres Element existiert) --> lösche den nun nach unten kopierten Baum.   
pred(k):
	größter Schlüssel kleiner als k
		suche k wie in get(). 
		Fall 1: k ist vorhanden und Knoten zu k besitzt einen nicht leeren Linkenteilbaum --> größter nachfolger ist rechteste Eleement im Linkenteilbaum
		Fall 2: k ist vorhanden besitzt keinen leeren Linken Teilbaum gehe zur ersten linken Vorfahren. (erster Turn nach links)
		Fall 3:
Heaps: 
- Ordnugnseigenschaft: Kinder immer kleiner
- Vollständigkeitseigenschaft: Immer von links aufgefüllt
___
## AVL Bäume
Sind binärbäume mit folgendem Unterschied:
- ist ein Binärbaum 
- Der Balancefaktor ist die differenz der tiefe der beiden Kindbäume 
- Ein AVL baum ist ein Baum Wo jeder Balacefaktor kleiner gleich 1 ist
- Leere Knoten haben einen Blancefaktor von -1
- höhe von Baum ist log(n) 
- ein baum der höhe h hat mindesten (3/2)^h 
___
### Rotationen:
 Problem: beim Einfügen und Entfernen eines Elementes kommt es vor, dass dass Gebot des Balancefaktors nicht immer gegeben ist.  und somit der Baum nicht mehr ideal.
 Die lösung ist eine Lokale Rotation um die Struktur des Binärbaums konstant zu ändern. Hierbei bleibt die Binäre Suchbaumeigenschaft erhalten. 
 - Einfache Rotationen
 - Doppelte Rotationen
 Einfache Rotation (an Beispiel )Linke Rotation ()
	 
		 a
		  -b
			c 
	Zu:
		b
	a        c

das linke kind von b wird zum Rechten Kind von a. analog gespiegelt für r Rotation  

![[Pasted image 20250506144345.png]]
Doppelte Rotation: Aufeinanderfolge von 2 Entgegengesätze rotationen am besipiel (Rechte Linke Rotation) beim doppelten rotiert der oberste im ersten rotieren nicht  Nicht

	a
			c
		b
	Zu
	a
		b
			c
	Zu
		b
	a        c

Wenn Knoten den Balacefaktor verletzt  startet an Knoten wo balance verletzt und gehen in Richtung dem zuletzt eingefügten Knoten für 2 Knoten. Ist dieser Linear Weg linear ist es mit einer einfachen Rotation überführ bar. ist dieser mit knick versehen so folgt die Doppelte Rotation.

Genau definiert Sei u ein Knoten mit höhe h +3  und l knoten h der rechte knoten v mit höhe h +2 und dessen linker knoten h +1. So folgt das wir eine R rotation mit v machen. und dann eine l Rotation mit v und dem linken knoten von u.

![[Pasted image 20250506171813.png]]

___
### Einfügen/Löschen in den AVL Baum
- schritt 1: führe die Operationen wie bei einem BSB aus. 
- schritt 2: gehe den suchpfad nach oben und überprüfe ob die Suchbaum eigenschaften weiterhinn gegeben sind. (dafür muss jeder knoten wissen ob dieser selber ausgeglichen, links oder rechts lehnend ist.)
- Einfügen 1 mal rotieren 
- Löschen ggf. jedem Knoten auf dem ganzen Pfad bis ganz nach oben rotieren 

## Sonderform Gewichtsbalacierte bäume
Sei T ein bin¨arer Suchbaum mit n Knoten. Wir definieren eine Gewichtsfunktion
auf T , wie folgt: F¨ur alle leeren Teilb¨aume x ist w(x) = 1. F¨ur einen Knoten v sei
vl das linke und vr das rechte Kind. Dann ist w(v) = 1 + w(vl) + w(vr).
Wir nennen T gewichtsbalanciert, falls f¨ur alle inneren Knoten v in T gilt: Seien
vl und vr das linke und das rechte Kind von v. Dann ist w(vl) ≥ w(v)/10 und
w(vr) ≥ w(v)/10.
___
## (a,b)-Bäume
Ziel:  Implementation geordnetes Wörterbuch effizient.
Idee: Verwende einen Suchbaum der den perfekten Baum approximiert. (AVL Bäume höhe der Teilbäume können in gewissem Maße variieren. ) wir erlauben dass Bäume mehrere kinder haben können. Anzahl der Kinder ist Variabel.
**Definition**:
(a,b) 2 Parameter, (a,b) sind natürliche Zahlen. **a ≥2** | **b ≥2* a-1**
Ein (a,b) baum ist ein gewurzelter Baum, in der die Folgenden Regeln gelten. 
- Jeder Knoten hat **höchstens** b Kinder
- Jeder Knoten hat **mindestens a** Kinder
- Ausnahme Wurzel besitzt mindestens 2 Kinder (*abgesehen von a*) oder Blatt
- Jeder Knoten speichert **mindestens a-1** Einträge und **höchstens b-1 Einträge**. Wurzel min1 höchstens b-1.
Für innere Knoten. Sind l-1 Einträge gespeichert besitzt dieser l Kinder
- Alle Blätter liegen auf der selben Ebene.
Die Kinder in jedem inneren Knoten sind geordnet und die Einträge ,müssem so verteilt sein, dass die verallgemeinterte Suchbaumeigenschaft gilt.
**verallgemeinerte Suchbaumeigenschaft**:
	Für alle Knoten gilt [k1, k2, ..., k(l-1)], die Schlüsse sind aufsteigend Sortiert. für die Kinder gilt, alle Kinder im ersten Teilbaum sind kleiner als k1, alle im 2. Teilbaum , dass sie k1 < T2 < k2, dass  Tl > kl-1,

![[Pasted image 20250509125756.png]]
Bsp: Ein (2,4) Baum (sonderbar ist auch ein (2,10)-Baum)
![[Bildschirmfoto 2025-05-09 um 13.05.12.jpeg.png]]

Geringe Knotenmenge ist mit kleinen bäumen gut machbar.

Sollte der baum in einer Festplatte oder externen Speicher gespeichert sein lieber mehr Knoten. Seien Knoten Speichermedien so ist es einfacher Viele Daten auf ein Speichermedien zu packen als zu einem anderen relay zu gehen (-> ab häufig in Datenbanken)
___
### Operationen
- **get**(k): starte bei Wurzel. sei v aktueller Knoten. im Knoten die Stelle suchen wo k sein könnte. ist k im Knoten fertig ist nicht gehe in Teilbaum: *wiederhole* 
- **einfügen**(k): Falls k gefunden überschreiben. Falls nicht. Suche endet im Blatt, welches k enthalten sollte. Dort einfach einfügen. Wir fügen **immer in die Blätter** ein (**Problem überlauf**: Füge ein in ein Blatt mit b-1 Einträgen denn b limit würde überschritten werden, wir spalten das Blatt auf) Von 1 zu 3 einen Schlüssel und 2 weitere Blätter. Um die Ab eigenschaft wiederherr zustellen müssen wir das Blatt aufspalten. 
- **spalte**(Blatt): einer der Mittigen Schlüssel bei (geraden das linke))A) dieses geht als schlüssel in den Elternknoten. die linken elemente des Blattes gehen als linker TB die Rechten elemente als Rechter Tb. 
	- Weitere Probleme ist in einem der Kinder zuwenig Einträge. Was ist wenn im Elternknoten (ggf.)
	- Kindproblem: wir haben b die bedingung b 2* a-1 somit muss b > -1 (Knoten der nach oben wandert) a-1 minimum/ a-1 minimum Knoten =>Durch die bedingung kann das Kinderproblem nicht entstehen
	- Overflow problem: Iteriere das Spalten bis der Baum die Eigenschaft erfüllt. Da die Wurzel min 2 Kinder haben muss, statt min a Kinder gilt **der Baum kann immer nach oben (Wurzel spalten) erweitert werden**  
- **delete(k)**: lokalisiere k in Baum: Laufe bis K. ist K nicht enthalten pech. ist K innerer Knoten ersetze mit nachfolger oder Vorgänger. **Wir löschen nicht aus inneren Knoten**. Lösche diesen Rekursiv bis Blatt. Löschen aus einem Blatt Entferne Eintrag, falls untere Grenze missachtet wird (**Unterlauf**). 
	- **Problem Unterlauf** 1. betrachte Geschwister kann man sich etwas leihen. Ja? dann **Rotation**. *bsp. rechtes Geschwist hat genügend. Rechtes Element von Geshwist wandert nach oben oben wandert zu mir.*  2. Haben die Geschwister nicht genügend werden Eltern angesprochen. Suche ein Geschwist und merge mit dem zwischen liegenden Eltern Knoten und dem Geschwist. Wenn Elterknoten zu wenig hat. Iteriere ggf. bis Wurzel.  hat die Wurzel zu wenig, dann Rotieren wir wieder, doch der Teilbaum des Inneren Knoten wird mit rotiert. Sollte dies nicht möglich sein, da alle Kinder der Wurzek nicht genügend Knoten haben, dann sinkt die höhe des baumes und alle Kinder der Wurzel werden zur neuen Wurzel. 
#### Analyse der Laufzeiten
Was ist die Laufzeit der einzelnen Operatoren?
Was können wir über die höhe eines A/B baus sagen? Sie ist am höchsten wenn alle Knoten nur (a-1) Einträge haben. also h max in abhängigkeit von n. Pro Knoten sind a Einträge möglich. -> n/a ist die anzahl der Maximalen knoten.  pro Knoten gibt es maximal a Kinder also.  a^n Knoten
==ML==: Auf Ebene 0 gibt es  Wurzel auf Ebene 1 gibt es 2(a-1 Einträge) Auf Ebene 2 gibt es a* 2 Knoten. und (a-1)* 2a Elemente
auf Ebene i gibt es mindestens  (2a-1)* a^(i-1)
ebnen. O(loga(n)))
es folgt 1 + 2*(a-1 + 2(a-1)* a) ... =  1 + 2(a-1*){1+a+a^2} = Geometrische summe = 1+2* (a-1)  a^h -2 / (a-1) = 2a^h -1 => ein AB baum der höhe h besitzt 2a^h -1 Einträge = loga(1+ n/2) = h somit folgt eine operationsgeschwindigkeit von O(loga(n)) 

Die Anzahl der Knoten die von einemr Operation (get, einfügen,löschen) besucht ist O (loga n)
Bei einer naiven Implemenetierung benötigen wir für jeden besuchten Knoten Zeit Proportional zu Anzahl der im Knoten gespeicherten Elememnte also O(b * log a n)
___
## Sonderfall B-Baum
ist ein (a-b)Baum wo  festgelegt ist dass b = 2b-1
## Schwarz-Rot-Baum
Ein rot-schwarz Baum ist ein bin¨arer Suchbaum, den wir auf die folgende Wei-
se erweitern: Jeder Knoten und jeder leere Teilbaum erh¨alt eine Farbe (rot oder
schwarz), so dass die folgenden Regeln gelten: (i) die Wurzel ist schwarz; (ii) die
leeren Teilb¨aume sind schwarz; (iii) die Kinder eines roten Knoten sind schwarz;
und (iv) die schwarze Tiefe aller leeren Teilb¨aume ist gleich, d.h., f¨ur alle leeren
Teilb¨aume ist die Anzahl der schwarzen Knoten auf dem Pfad von der Wurzel zum
jeweiligen Teilbaum gleich.
___

## Skip-listen
Idee: den Listen eine chance zu geben <3
Inspiration ÖPVN: 

Struktur: 
Statt Regionalbahn: B - A-B-C-D-E-F-G-H- ... -X
Regional Express: B - D - H -... - X
ICE: B - F
### Vorgehen 
Also gibt die verschiedensten Wege zu überspringen.
Hierachrie von Listen: höherre Listen um Einträge einer niederen zu überspringen.
In hierarchie von oben nach untenwird gemacht
Schleife{
	komme ich mit meiner Stufe vor dem gesuchten knoten raus? Ja dann einen Knoten weiter wiederhole
	sonst senke die hierarchische Stufe, wiederhole 
}
### Struktur einer Skipliste
Ist eine Hierachie, von Verketteten Listen:
- L0 ist niedrig L i ist höchste.
- L0 ist die komplette Liste.
- Jede Liste enthält 2 Dummy-Knoten.  -infinity am Anfang und  infinity am Ende.
- Li+1 enthält eine Teilfolge von Li
- Jeder Knoten der Ebene l enthält Verweis auf den äquivalenten Knoten in der Ebene i-1
### Funktionen
get(k): starte bei -infinity ist nächster Knoten vor k dann nächter knoten diese Ebene? sonst
eine Ebene nach unten und wdh. falls k gefunden, dann zur untersten ebene

___
Problem bei expresslisten wird jeder 2. der Unteren liste aufgebaut.  aber bei jedem Einfügen oder Löschen ist es möglich, dass man die liste erneut aufbauen muss.

Lösung, Skipliste:
Per münzwurf wird entschieden ob das Element in die nächste Ebene eingefügt wird. Eine münzwurfserie.
Jedem Element wird eine Zufällige höhe entsprechend der Reihenfolge eines Resultats eines Münzwurfs eingeordnet. Je öfter Kopf hintereinander sonst nur 1
Put (k) Olog(n):
	Suche k via Traversierung, dann wirf eine Münze so oft bis zu wersten mal Zahl (#Münzewürfe -1) | speichere knoten in 0 und in den j darüberliegenden Listen
get(k) Olog(n):
	
delete Olog(n)
Beweis Teil 2

Die suche benötigt die suche nach k im Erwartungswert O(log(n))
	Ziel: Anzahl der schritte bestimmen. Wir betrachten die Anzahl der schritte die wir in einer Liste machen müssen.
E[Suchzeit ] = 
![[Pasted image 20250523123216.png]]

Erwartungswert ist der oberen Listeist überschätz und die Anzahl der Elemente der Liste. 
Durch Umschreiben der Liste kommen wir von 2n/n * 2 ist 4
![[Pasted image 20250523123236.png]]
![[Datei_000.png]]
Bedeutet dass wir einen kosntanten amoutn an Schritten in den Jeweiligen Listen gehen.

Vorteile der Skiplisten: einfache Implementierung , gute (erwartete Laufzeit)
Nachteile: Laufzeit ist nur erwartet O(logn) benötigt zusätzlichen Platz

Anmerkung ähnlicher Ansatz in Baumform(binär): Zip Trees (Münzwurf entscheidet über Rang) Baum ist ;ax heap über Ränge und BSB bzgl Schlüssel.
___
# ADT Wörterbuch (MAP)
- Die Schlüssel sind in diesem Wörterbuch nicht geordnetes Universum
- kann also Einträge speichern, nachschlagen, löschen
- kann  nicht verlgeichen
- zwei Mengen k, V Objekte sind S ⊆ KxV, wobei K (nicht unbedingt aus geordnetem Universum kommt)
## Funktionen
Operration
put(k,v):  Vorraussetzung: / Effekt: S <- {(k,v')| (k,v') elemnt von S}) vereinigt mit {(k,v)}
get(k): vorraussetzung: Existenz von v in menge S, Effekt: / Ergebnis: v
delete(k): Vorraussetzung: (k,v) element von S Effekt: s' <- S\ {(k,v)} Ergebnis: /
size(), isEmpty(): Vorraus: /, Effekt: /, Ergebnis Int oder Boolean

Wie können wir das Implementieren?
angenommen: K{1,...,99}, array der Länge 100
put (k,v): A[k] <- v
get(k): return A[k]
remove(k): A[k] <- Null 
alle sind O(1)
**Problem**: Allgemein so nicht möglich, K kann eine nicht geordente Menge sein, Array kann zu klein oder verschwenderisch groß sein, All
## Hashing
lösung: **Hashing**
Funktion h: K -> {0,...N-1}, wobei N = |A|, welche jedem Schlüssel k element K position A[h(k)] schreibt. (H ist eine Funktion, die einjedem wert K einen eindeutigen bijektiven wert aus 0 bis N )

Sei A Array von größe N

Ziel ist eine Implementation, Wörterbuch, Dieser ADT, die schlüsselmenge ist nicht geordnet.
Einträge in einem Feld/Array Speichern.
	Verwende eine Hashfunktion, die jedem Schlüssel, einen Index im Feld zuordnet. 
	Diese Funktion soll nur eine Teilmenge der gesamten möglichen Schlüsselmenge.
	Problem 1: Wal der Hashfunktion
	Problem 2: Kollisionsbehandlung (Wenn 2 oder mehr Schlüssel auf die gleiche Stelle abbilden)
Das Feld ist der Hashtable/**Hashtabelle** (deu: **Streuspeicher**)
### Hashfunktion
Typischerweise geschieht die Berechnung in 2 Schritten. 
- Schritt 1: **Hashcode**: Umwandlung des Schlüssels in eine Ganzezahl. (Bei den Standard Typen ist das Vordefiniert, bei eigenen klassen und Objekten muss du selber programieren)
	- ;öglichst Injektiv
	- Müssen wir nur einmal für  K festlegen
- Schritt 2:**Kompressionsfunktion**, abhängig von der Größe der Hashtabelle. (also ggf. modulo n-1 (bei größe n der Hashtabelle)). Sollte die hastabelle sich ändern, dann ändert sich die Kompressionsfunktion
	- Bildet jede schlüsselmenge ab.
	- Möglichst gut verteilt
	- Kann sich jedesmal ändern wenn die Hashtabelle neu inititert wird. 
	- Typischerweise (z -> z mod n), z * rand mod m, *a z+b mod m* (a,b zuallszahl aus [0 .. n-1  gemacht bei initialisierung der Hastabelle] genannt **universal Hashing**)  
	- Tabulator Hashing nimmt an Hashcode hat 64 bit. (Wir unterteilen den in 8 Blöcke mit jeweils 8 bit) Lege 8 Tabellen mit 256 Zufallszahlen zwischen 0,..., n-1 an. 
		- Beobachte Implementiere jeden 8 Bitblock als Index in jeweiliger Tabelle Addiere Tabbelleninhalte  und rechne *mod m*
### Kollisonsbehandlung
Sei kh eine funktion die k -> {0,...*n-1*} 
	Sei *k1 ungleich k2* dann ist eine Kollision wenn die beiden auf den gleichen Wert {0,...*n-1*} abbilden.
	 Was soll ich machen wenn von Einträgen enthält?
	- **Hashing mit verketten**. Bei kollisionen verwnden alle den selben Platz (chaining, es entsteht dort eine Liste und die Verkette liste wird abgeguckt)
	- **Offene Adressierung**: Suche Neuen Platz
	- **Kuckkuck**, Wenn schon besetzt wird vorhandenens Element rausgeschmissen. Der rausgeschmissene Eintrag wird einen neuen 
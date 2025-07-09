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
#### Hashing mit Verketten
 Bei kollisionen verwnden alle den selben Platz (chaining, es entsteht dort eine Liste und die Verkette liste wird abgeguckt)
Initialisierung 
	Wähle m die Größe der Hashtabelle
	Lege einen Eintrag T der Größe m an [Hashtabelle]
	An jedem Position von T initialisiere eine Leere einfach verkettete Liste 
	wähle Hashfunktion h (Kompressions funktion)
get(k): i <- h(k) | l <- verkette Liste in T[i] Durchsuche l nach eintrag mit k 
	Falls gefunden gib wert zurück
	falls nicht | nicht in 
put(k,v)
	i <- h(k)
	l <- Verkette Liste in T[i]
	remoce  i <- (k)
___
Speicherbedarf:
O(m + n)
m größe der Hashtabelle Anzahl der einträge
___
Laufzeit:
Initiialisierung O(m) + Zeit zum wählen der Hashfunktion
get/put/delete: Zeit zumk Berechnen der Hasfunktion und Zeit von der länge von von l
also im Worstcase länge l

Also  Die Eigesnchaft von h sind wesentlich für die analyse.

Bracuhen annahme über h
Einfachse Annahme (**gleichmäßiges Hashing**)
-  h kann in Konstanter Zeit initialisiert und bere chent werden 
- und h verhaltet siech wie eine Zufällige fungktion
=> jedesmal wenn h zum ersten mal für einen  schlüssel k berechnet wird, wält h für k zufälli gleichverteilt ein Index in {,...,n-1}, unabhängige von an deren Schlüssel k Danach ist h(k) fest.
Aufgrund der Gleichverteilung sind Gesetze wie Taubenschlag prinzip anwendbar.
Also Minimum der Einträge der Liste ist (aufgerundet) (n/m)
Maxiumum ist n

Die frage was erwarten wir wie viele Elemente im gleichen Eimer wie n sind. 
ist  1 + SUMME (n- , i=1) xi | wobei xi die WSkeit ist


Sei S eine Menge von Einträgen, die eine Hastabelle mit größe m gesperichert wird. Sei x ein Fester Schlüssel Nimm an fester Schlüssel. Nimm an, wir verwenden Hashing mit verketten und dass sich die Hashfunktion Random verhält. , Dann istdieir Erwartete laufzeit für eine Operation auf x wie folgt, :
E = [1 + SUMME (n- , i=1) xi] = 1+  summe E[xi] =  + summe 1/m  = Eh[T] = O (1+(n/m))

Das n/m ist der **Ladefaktor**,  Je kleiner der Ladefaktor des do besser. ist er aber zu klein dann verschwenden wir Speicherplatz
Jede Zufällige Hashing-Funktion ist Ideal für alle mengen. aber es gibt mindestens 1 Menge die für die desaströß für die Hashing mit Verkettung. 
*Ideal wird 1 bis * besser 1 bis 2 angestrebt

Verkettete Listen sind nicht gut in einem Heap, somit nicht ist das Cashing ideal. Es hat keine Zeitliche oder örtliche Localität
#### Hashing mit offener Adressierung
Ziel: Speicjere alle Einträge direkt in Hashtabelle. Keine Sekundären Datenstrucktur.
Problem: Wir können nicht mehr Garantieren, dass sich das Element an einem Festen Ort befindet.
Lösung: **Lineares Sondieren** Wir gehen einfach immer in den nächstes 
___
**Details**
Hashtabelle T die größe mIn der Zellen von T komm drei verschiede Dinge: 
- Null (zelle ist unberührt)
- Eintrag (k,v) Schlüssel k wet v
- Spezialfall mit DELETED (Tombstone)
Der Tombstone ist benötigt, da die impleemntation von get/put/delete bei null aufhöhrt (ist ein früher abbruch) Sollte das element k   ... k eigentlich, ...., Gelöschtes element,..., k ist . Dann gilt, sollte es nur null geben dann stoppt die suche vor k. Durch tombstone wird auch hinter der leeren Stelle gesucht.    
___
**Initialisierung**
- Lege Hashtabelle mit m Positionen an
- Initialisiere alle Positionen mit Null
- Wähle die Hashfunktion.
___
``` 
get(k):
	pos := h(k)
	for i = 1 to m do
		if pos.k == null
			return null
		elif pos.k == k do return v
		else pos = (pos +1) mod m 
	null
	
remove(k):
	pos = h(k)
	for i=1 to m do
		if T.pos == Null then
			null
		elif T.pos.key == k then 
			T.pos = Toombstone 
		else pos = (pos+1) mod m

put(k,v): 
	pos = h(k)
	deletepos = null
	for i= 1 to m
		if pos.key == key then 
			pos = (k,v)
		if pos.k == Toombstone && delpos == Null
			delps = pos
		elif pos == null then 
			if deleted pos != null then 
				posdeleted = (k,v)
			else pos = (k,v)
			return
		
		else pos = (pos + 1) mod m
	throw ("Shit's full")
```
___
#### Hashing mit KuckKuck 
**Idee**: Verwenden von 2 Hashfunktionen. h1 und h2
 - Für jeden  Schlüssel k gibt es nur 2 Möglichkeiten wo h stehen kann. h1(k), h2(k)
 - Keine sekundär Datenstrucktur, Einträge direkt in Hashtabelle.
 ___
 **Initialisierung**:
 - Wähle Tabellen Größe m 
 - Lege Hastabelle der Größe m an
 - Initialisiere alle positionen mit Null
 - Wähle 2 Hasfunktionen h1, h2: K -> [0, ..., m-1],  h1≠h2
 ___
 **Funktionen**:
```
def get(k):  
	if Tabelle[h1(k)].k == k then 
		return Tabelle[h1(k)].v
	elif Tabelle[h2(k)].k == k then 
		return Tabelle[h2(k)].v
	else null
def delete(k):
	 Tabelle[h1(k)].k == k then 
		Tabelle[h1(k)].v = null
	elif Tabelle[h2(k)].k == k then 
		Tabelle[h2(k)] = null
	else println(" not in the fucking List")
def put(k):
// Anfang der überprüfung von einfaches überschreiben
	if T[h1(k)] != null && T[h1(k)].k = k then
		T[h1(k)].v = v
		return
	if T[h2(k)] != null && T[h2(k)].k = k then
		T[h2(k)].v = v
		return
// Eigentliches pu mit guckguck funktion
pos = h1(k)
elemetn = (k,v)
	for i = 1 to m do
		if T[pos] == null then
			T[pos] = (k,v) 
	
	temp = T[pos]
	T[pos] = element
	element = T[pos]
	// nun  werden die positionen mit dem neuen k ausprobiert.
	if  pos == h1(k) then
		pos = h2(k)
	else pos = h1 (k)  
```
Ladefaktor e < 1
Worstcase get() = O(1)
Worstcase delete() = O(1)
Worstcase put() = m für eine schleife ggf. rehashing ( ) somit unbound  
____
Weitere Anwendungen von Hashfunktionen:
Bilde eine sehr Große Menge aif eine wesentlich kleinerer menge ab
Möglichst struckturlos, kollisionen möglichst vermeiden
Nützlich fürs Fingerprinting. . Dient zur verifikation. Ist die Hashfunktion auf einen 
	Um zwei Große datenmengen auf gleichheuit zu überprüfen. Vergleiche Hashwerte und nicht datenmengen selber. 
Kompakte hashfunktion Darstellung
	kann hashwert nicht auf Dateninhalte schließen
___
Erster Teil ist nicht mit aufgenommen. Kryptographidche hashfunktion

Anwendung der Datenstrukturen

  

Hash Referenz 

Objekte können Referenz auf andere Referenen speichern.

Bsp obj Vorlesung referenziert das Objekt Dozent

  

Hash Referenz zusätzlich zur Referenz speichert zusätzlich den Wert aller Attribute des Objektes. Somit sichergestellt das Objekt nicht geändert wurde.

  

Besonders praktisch verkettete Liste, denn der Wert ist Parameter somit folgt. Wer einen knoten einfügen möchte muss den knoten davor ändern und dann den davor etc. etc. somit kann nur ein knoten am Anfang eingefügt werden.

  

Dies ist das Grundkonzeption der blockchain. Und alle kompetenteren um den ersten knoten, da nur dort etwas eingefügt werden kann ohne die komplette Liste an jedem knoten zu ändern.

  

Es gibt somit einen kompetentiven Wettbewerb dort eine einzufügen. Die Idee man darf nur einbauen wenn die hashfunktion auf 10 Nullen ändert. 

Das Minigolf ist es einen Nonne Parameter zu finden der diese Angabe erfüllt. Also du darfst nur einfügen wenn hash von vorhergehender Tabelle+ Attribute des Knotens sowie nonceattribute auf 10 Nullen endet.

  
  
  
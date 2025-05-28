Anna Tamina Freiin von Stietencron, Marcel Giller
___
![[Pasted image 20250516010000.png]]
![[Pasted image 20250516010024.png]]
1b)
Sei T ein binärer Suchbaum und u ein Knoten sowie ein Kindknoten v.
Aus der Vorlesung ist bekannt, dass jegliche Art von unbalance via rotation ausgeglichen werden kann. 
Das einfügen eines Knoten in ein AVL-Baum kann nur an einer Freien stelle passieren. Entweder an ein Blatt oder an einen Knoten mit bereits einem Kind/Teilbaum. Da wir festgelget haben, dass wir an einen AVL-Baum anlegen ist bekannt, dass der Baum bereits Balaciert ist, bedeutet die balance des Eltern Knoten ist 0 oder 1. Sollte der neue Knoten an einen Knoten mit einem weiteren Teilbaum, so hat der neue knoten keine auswirkung auf dessen tiefe da die höhe des zugefügten knoten 1 und die des anderen größer gleich 1 ist. Sollte Knoten an ein Blatt eingefügt werden, so wird die tiefe eines jeden knoten auf dem Pfad von der Wurzel zum Knoten um genau 1 erhöht. 
Sollte dies zu einer Imbalace führen so ist diese um maximal die höhen differenz 2 (höhen differenz 1 ist in einem AVL-Baum erlaubt, dies +1 sorgt für einen differenz von 2). Und diese lässt sich mit einer Rotation wie in der Vorlesung beschrieben ausgleichen. 
![[Pasted image 20250516010227.png]]
![[Pasted image 20250516010306.png]]

Beim löschen kann es zu vielen Rotationen kommen, dies geschieht, wenn ein Knoten unbalanciert ist, die Rotation aber dafür sorgt, dass der Knoten drüber unbalanciert wir. Wiederlegend durch Gegenbeispiel: 
![[Pasted image 20250516010542.png]]
**Aufgabe 2**
a
![[Pasted image 20250515212018.png]]
Wo befinden sich die Schlüssel, die kleiner sind als 37? 
In jeden Teilbaum und Elternknoten, welcher sich durch einen Linken Schritt von 37, erreichen lässt, wobei  zu rechten vorfahren gegangen werden kann, diese aber nicht mit in die Aufzählung zählen. 
Wo befinden sich die Schlüssel, die größer sind als 21?
In jeden Teilbaum und Elternknoten, welcher sich durch einen rechten Schritt von 27, erreichen lässt, wobei  zu linken Vorfahren gegangen werden kann, diese aber nicht mit in die Aufzählung zählen. 

Wo befinden sich die Schlüssel, die zwischen 21 und 37 liegen?
In der vereinigungs Menge der beiden Mengen [größer als 21], [kleiner als 37]
Also in den Teilbäumen die sowohl. als auch. 

b)
Beschreibung der Implementierung von findRange(k1,k2):
Man gehe zum Knoten k2, oder zur stelle wo k2 sein sollte.
	ist man bei k1 oder an der stelle wo k sein sollte kann man abbrechen.
	ist der elternknoten größer als k1, so kann der komplette linke Teilbaum von k2 zur Liste hinzugefügt werden und man geht einen Knoten nach Oben. und wiederhole den vergleich.
	Falls der Elterknoten kleiner ist oder null(also nichtexistent) geht man zu seinem linken Kind.
		ist k1 gegeben oder die stelle wo k stehen sollte, rechten teilbaum hinzufügen und danach abbruch
		ist k1 kleiner fügt man den rechten teilbaum zur liste hinzu und geht zum linkenkleineren. man wiederhole
		ist k2 größer geht man zum rechten kind und wiederhole.
Die Anzahl in den Teilbäumen welche direkt hinzugefügt werden ist maximal (k2 -k1) = s
die anzahl der teilbaumschritte ist also s+ sowie log(n), da maximal 2 mal die komplette höhe des baums traversiert wird welche log(n) ist. also -> O(log n + s)




**Aufgabe 3**
![[Pasted image 20250516010744.png]]

b)
beweis per Induktion:
mindestens *2^(s−1)  − 1* schwarze Knoten 

Induktionsanker = *s = 1*  für nur Wurzel und leere Knoten.
*2^(1-1) -1 = 2-1 = 1* = Wurzel.

Induktionsvorraussetzung: Tiefe *s* mindestens *2^(s-1) -1*  schwarze Knoten.
Induktionsschritt Tiefe *s + 1 = 2^(s -1+1) -1*
*2^(s -1+1) -1 = 2 * ==2^(s -1) -1==* | bereit bewiesen für Tiefe s
zu zeigen, dass für eine weitere Ebene mindestens 2 weitere schwarze Knoten hinzu kommen.
Um *s* um 1 zu erhöhen muss über jedem Teilbaum ein schwarzer Knoten hinzugefügt werden. 
Die Anzahl der hinzugefügten Knoten ist abhängig wo diese eingefügt werden. Die Wurzel ist schon schwarz. 1. Kandidat ist somit Ebene 2. Dort kann auf der linken und rechten Seite *eins* eingestellt werden. somit ==2==. Sollte eine beliebige Ebene darunter eingefügt werden, so steigt die Anzahl der benötigten Knoten um 2^*u* wobei *u* die Ebene nach unten ist. 
Sei *s* die schwarze Tiefe und der baum *T* nur die Wurzel. Die knoten haben *s* =1. 
Um *s* um Eins zu erhöhen müssen sowohl im linken Kind ein schwarzer Knoten sowie im rechten Kind ein schwarzer Knoten hinzugefügt werden, da nur auf einer Seite die Klausel "*die schwarze Tiefe aller leeren Teilbäume ist gleich*" verletzt werden würde.  somit minimum 2.

Das minimum der Höhe *h* im Verhältnis zu *s* ist gegeben wenn nur schwarze Knoten vorhanden sind, sei ein roter Knoten existent so würde dieser die höhe nicht verändern oder diese vergrößern. Daraus folgt *s = h* im minimum. und *n = 2^(s-1) -1 = 2^(h-1) -1  -> h-1 = log2(n) ... => O(logn)*
da in allen Teilbäumen einer Ebene genau so viele Schwarze Knoten Vohanden sein müssen wie in einem anderen der Ebene haben.
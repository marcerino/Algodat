**Aufgabe 1**
Die Lokale Transformation ist SR-Baum -> (2,4)- Baum:
	Jeder Rote Knoten merged mit den beiden Kinderknoten, wobei der Rote Knoten das mittlere Element in den Kinderknoten ist. Dies ist möglich, da in einem 2,4 baum Mindestens 1 und maximal 3 Elemente sein dürfen. Die beiden Kinderknoten haben beide Jeweils 2 Teilbäume. somit 4 was der Maximalanzahl b entspricht.
	Schwarze Knoten verändern ihr Verhältnis zueinander nicht. Dies ist möglich, da midnesten 1 Element in einem Knoten sein soll (also k des schwarzen Knoten.) und dieser 2 Kinder haben muss, was per defiition gegeben ist, da alle Schwarzen knoten 2 Kinder haben bzw. die leeren Teilbäume sind. 
Die Lokale Transformation ist(2,4)- Baum ->  SR-Baum.
	Jeder Knoten mit 3 Elementen wird gespalten, das mittlere Element wird zum roten elternelement der beiden Randelemente. Dies ist möglich Da Die benachbarten Teilbäume von den Kindern übernommen werden und sich die schwarze höhe zur Wurzel durch das rot definieren nicht Ändert. Jeder 2 Elemente Knoten wird ein element das Rote elternteil des Anderen
Die schwarze höhe eines Jeden Teilbaums ist immer gleich ist äquivalent zu alle blätter liegen auf einer Höhe in einem a,b Baum. In eine SR Baum liegen alle leeren Teilbäume (äqivalent zu den blättern) auf gelicherschwarzer höhe Ebene. Das einzige was diese höhe verändert sind also die Roten Knoten. Wenn diese mit den Kindern mergen, weden alle Knoten mit Leeren Teilbäumen als Kinder auf der gleichen ebenen Liegen.    
**Aufgabe 2**
![[Pasted image 20250522230123.png]]
![[Pasted image 20250522230149.png]]
**Aufgabe 3**:
a) succ(k): 
	zunächst: gehe zu k oder der korrespondirenden Stelle  Stelle. via wie die Traversierung von get(k) aus der Vorlesung.  
	Fall 1: k oder die entsprechende Stelle (vortan nur mit k bezeichnet) ist in einem Blatt und hat einen linken Nachbarn. Linke Nachbar ist succ(k)
	Fall2: k hat einen Linken Teilbaum. dann Traversiere bis zum rechtesten Element des Linkenteilbaums, indem immer das Rechteste Kind bis zum Blatt und dort das Rechteste Element.
	Fall 3: k ist das linkeste Element in einem Blatt. Dann gehe solange in die Elternknoten, bis der Teilbaum mit k ein rechter Teilbaum eines Elements in Einem Elternknoten ist. Dieses besagte element ist dann der Succ(k), sollte es in der Wurzel kein Rechtes element geben ist kein succ(k) vorhanden  
Der Worstcase ist die Traversierung zu einem Element k in einem Blatt und hoch zurück zur Wurzel. Die maximale Anzahl an Knoten in einem a,b Baum ist gegeben, wenn jeder Knoten nur a Kinder hat. die Laufzeit ist also 2* loga (n) welches O(loga (n)

b)
findrange(k1,k2):
	gehe zu element K1 oder dessen Korrospondierenden Stelle ( fortan als k1 bzw. k2 analog) wie bei der traversion in get(k) aus der vorlesung
	Fall1: ist k1 in einem Blatt gehe Partner nach  Rechts und füge diesen in die liste ein, bis k2 oder Ende des Knotens. Falls Ende des Knotens Fall 3:
	Fall 2 ist k in Innerem Knoten, füge hinzu und gehe in den Rechten Tb, solange den Linkesten Teilbaum bis im Blatt, dann Fall 1 auff linkestes element
	Fall 3:  gehe zum Element zur rechten des Teilbaums mit k1 und füge dieses zur Liste hinzu. Falls dies auch Rechter Knoten, wiederhole nach oben gehen bis rechtes Elterelement vorhanden dann Fall 2, oder Teilbaum ist rechtester Teilbaum in Wurzel, dann abbrechen.
Die Laufzeit ist O(b loga n + s). 
Da wir im worst case loga n + s knoten besuchen werden, wessen länge b-1 lang sein kann

c)
Seien T1 und T2 (a,b) Bäume und x ein Element nach Aufgabenstellung
Fall1:
	x ist neue Wurzel, T1 ist Linkes Kind, T2 ist Rechteskind. Dies ist möglich da die Wurzel genau mindestens 2 statt a Kinder haben darf,
Fall2: 
	Sei T1 ein Teilbaum um d Ebene kleiner als T2. gehe immer in den Linkesten Teilbaum von T2 für (d-1) Ebenen von der Wurzel aus. Füge x als Linkestes Element in diesen Knoten ein und T1 als dessen linke Kind/Teilbaum. Sollte der Knoten mit x mehr als b-1 Elemente haben. agiere wie in put(k) und merge bis keine Konflikte mehr Herrschen.
Fall3:
	Sei T2 ein Teilbaum um d Ebene kleiner als T1. gehe immer in den rechtesten Teilbaum von T1 für (d-1) Ebenen von der Wurzel aus. Füge x als rechtestes Element in diesen Knoten ein und T2 als dessen rechtes Kind/Teilbaum. Sollte der Knoten mit x mehr als b-1 Elemente haben. agiere wie in put(k) und merge bis keine Konflikte mehr Herrschen.

Sollten T1 und T2 Unterschiedliche (a,b)-Bäume muss bei gleicher Höhe, ein baum angepasst werden.
Bei unterschidlicher höhe passt sich der kleine an den Größeren an. 

Sollte standard baum b größer oder a kleiner sein ist keine anpassung erforderlich. 
Ist b kleiner muss in jedem Knoten ausgehend von den Blättern nach obengehend überprüft werden ob Overshoot vorhanden ist, falls ja, dann Overshoot Protokoll aus der put(k) funktion. anwenden und ernuet Prüfen
Sollte a größer sein, muss auf jeden Knoten ausgehend von den Blättern das Undershoot Protokoll aus der delete(k) funktion angewendet werden, ggf mehrmals. 

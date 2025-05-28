Anna Tamina Freiin von Stietencron, Marcel Giller

**Aufgabe 1a**
![[Bildschirmfoto 2025-05-08 um 18.49.14.jpeg.png]]
**Aufgabe 1b**
Sei T ein Baum, der nicht Leer ist und die Vorraussetzungen für Vollständigkeit erfüllt, gillt folgende Aussage. Die Anzahl der Blätter ist genau um 1 größer als die Anzahl der inneren Knoten. 
Beweis: Induktion. 
Induktionsanker  n=0
	 ein baum ohne Innere Knoten der nicht leer ist hat genau einen Knoten, die Wurzel, welche ein Blatt ist. somit Anzahl-Innereknoten = 0 Blatt 1  1 = 0+1 
Induktions Vorraussetzung.
	Anzahl Blätter = Anzahl Knoten +1 für n knoten gillt n+1 Blätter.
Induktions Schritt: 
	zu beweisen: Ein vollständiger Baum mit n+1 Inneren knoten hat n+2 Blätter.
	Wir wissen dass ein Baum mit n inneren Knoten n+1 Blätter hat. Um einen weiteren Knoten anzufügen muss eines der Blätter 2 Kinder verbunden bekommen. 2 da 1 gegen die Vollständigkeit verstoßen würde.   Daraus ergibt sich n +1 Innere Knoten und n+1-1 Blätter vor anhängen der beiden Blätter und nach dem anhängen n+1 Innere Knoten und n+1-1+2 Blätter = n+2 Blätter.
	
	qed. 
**Aufgabe 1c)**
Ein Baum mit der Knotenanzahl n hat immer n+1 freie Stellen, wo knoten eingefügt werden können. 
Induktion: Anker
n=0: Ein baum mit keinen Knoten kann nur an einer Stelle einen Knoten hinzu gefügt bekommen. an der Stelle der Wurzel. somit freie Stelle 1 = 0+1
Indunktions Voraussetzung.
	Anzahl freier Stellen = Anzahl Knoten +1.
Induktions Schritt:
	Ein Baum mit n+1 Knoten hat n+2 Freie Stellen.
	Der Baum mit n Knoten hat n+1 Freie Stellen. fügen wir einen Knoten hinzu müssen wir bedenken dass dieser eine freie Stelle belegt aber selber 2 freie Stellen bietet. -> Anzahl Knoten=  n +1 und Anzahl freie Stellen = n-1 +2  = n+2 
	qed
___
**Aufgabe 2a:**
um zu überprüfen ob die Schlüsselabfolge möglich ist muss man überprüfen ob die Suchpfade die Egenschaften eines binären Suchbaums erfüllen. Speziefisch ordnungseigenschaft. bedeutet alle Elemente in der Reihenfolge des Pfades müssen alle elemente hinter einem Element entweder einheitlich größer oder kleiner sein.
(a) 2, 252, 401, 398, 330, 344, 397, 363.
	ist gegeben. 
(b) 924, 220, 911, 244, 898, 258, 362, 363.
	ist gegeben
(c) 925, 202, 911, 240, 912, 245, 363.
	nicht gegeben. element 911 >240 aber 912>911, somit nicht einheitlich.
(d) 2, 399, 387, 219, 266, 382, 381, 278, 363.
	ist gegeben
(e) 935, 278, 347, 621, 299, 392, 358, 363.
	nicht gegeben da 347 <621 aber 347>299 somit nicht einheitlich größer in im Folgepfad

**Aufgabe 2b)**
Eigenschaften eines Binären Suchbaums:
	Sei v ein beliebiger Knoten des Baumes T
	alle Elemente des Linken Teilbaums müssen kleiner als v sein
	alle Elemente des Rechten Teilbaums müssen größer als v sein
	maximal 2 Kinder.
Beweise das einfügen.
sein die Elemente eine Total geordnete Menge (ergo keine dopplungen). Das erste Element wird in die Wurzel eingefügt. Wird ein weiteres Eingefügt, so kann nur 
Beweis durch Widerspruch:
Angenommen T wäre ein Baum und das Element v soll eingefügt werden. ist T leer kann es nur als Wurzel eingefügt werden -> eindeutig. Ist T nicht leer folgt das T mindestens einen Knoten haben muss. es folgt es gibt einen  Knoten w wo das Element entweder als linkes oder als rechtes Kind eingefügt werden kann, bzw den linken oder den Rechten Teilbaum entlang gegangen werden muss um zur passenden Stelle zu kommen. Hat v einen Wert der v<w, so muss dem linken Teilbaum gefolgt werden. denn sonst wird die Ordnungseigenschaft des Binärbaums verletzt. analog für v>w. Würde v sowohl Links als auch Rechts eingefügt werden können wird die Totaleordnungseigenschaft der Schlüsselmenge verletzt. Es folgt eine Eindeutigkeit.
Überführbarkeit durch Rotation:
	Da ein Baum mit Schlüsseln einer totalgeordneten Menge gefüllt ist ist die Form des Baums nur von der Reihenfolge des Einfügens abhängig. Aufgrund dessen kann durch rotationen ein Baum stets in einen anderen Baum mit Rotationen überführt werden.      
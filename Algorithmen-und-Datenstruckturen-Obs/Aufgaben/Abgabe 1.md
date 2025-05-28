Marcel & Anna 
___
Aufgabe 2 a

Seien die Elemnte e in einem geordneten Dictionary. Dieses muss laut Vorlesung unteranderem  folgende Funktionen haben. put(),get(), delete(), pred(), succ(). 
1. Zunächst wird die Menge an zu ordnenden Elementen in das Dictionary eingefügt. 
2. Dann if wurzel != null wählen wir Wurzel aus, sonst leere menge ist geordnet.
3. Rufe Rekursiv prev(Knoten) bis prev(knoten)=null. 
4. get(Knoten) von prev(Knoten)=null wobei wir diesen als element einspeichern und delete(Konten), wo gilt prev(knoten)=null
5. Wir erhalten ein Dictionary, ohne den minimalen Knoten/wert, auf welches wir die Schritte 2 bis 4 wiederholen können bis es keine elemente mehr gibt. durch 4 erhalten wir dann eine geordnete liste. und wir erhalten immer das kleinste Element, da wir immer nach dem kleinsten element suchen. 
2b)
Die theoretische untere Schranke ist abhängig von dem Sortieralgorithmus abhängig, die schnellsten die bereits kennen gelernt haben haben die Schranke von O(nlogn)   

2c) 
um ein element zu finden brauch ein Suchbaum maximal h schritte (h ist die höhe des Suchbaums) und diese n mal ausgeführt werden. da der Suchbaum eine tiefe von maximal log(n) hat (binäres aufspalten) hat folgt für jedes Element  nlog(n).

![[Pasted image 20250501164041.png]]
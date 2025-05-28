Sei T ein binärer Suchbaum. Beschreiben Sie eine Operation, die den kleinsten
Schlüssel in T findet. Was ist die Laufzeit? Was ist die Laufzeit, wenn T ein
AVL-Baum ist?
Der klein

in binärer Suchbaum solamnge nach links gehen wie möglich, LAufzeit O(h) welches O(n) sein kann im balancierten suchbaum ist die höhe O(h) = O(logn)


```
go to wurzel

if wurzel!= null
	current = Wurzel
	while current != nill
		current = go left kind
go toparent(current) 

comparisson = current.parrent
if rechteskind != null
	
Worst case O(n) im AVL O(logn)
```


d) 
k ist wurzel T1 Links T2 Rechts

e)
Seien T1 und T2 gleiche höhe so ist es Möglich k 

k über Wurzel einfügen, dann 
Wenn unbalanciert sind dann differenz nehmen. Differenz am höheren Teilbaum nach unten gehehn diesen Knoten mit k rotieren 

als Rechtestes Elemetn T1 einzfügen  T2 als dessen Rechts kind und dann eine Linksrotation Von k  T2 Wurzel und T1rechtestes Kind.
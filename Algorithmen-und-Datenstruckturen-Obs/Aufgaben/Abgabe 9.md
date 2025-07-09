Anna Tamina von Stietcorn, Emanuel Reinking Florian,  Marcel Giller
___
Aufgabe 1: 
Code: Siehe Anhang 
Wie schneiden, Ihre Implementierungen im Vergleich ab?
Naive Suche:  326387400ns
Suche nach Rabin Karp: 184919000ns
$\frac{326387400ns}{ 184919000ns}=ca. 1.7$
Folglich ist der Rabinkarp algorithmus ca. 1,7 mal schneller als der naive Algorithmus.
___
Aufgabe 2:
(a) Der Algorithmus von Rabin-Karp l¨asst sich leicht auf mehrere Suchmuster
verallgemeinern. Gegeben eine Zeichenkette s und Suchmuster t1, . . . , tk, be-
stimme die erste Stelle in s, an der eines der Muster t1, . . . , tk vorkommt.
Beschreiben Sie, wie man den Algorithmus von Rabin-Karp f¨ur diese Situati-
on anpassen kann. Was ist die heuristische Laufzeit Ihres Algorithmus (unter
der Annahme, dass Kollisionen selten sind)?

Antwort: Der algorithmus muss angepasst werden. Sei $k$ die Länge des längsten Strings, Sei $p$ die Anzahl der Patterns, sei $n$ die Länge des Textes.
1. für einjedes pattern in der Eingabe muss ein Passender Hashwert ermittelt werden. Die Laufzeit der initialisierung steigt. Sei k das längste Pattern, dann dauert die initialisierung im Worstcase $O(k*p)$
2. Beim linearen durchgehen des Strings wird der Hashwert der als Vergleich dient mit jedem neuen Index um den wert der ersten Stelle verkleinert. dies geschieht in $O(1)$ und ändert sich nicht im Vergleich.
3. Aber um zu überprüfen, ob die Hashwerte übereinstimmen, muss jedes mal jeder Hashwert der Patterns mit dem neuen Hashwert des Textes verglichen werden. Diese Änerung ist statt $O(1*n)$ ist es nun $O(p*n)$
4. Auch die Spanne, die Überprüft werden soll, ändert sich bei jedem pattern. Somit muss auch die Spanne bei jedem Index für Jedes Element geändert werden. Der Rolling Hash wird dort also immer verändert. Ein schritt nach vorne ist also $O(n*p*patternsizedifferenz)$ 
$\to k*p+p*n+ n*p*patternsizedifferenz = O(n*p*k*patternsizedifferenzerential) \to O(n*p)$ da $n*p$ ausschlaggebend für die anderen parameter ist. 
b)
	sense = 41 
	sensebility = 15
	sensible = 20 
	Sense ist der gewinner
___

Definition:
Ein Graph ist ein Tupel aus den Mengen an Knoten $N$ und Kanten $E$. Die Letzeren bilden die Beziehungen zwischen den Knoten.
Die Kanten sind genauer $\{\{v,v'\}\\{v,v'\}\}}$ 
Beispiel: BVG Fahrplan, Netzte, Bankkonten
**Adjazenz**: Zwei knoten sind adjazent wenn es eine menge mit den $\{ v,v' \} \in E$ 
außerdem sind die Knoten $v,v'$  in einer Kante, dann sind diese die **Endpunkte**
**Grad / deg(v)**: ist die Anzahl der Nachbarn des Knoten
recherchiere **Inzidenz** alle von einem Knoten abgehenden Kanten mit diesem inzident

Lemma: (Handschlag Lemma)
Sei Graph $G = (V,E) \to \sum_{v \in V}   \deg(v) =2|E|$
___
Es gibt verschiedene Varianten von Graphen um verschiedenen Graphenvarianten  zu modellieren. Bis jetzt gab es **Einfache**, **Ungerichtete**, **Ungewichtete** Graphen beschrieben.
Weitere Graphen sind Unteranderem:
## Gerichtete Graphen:
Die kanten haben Richtungen. Sie gehen von einem Knoten zu einem anderen. definiert ist die Kanten Menge $E$ als $E=\{ (v,v') \}$ wobei dies ein Tupel ist und von v zu v' führt. v' ist hier der **direkte Nachfolger**. Die Anzahl der nachfolger ist der Ausgrad $deg_{out}(v)$, analog ist der Eingrad, die Anzahl der Kanten die zu dem Knoten $v$ führen.  
Lemma:
Da jede Kante in jeweils einem Knoten Ausgeht und eingeht gilt: $$\sum_{v\in V}deg_{in}(v)=\sum_{v\in V}deg_{out}(v)$$
___
## Multigraphen
Im gegensatz zu einfachen Graphen können Kanten Mehrfach vorkommen.
## Gewichtete Graphen
Es gibt gibnt zusätzliche Infromationen zu Teilen von Graphen. 
In der Vorlesung behandeln wir primär **kantengewichtete Graphen**, wir fügen zu jeder Kante ein Gewicht. $w:E\to\mathbb{R}$ 

___
# Speichern eines Graph
Da die Kanten eines Graphen eine nicht leere Menge. sind können wir für die Darstellung  im Computer die Elemente einfach durchnummerieren. Wie können daher Umwandeln in $\{ 1\dots n \}$.
Darstellung des Graphens
**Adjazenzmatrix**:
Die Knoten werden in einer $n\times n$ Matrix gespeichert-
Setzte $A[v,w] = true\iff \{ v,w \}\in E$ $\heartsuit$ 
![[Pasted image 20250627132444.png]]
Bei einfache Gewichteten Graphen können statt Wahr und Falsch die gewichte gespeichert werden. Nicht verbunden braucht einen gesonderten Eintrag der nicht null ist. z.B. -Infinity
$O(|V|^2)$ Speicher
$O(1)$ zeit
$O(|V|)$ Zeit um alle Nachbarn zu finden

**Adjazenzliste**: ist ein array über alle Knoten. In jedem Feld ist eine Liste, in welcher alle Adjazenten Knoten Gespeichert werden. Einfache Gewichtete Ungerichtete Graphen min der Adjazenzliste:
Wir speichern eine liste aus Zielknoten und Gewicht $(v', weight)$.
$\mathrm{O}(|V|+|E|)$ Speicher
$O(min~\{deg(v),deg(v')\})$ für die kanten Existenz zu finden
$O(def(v))$ für alle Nachbarn von V
___
# Graphen und Suche
## Tiefensuche:
Gehe soweit bis du nicht mehr Kannst, kehre Zurück bis du eine Abzweigung findest. 
```
dfs(v):
	for w in v.neighboars()do 
		if not w.found then
			w.found <- true
			dfs(w)
```
## Breitensuche:
Gehe einen Schritt in alle Richtungen, dann Zwei bis alles entdeckt wurde oder nur bereits besuchte Gab.

```
Q <- new Queue
for v in vertices() do
	v.found <- false
s.found <- true
Q.enqueue(s)
while not Q.isEmpty() do
	v <- Q.dequeue()
	//process v
	for w in v.neighbors() do
		if not w.found then
			w.found <- true
			Q.enqueue(w)
```
___
# Aufgaben und Probleme
## Kürzester Weg im Graphen
Sei $G = (V,E)$ ungewichtet Ungerichtet. Die Zwei Kanten $s,t \in V$ der Weg von $s$ nach $t$ 
Single Pair Shortest Path: SPSP ist erreichbar durch z.B.  BFS bis jnoten Gefunden Wurde.
 Ist Ein Teilproblem des Single Source Shortest Path.
Finde Alle Kürzesten Wege von S bis zu allen Anderen Knoten im Ruam. Bei der BFS wird vermerkt welche Knoten Vorgänger ist und dann geht man vom Zielknoten zurück.

**Teilpfad Optimalitäts Eigenschaft**
	Teilwege von Kürzesten Wegen sind Kürzeste Wege

Der Kürzeste Wege baum, ist der Baum, der entsteht wenn nur die BfS Durch geführt wird und die Kanten die Rückverweise Sind.

## Kürzeste Wege in Gewichtete Graphen:

Jede Kante $e$ hat eine Länge. $l(e)$. 
- Länge eines  Weges: v1,...,vk ist die Summe der Längen der Kanten $l(v_{1},\dots,v_{k})=\sum_{i=1}^{k-1}l(v_{i},{v_{i+1}})$
**Dijkstra Algorithmus**:
Ansatz: vor allem in der BFS für kanten, mit unterschiedlichen Längen, überprüfen.
Grundidee, wir starten ab einem Punkt. die Distanz eines Knoten ist die Distanz des jetzigen Knoten plus das Kantengewicht das zu diesem Knoten führt. 
Die Queue ist eine Priority Queue, Sortiert nach dem Abstand.
Am startknoten beginnen wir in dem wir alle nicht Benachbarten knoten enqueuen, Dann gehen wir zum Knoten mit der Geringsten Distanz. in der Prioqueue. 

Sollten wir über einen anderen Weg zu einem bereits besuchten Knoten kommen,  und der weg zum knoten Kürzer als der bisherige ist, müssen wir diesen Updaten.
```
Dijkstras Algorithmus
Q <- new Prioque()
for v in V do
	v.dist = infinity, v.prev = null, Q.insert(v,v,d)
	s.d:= 0, Qdecrease Key(s,sd)
while not Q.isEmpty do
	v:= extractMin()
		for for w in w.Neigbors() do
			if v.d+l(v,w) < w.d then
				w.d = v.d+l(v,w)
				w.prev = v
				Q.decreaseKey(w,w.d)  
```
$O((|V|+|E|)*lg|V|)$ Anahl der überprüfungen + Minheap operation
Die Laufzeit von Dijksra hängt von der Implementierunf des algorithmus ab und der Implementierung der Priowarteschlange,
- Es gibt $|V|$ inserts und extract mins 
- bis zu $|E|$ decrease keys (decrease key ist eher "update key" (key ist die distanz von w zu startknoten) )
Bessere Warteschlangen sind z.B. Fibunacci heaps  $O(|V|*log|V|+|E|)$ in der Theorie aber praktisch sind die kosntanten Faktoren,  so hoch dass die Fibunacci Heaps nicht schneller sind. In letzter zeit aber neue entwicklungen.

Korrektheit:
Wir bewiesen mit einer Schleifen-Invariante:
Die Invariante ist  
**Invaraiinte** Zu beginn gilt: 
- (V knoten Menge) (Q knoten in der schleife) Für alle $v \in VwithoutQ$ und für alle $w \in Q$ gilt $w.d \leq v.d$. (Der Kürzeste Vorläufige weg ist immer kleiner als der Mögliche Weg),
- Für jede Knoten $v \in V$ gilt i) $T_{i}(v) \neq \bot$ ist $\pi(v)$ ein weg von s nach v mit länge v.d sodass alle knoten $\pi(v)$ (außer sst) in V\Q liegen (die vorgänger zeiger liefern mir einen Vorläufigen Weg von s zu d und d.v ist die distanz von dem Weg )
	- wenn $\pi(v) = null$, dann ist  $v.d=\infty$ 
- Für alle Knoten die nichz mehr in der Prio Warteschalnge sind  habe ich die schnellsten Wege gefunden : ) $\nu$
while not Q.isEmpty do
	v:= extractMin()
		for for w in w.Neigbors() do
			if v.d+l(v,w) < w.d then
				w.d = v.d+l(v,w)
				w.prev = v
				Q.decreaseKey(w,w.d)  
___
## A* Algorithmus 
(im fall der Zusattzinformationen) Koordinaten oder Philologische Nähe
Verbesserung ders Dijkstra Algorithmus für den Fall, dass wir  nur das SPSP-Problem lösen möchten und Zusätzliche Informationen besitzen.
![[Pasted image 20250711123305.png]]
1. Beobachtung: Wenn wir eine kürzesten Weg $s,t$berechnen wollen sobald wir $t$ aus der Prioque entfernt haben.
2. Um einen Kürzesten Weg von Berlin nach Dresden zu finden bestimmt der Algorithmus von Daijkstra die Kürzeste Wege in Die Falsche Richtung. Dies ist Ineffizient da Dresden nicht in richtung Rostdock oder Hannover liegt. (bezogen auf da Tafelbild).
3. Formalisierung Die Information die wir jetzt nutzenn können, ist dass wir für jeden Kante in Graph Schnell den abstand "schätzen" können (Luftlinie) und wir bevorzugen teilweise Knoten die eine Kürzere Luftlinie Haben. 
Solche schätzer nennen wir **Heuristik**.

### Implementation
**Gegeben**: 
- gewichteten Graph  $G=(V,E)$ (Auch negative gewichte sind erlaubt : )))))))) )
- 2 Knoten $s,t \in V$
**Gesucht**: Kürzester Weg von $s$ nach $t$.
**Zusatzinformation**: Heuristik
$h:V\to \mathbb{R}^+_{0}$ 
$h(v)$ ist eine "Schätzung" für den Abstand von $v$ zu $t$ 
Unter der Annahme $h$ ist **Konsistent** für jede Kante $e=u,v\in K$ gilt $h(u)\leq h(v)+h(uv)$

```
Für alll e: = u,v in E:
	setzte e(uv) = (uv) + (h(v)-h(u))
	Führe Dijkstra auf G aus, mit den Angepassten Längen. 
	Brich ab, sobald sobald t aus PrioQueue entfernt wird. 
```


**Beweis**:
1. Ist Daijkstra Anwendbar ? 
H ist Konsistent 
$$
\begin{aligned} 
\forall e = uv\in E \\
h(u) \leq h(v)+h(uv)
= h(uv)+(h(v)-h(u)) \geq{0}
\end{aligned}
$$
Wieso ist die ls korrekt, einen kürzesten Weg bezüglich l' zu finden?
Sei $\pi: s = v_{1}\dots v_{k} =t$ beliebiger weg

$$
\begin{align}
l'(v_{1}v_{2})+l'(v_{2}v_{3})+l'(v_{1}v_{2})+\dots+l'(v_{k-1}v_{k})\\
= l(v_{1}v_{2}) + h(v_{2})-h(v_{1}) \\
\dots  \\
l(v_{k-1}v_{k}) + h(v_{k}-v_{k-1}) \\
\end{align}
$$
Die ist eine Teleskop summe Teile Die mittleren Therme weden von de vorherigen Elementen weggenommen.
$$
\begin{align}
= l(v_{1}v_{2})+l(v_{k-1},v_{k}) - h(v_{1})+h(k) \\
\end{align}
$\implies \text{alle Längen in } \pi+h(t)-h(s)$
$$

Wenn aber zu allen beliebigen wegen immer aditiv geffasst wird folgt dass sich die Weglängen ändern aber die Reihenfolge der Wege ändert sich nicht.
___
Multiplikatives Kantengewicht. Bro nimmer einfach den logarithmus der Kante dann wird immer aus Mult ein add.
Bsp ist ein wechselkurs von Währungen, : ) 
___
## Kürzesten Wege mit negativen Kantengewichten
In Graphen, $G=(V,E)$ die Längen gehen von $l:E\to \mathbb{R}$
Sei Startknoten $s \in V$ gesucht kürzester weg von $s$ nach $v$ für alle $v \in V$ (SSSP)
Macht dies Sinn=? 
was war ein weg von $s$ nach $t$ ? eine Folge von Konten welche mit Kanten verbunden sind
Länge des Weges ist: $\sum_{i=1}^{k-1}l(v_{i},v_{i+1})$ 
Kürzester Weg ist weg mit minimaler länger

Das Problem: gäbe es eine Kante mit negativer Kantenlänge, so wäre ein Kreislauf mit einer Länge $\leq0$ so wäre jeder durchlauf immer ein kürzer.
Lösung: 
	Lösung 1 (keine Doppelten Knoten)
	Entweder es existiert ein Kürzester Weg von $s$ zu $t$ oder es existiert einen kreis mit negativen Kantengewicht
### Algorithmus Belmman Fort
Liefert Bool der Negativen Kreis gibt oder gibt einen Kürzesten Wegebaum.
Die Negative Rücklieferung ist ein Zertifikat.
Idee:
Beachte Dijkstra Algorithmus
- Für Jede Kante: $v.d,v.\pi$ Anfang leere Wege $v.\pi=\bot,v.d=\infty$
- außer für s
Die verbesserung der Kanten erfolgt, wenn die sistanz zwoschen allemn Kandidaten kleiner ist als vorher.
Verbesere diese kandidatendurh die Operation improve (l=iv)
	Algorithmus von Bellemond Fort Sagt: Führe Improve für alle Kanten durch: 
``` python 
	for v in V do
		v.pi:= infinity
	s.d=0
	for i = 1 to |V|-1 do
		for e in E do
			improve (e)
	improve (e) =
		if w.d < v.d+l(vw) then
			w.d = v.d +l(vw)
			w.pi=v
```
### SSSP in DAGs
gegeben: grichterter Graph $G=(V,F)$ 
kantenlänge $\forall s \in V~|~l:E\to \mathbb{R}$
er Enthält keine Kreise somit auch keine Negativen Kreise.
Kürzeste Wege finden. 
Fakt jeder DAG besitzt eine Topologische Sortierung. 
Ameider Kante auf der x Achse dass alle kanten im links nach rechts geben.
___
# Graphen und Spiele
Gesellschaftsspiele Lassen sich als Graph Drarstellen und mithilfe von Algorithmen lösen. : )
1 Spieler Siel mit voller Intermation.
Lassen sich als Graph Darstellen.
Knoten: alle Zustände des Spielbretts
Kanten: Züge von einen State zum Anderen
Spiel, Finde Züge die mich von einenm State zum Gewinn führt.
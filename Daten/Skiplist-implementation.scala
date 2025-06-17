// Abgabe Immanuel, Anna Tamina Freiin von Steitcorn, Marcel
class Skiplist[A,B]:
    private class Node[A,B](var key: Double, var value: String,var next: Node[A,B],  var down: Node[A,B]) // N soll Node sein, kann aber so nicht implementiert werden 
    private class Liste():
        private var size: Int = 0
        // private val level: Int = level_
        // val dummyfordummy: B = null // Dummy value for dummy nodes
        // heading
        private var head: Node[A,B] = null //(0,"head",null , null, null) // Dummy node
        private var tail: Node[A,B] = null //(100000,"tail", null , null, null) // Dummy node
        head = Node[A,B](Double.NegativeInfinity, "Dummyh", tail, null)
        tail = Node[A,B](Double.PositiveInfinity, "Dummyt", null, null)
        
        // connecting the dummy nodes
        head.next = tail
        head.down = null
        tail.down = null
        def getHead(): Node[A,B] = head
        def getTail(): Node[A,B] = tail
    
   
   // Basis Liste
    private val list0 = new Liste()
    private var maxlevellist:Int = 0
    private var size: Int = 0
    private var maxlist = list0
    private var headnode: Node[A,B] = list0.getHead()

    // Private funktionen
    private def insert(linkerknoten:Node[A,B], neuk: Double, neuv: String,rechterknoten:Node[A,B]): Unit =
        var newnode: Node[A,B]= new Node[A,B](neuk,neuv,rechterknoten,null) 
        linkerknoten.next = newnode
    
    private def randomlevel():Int =
        val random = scala.util.Random
        var level: Int = 0
        while random.between(0,2) == 1 do
            level += 1
        level
        

    private def newlevel(): Unit =
        maxlevellist = maxlevellist + 1
        var neueslevel = new Liste()

        neueslevel.getHead().down = maxlist.getHead()
        neueslevel.getTail().down = maxlist.getTail()
        maxlist = neueslevel
        headnode = maxlist.getHead()


    def isempty: Boolean = size == 0 
    
    private def traversierung (target:Double):Node[A,B] =
        var current: Node[A,B] = headnode
        var abbruch: Boolean = false // fußgesteuert sieht echt weird aus. so ists einfacher zu lesen  
        while abbruch == false do 
            current = sameleveltravers(current,target)
            if current.down != null then 
                current = current.down
        
            if current.down == null && target < current.next.key then
                abbruch = true
        current

    private def sameleveltravers(startnode:Node[A,B], schlussel: Double): Node[A,B] =
        var momentane: Node[A,B] = startnode
        while schlussel >= momentane.next.key do
            momentane = momentane.next
        momentane
    private def sameleveltraversexclusivekey(startnode:Node[A,B], schlussel: Double): Node[A,B] =
        var momentane: Node[A,B] = startnode
        while schlussel > momentane.next.key do
            momentane = momentane.next
        momentane

    // Öffentliche funktionen  
    def put(key: Double, value: String): Unit =
        var current: Node[A,B] = traversierung(key)
        
        
        if current.key == key then //entweder updaten
            current.value = value 
        else // neuenschlüsel einfügen
            
            val levelhoe: Int = randomlevel() // höhe finden
            // println("level höhe" + " " + levelhoe)
            // println("maxlevellist "+ " " + maxlevellist)

            if levelhoe > maxlevellist then // ggf. neue Level einfügen
                while levelhoe > maxlevellist do
                    newlevel()

            // println("maxlevellist "+ " " + maxlevellist)

            current = maxlist.getHead()
            
            // println("compstart ")
            // for i <- levelhoe to maxlevellist-1 do println(i) // zum hoechsten level finden
            // println("compstart end")


            for i <- levelhoe to maxlevellist-1 do // zum hoechsten level finden
                current = current.down
            var uppernode: Node[A,B] = null
           
           
            while current.down != null do // traversiert bis zum zweit untersten level, da dort value null sein soll
                current = sameleveltravers(current, key)
                insert(current, key, null,current.next) // neuenschlüsel einfügen
                if uppernode != null then uppernode.down = current.next

                uppernode = current.next
                current = current.down
                

            // beigntt die traversierung in der Untersten schleife damit die 
            current = sameleveltravers(current, key)
            insert(current, key, value,current.next) // neuenschlüsel einfügen
            if uppernode != null then uppernode.down = current.next



            size += 1
            // println("fertig von einfügen von "+ key)

    def get(schlussel: Double): String = 
        val position: Node[A,B] = traversierung(schlussel)
        // println(position.key)
        if position.key == schlussel then
            position.value // stellt sicher dasss schlüssel nur ausgegeben wird falls schlüssel auch vorhanden
        else
            null // schlüssel nicht da kein Problem <3

    def delete (schluessel: Double):Unit = 
        def verbinden(linkerknoten: Node[A,B], rechterknoten: Node[A,B]): Unit =
            linkerknoten.next = rechterknoten
        
        var smthdeleted: Boolean = false
        var current: Node[A,B] = headnode
        var previous: Node[A,B] = headnode 

        while current != null do
            current = sameleveltravers(current,schluessel)
            previous = sameleveltraversexclusivekey(previous,schluessel)
            if current.key == schluessel then 
                verbinden(previous, current.next)
                smthdeleted = true
            current = current.down
            previous = previous.down
        
        if smthdeleted == true then
            size -= 1

        else
            println("Nicht gefunden") // Key not found, nothing to delete

    def next(key: Double): String =
        val position: Node[A,B] = traversierung(key)
        if position.next.key != Double.PositiveInfinity then
             position.next.value
        else null
    
    def prev (key: Double): String =
        var current: Node[A,B] = headnode
        var abbruch: Boolean = false // fußgesteuert sieht echt weird aus. so ists einfacher zu lesen  
        while abbruch == false do 
            current = sameleveltravers(current,key)
            
            if current.down != null then 
                current = current.down
        
            if current.down == null && key <= current.next.key then
                abbruch = true
        current.value

    def printlist(): Unit =
        println("Die momentane Liste:")
        var firstnode: Node[A,B] = headnode
        var printLevel: Int = maxlevellist
        var current: Node[A,B] = headnode
        while firstnode != null do
            println(" ")
            println(printLevel) 
            current = firstnode
            while current != null do  
                print(current.key)
                print (" ")
                current = current.next
            printLevel = printLevel -1
            firstnode = firstnode.down
        println()
        println("Ende der liste")

    def test():Unit =
        // println(randomlevel()) // 
        // def testtraversierung(): = 
   
        // get(0.1) //
        put(1.0, "one")
        // printlist()
        put(2.4, "sdf")
        // printlist()
        put(35.0,"34")
        put(36.0,"34")
        put(31.0,"34")
        put(3522.0,"34")

        put(8.6, "8,6")
        put(0.5, "prev")
        // printlist()
        put(15.0, "Hallo")
        // delete(0.5)
        printlist()

        // println(list0.getHead().next.key)
        // print(headnode.next.key)
        // print(headnode.next.next.key)
        // print(headnode.next.next.next.key)
        // print(headnode.down.next.key)
        // println(headnode.down.next.key)


        // println(get(2.4)) 
        // println(traversierung(1.0).key) 
        // println(get(1.0)) 


@main def runSkiplist(): Unit =
    val myList = new Skiplist[Double, String]
    myList.test()
    myList.put(23.2,"Esay")
    myList.put(7654.2,"Esay")

    myList.put(3.2,"Esay")

    myList.put(45.2,"Esay")

    myList.put(7.2,"Esay")

    myList.put(6.2,"Esay")

    myList.put(2.2,"Esay")
    myList.delete(2.2)
    println(myList.get(15.0))
    println(myList.next(15.0))
    println(myList.prev(15.0))
    
    myList.printlist()
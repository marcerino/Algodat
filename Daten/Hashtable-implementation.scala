class Hashtable[A,B](_size: Int): 
    class Listen[A,B]:
        private class Node[A,B](var key: A, var value: B, var next: Node[A,B]) // N soll Node sein, kann aber so nicht implementiert werden 

        private var head: Node[A,B] = null //(0,"head",null , null) // Dummy node
        private var size: Int = 0

        def gethead(): (A,B) = 
            if head != null then
                (head.key,head.value)
            else (null.asInstanceOf[A],null.asInstanceOf[B])

        private def connect(leftnode:Node[A,B],rightnode:Node[A,B]): Unit =
            leftnode.next = rightnode

        private def exclusivetraversierung(k: A): Node[A,B] =
            var position: Node[A,B] = head
            if size != 0 then
                
                while position.next != null do 
                    if k == position.key then 
                        return position
                    else position = position.next
                position
            else return null


        private def traversierung(k: A): Node[A,B] =
            var position: Node[A,B] = head
            while position != null do 
                if k == position.key then 
                    return position
                else position = position.next
            position

        def putinlist(key: A, value:B): Unit =
            var position = head
            if size == 0 then 
                head = Node[A,B](key,value,null)
                size = size +1
            else 
                while position.next != null do
                    if position.key == key then
                        position.value = value
                        return
                    position = position.next
                if position.key == key then
                    position.value = value
                else 
                    connect(position,Node[A,B](key,value,null))
                    size = size +1

                
        
        def getinlist(key: A): B =
            val position = traversierung(key)
            if position == null then 
                return null.asInstanceOf[B]
            else if position.key == key then
                return position.value
            else null.asInstanceOf[B]


        def deleteinlist(key: A): Unit =
            // println("deletelist hat gestartet")
            var position = head
            if size == 0 then
                println("Nicht in Table")
                return

            else if position.key == key then
                head = head.next
                size = size - 1
                return

            else 
                while position.next != null do
                    if position.next.key == key then
                        position.next = position.next.next
                        size = size -1
                        return

                    position = position.next

            println("Nicht in Liste somit nicht löschbar") 

        
    //hashparameter
    var m: Int = _size
    var elementein: Int = 0
    var ladefaktor: Double = 0.0
    // println(m)
    
    // Initiation des Hashtables
    var  theHashtable: Array[Listen[A, B]] = new Array[Listen[A, B]](m)
     //var a: Hashtable[] = new Array[Listen[A,B]](m)
    
    def fillHashtable(deep:Int, tabelle: Array[Listen[A,B]]): Unit =
        var iteration = 0
        while iteration < deep do
            tabelle(iteration) = new Listen[A,B]
            iteration  = iteration+ 1
    // füllen des Hashtables
    fillHashtable(m,theHashtable)

    private def dynamischerrezise(): Unit =
        if elementein > 20 then
            println("rezise good")
            ladefaktor =  elementein/m
            // ladefaktor = 5 // for testing
            if ladefaktor < 1.0 || ladefaktor > 3.0 then
                
                var neum: Int =  (elementein/2).toInt
                if neum < 1 then neum = 1
                // neum = 4 // for testing bla bla bla

                var  Temptable: Array[Listen[A, B]] = new Array[Listen[A, B]](neum)
                fillHashtable(neum,Temptable)

                def putintemp(key:A,value:B) =
                    Temptable(kompression1(key,neum)).putinlist(key,value)
                    // Temptable(kompression2(key,neum)).putinlist(key,value)
                    

                var keycase: (A,B) = (null.asInstanceOf[A],null.asInstanceOf[B])
                for i <- 0 until m do

                    keycase = theHashtable(i).gethead()
                    while theHashtable(i).gethead() != (null,null) do
                        keycase = theHashtable(i).gethead()
                        putintemp(keycase(0), keycase(1))
                        delete(keycase(0))
                        println("hashtabellen übertragen")
                
                //Änderungen zu neuen Specs
                m = neum
                theHashtable = Temptable
        return


    def kompression1( Inputkey :A, hashtabellengroese :Int ):Int =
        return (Inputkey.hashCode().abs)%hashtabellengroese

    def kompression2(Inputkey : A, hashtabellengroese: Int): Int =
        return ((Inputkey.hashCode().abs)%hashtabellengroese+13) %hashtabellengroese

    def put(key: A,value: B): Unit = 
        theHashtable(kompression1(key,m)).putinlist(key,value)
        // theHashtable(kompression2(key,m)).putinlist(key,value)

        elementein = elementein +1
        dynamischerrezise()
    def get(key: A): B = 
        if  theHashtable(kompression1(key,m)).getinlist(key) != null then
            theHashtable(kompression1(key,m)).getinlist(key)
        // if  theHashtable(kompression2(key,m)).getinlist(key) != null then
        //     theHashtable(kompression2(key,m)).getinlist(key)

        else 
            println("not in List")
            null.asInstanceOf[B]
        
    def delete(key:A): Unit =
        if get(key:A) != null then
            theHashtable(kompression1(key,m)).deleteinlist(key)
            // theHashtable(kompression2(key,m)).deleteinlist(key)
            elementein = elementein -1
            dynamischerrezise()



@main def newHashtabelle(): Unit =
    val myTable = new Hashtable[String,String](1)
    println("Test Start:")
    // println(myTable.kompression1("123",1))
    myTable.put("123","23")
    myTable.put("41","41")
    myTable.put("12","41")
    myTable.put("423","41")
    myTable.put("4456","41")

    myTable.put("6853","41")
    myTable.put("6223","41")

    myTable.put("4523","41")
    myTable.put("11111","41")
    myTable.put("0923","41")
    myTable.put("7429","41")
    myTable.put("2","41")
    myTable.put("1233123","41")
    myTable.put("4542231512","41")
    myTable.put("92837","41")
    myTable.put("346672","41")
    myTable.put("987273","41")
    myTable.put("7239402","41")
    myTable.put("92783662","41")
    myTable.put("9827738827","41")
    myTable.put("4222222","41")

    
    // myTable.delete("41")
    // myTable.delete("44")
    // myTable.delete("46")
    // myTable.delete("124")

    println(myTable.get("123"))
    println(myTable.get("41"))

    println("Test Ende:")

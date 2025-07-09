import scala.math._
import scala.util._
class Node(var value: String,var next: Node, var nonce: Int, var hashref:Int ) // N soll Node sein, kann aber

class Kyrptoverkettetelist:

    class Node(var value: String,var next: Node, var nonce: Int, var hashref:Int ): // N soll Node sein, kann aber
        def makenonce(): Unit =
            var corestring: String = null
            if next == null then
                corestring = (value)
            else
                corestring = (value+next.hashref.toString)

            var braking: Boolean = false
            val r = new scala.util.Random
            var newstring: String = null 
            var binarystring: String = null
            var neuelenge: Int = 0 
            while braking == false do 
                nonce = r.nextInt() 
                newstring = (corestring+nonce.toString)
                hashref = hashing(newstring)
                binarystring = hashref.toBinaryString
                neuelenge = binarystring.length
                if neuelenge >= 8 then
                        
                    println(binarystring.takeRight(8))
                    if binarystring.takeRight(8).contains("1") == false then
                        println(binarystring.takeRight(8))
                        braking = true

        makenonce()


    private def hashing(input: String): Int =
        if input == null then
            return 999999999
        else
            return (math.pow(((input.hashCode())).toDouble, 26) %999999999).toInt


    var head: Node = Node("Dummynode",null, 124, 123)

    def put(inputstring: String): Unit =
        val neuenode: Node = Node(inputstring,head, 123, 123) 
        head = neuenode

    def delete():Unit = 
        if head.next != null then
            head = head.next

    // def validate(pruefling: Node): Boolean = 
    //     if pruefling.next == null then
    //         return equals(pruefling.hashref, hashing(pruefling.value+(pruefling.next.hashref).toString)) 
    //     else true

@main def Kryptotoests(): Unit =
    var mylist:Kyrptoverkettetelist = new Kyrptoverkettetelist 
    mylist.put("weeeeeeee")
    // mylist.put("woooooooooo")
    // mylist.put("weeeeeeee")
    // mylist.put("wooooooooooo")
    println(mylist.head.hashref.toBinaryString)
    // print(mylist.head.hashref)
    // print(mylist.head.next.hashref)
    // print(mylist.head.next.next.hashref)


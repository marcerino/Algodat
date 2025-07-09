import java.io.PrintWriter

  



import scala.io.Source
val  path:String =  """moby.txt"""
def readFileAsString(path: String): String = 
  val source = Source.fromFile(path, "UTF-8") // Specify encoding
  try source.mkString.replaceAll("\r?\n", " ")  finally     source.close()


import math.pow
def searchcountforwhale():Unit =
 

    def searchcountnaive(text: String, passage: String): Int =
        if passage.length > text.length then return 0
        var matches: Boolean = false 
        val passagelen:Int = passage.length
        var startindex: Int = 0
        var iterationsindex: Int = 0
        var counter: Int = 0

        while startindex < (text.length - passage.length+1) do
            while iterationsindex < passagelen && text(startindex + iterationsindex) == passage(iterationsindex) do
                iterationsindex = iterationsindex+1
            
            if iterationsindex == passagelen then
                counter = counter +1 

            iterationsindex = 0
            startindex = startindex+1

        // println(counter)
        return counter

    def searchcountkarp(text: String, phrase: String): Int = 
        if phrase.length > text.length then return 0

        def hashington(input: Char): Int =
            pow(input.hashCode(),5).toInt %67547
        
        var phashcode: Int = 0
        var pruefhashcode: Int = 0
        var counter: Int = 0
        var iterationsindex: Int = 0

        // wir berechenn nun den Match passcode
        for i <- phrase do
            phashcode = phashcode + hashington(i)

        // println(phashcode)

        // basic phrase builder
        for i <- text.substring(0,phrase.length) do 
            pruefhashcode = pruefhashcode + hashington(i)
        
        // if phashcode == pruefhashcode then counter = counter +1

        var indexpunkt: Int  = 0
            while indexpunkt < text.length-phrase.length+1 do
                pruefhashcode = pruefhashcode - hashington(text(indexpunkt)) + hashington(text(indexpunkt+phrase.length-1))
                if pruefhashcode == phashcode then
                    while iterationsindex < phrase.length && text(indexpunkt+ iterationsindex) == phrase(iterationsindex) do
                        iterationsindex = iterationsindex+1
                
                    if iterationsindex == phrase.length then
                        counter = counter +1 
                    iterationsindex = 0

                indexpunkt = indexpunkt+1
    


        // println(counter)
        return counter 

    //angabe des Textes

    def searchsetscountkarp(text: String, phrase: List[String]): Array[Int] = 
        // var longenough : Boolean = true
        // for i <- phrase do
        //     if i.length > text.length then longenough = false

        // if longenough == false  then return Array[](0)

        def hashington(input: Char): Int =
            // if input == ' ' then 241
            pow(input.hashCode(),5).toInt %285631
        
        var phashcode: Int = 0
        var pruefhashcode: Int = 0
        var counter: Int = 0
        var iterationsindex: Int = 0
        var phrasenhashliste: List[Int] = List()
        var phraselengts: List [Int] = List()

        for i <- phrase do
            phraselengts = phraselengts ++ List (i.length)
        // println(phraselengts)
        
        // wir berechenn nun den Match passcode
        for teilphrase <- phrase do
            for i <- teilphrase do
                phashcode = phashcode + hashington(i)
            phrasenhashliste = phrasenhashliste ++ List(phashcode)
            phashcode = 0

        // println(phrasenhashliste)


        // // if phashcode == pruefhashcode then counter = counter +1
        var hashsize: Int = 0
        var indexpunkt: Int  = 0
        var patternindex:Int = 0
        var resultarray: Array[Int] = new Array[Int](phrase.length)
        

        while indexpunkt < text.length do
            patternindex = -1

            for pattern <- phrase do 
                patternindex = patternindex +1
            // es folgt der Hashresize
                if pattern.length + indexpunkt <= text.length then
                    // pruefhashcode = 0  // <-- JETZT hier!
                    // hashsize = 0       // <-- auch hier!
                    while hashsize != pattern.length do
                        if hashsize < pattern.length then 
                            pruefhashcode = pruefhashcode + hashington(text(indexpunkt+hashsize))
                            hashsize = hashsize+1
                        if hashsize > pattern.length then
                            pruefhashcode = pruefhashcode - hashington(text(indexpunkt+hashsize-1))
                            hashsize= hashsize -1

                    if pruefhashcode == phrasenhashliste(patternindex) then
                        while iterationsindex < pattern.length && text(indexpunkt+ iterationsindex) == pattern(iterationsindex) do
                            iterationsindex = iterationsindex+1
                    
                        if iterationsindex == pattern.length then
                            resultarray(patternindex) = resultarray(patternindex) + 1 
                        iterationsindex = 0
            pruefhashcode = pruefhashcode - hashington(text(indexpunkt))
            hashsize = hashsize -1
            indexpunkt = indexpunkt+1
    


        // println(counter)
        return resultarray 

    //angabe des Textes



    // val thewhiteelder: String = findthewhale()
    var start = System.nanoTime()
  
    // println(searchcountnaive(readFileAsString("""moby.txt"""),"whale"))
    // var end = System.nanoTime()
    // var duration = end - start
    // println(duration)
    // start = System.nanoTime()

    // println(searchcountkarp(readFileAsString("""moby.txt"""),"whale"))
    // end = System.nanoTime()
    // duration = end - start
    // println(duration)
    var eingabeliste : List[String] = List("sense","sensible","sensibility")
    var resultatarray: Array[Int] = searchsetscountkarp(readFileAsString("""sense.txt"""),eingabeliste)
    // var eingabeliste : List[String] = List("sense","yes","no","o","ye","p","onononononononononono")
    // var resultatarray: Array[Int] = searchsetscountkarp("yesnononononononononononononononononoooooooooononononononn nyeaaaaaaaapppp",eingabeliste)

    var eingabelistenindex = -1
    for wort <- eingabeliste do
        eingabelistenindex = eingabelistenindex +1
        println(wort+ " : " + resultatarray(eingabelistenindex).toString )
@main def main(): Unit =
    searchcountforwhale()
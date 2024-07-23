@main def main() = {
    println(formatNames("Benny", toUpper))        
    println(formatNames("Niroshan", customFormat1)) 
    println(formatNames("Saman", toLower))         
    println(formatNames("Kumara", customFormat2))  
}


def toUpper(word: String): String = word.toUpperCase

def toLower(word: String): String = word.toLowerCase

def formatNames(name: String, formatFunc: String => String): String = formatFunc(name)


def customFormat1(name: String): String = {
    val chars = name.toCharArray
    if (chars.length > 1) chars(1) = chars(1).toUpper
    new String(chars)
}

def customFormat2(name: String): String = {
    val chars = name.toCharArray
    if (chars.length > 5) chars(5) = chars(5).toUpper
    new String(chars)
}

@main def main() = {
    println(formatNames("Benny", toUpper))        
    println(formatNames("Niroshan", customFormat)) 
    println(formatNames("Saman", toLower))         
    println(formatNames("Kumara", anotherFormat))  
}


def toUpper(word: String): String = word.toUpperCase

def toLower(word: String): String = word.toLowerCase

def formatNames(name: String, formatFunc: String => String): String = formatFunc(name)


def customFormat(name: String): String = {
    val chars = name.toCharArray
    if (chars.length > 1) chars(1) = chars(1).toUpper
    new String(chars)
}

def anotherFormat(name: String): String = {
    val chars = name.toCharArray
    if (chars.length > 4) chars(4) = chars(4).toUpper
    new String(chars)
}

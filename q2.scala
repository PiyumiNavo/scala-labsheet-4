@main def main() = {
    print("Enter a number : ")
    val userInput = scala.io.StdIn.readInt()

    userInput match {
        case x if(x <= 0 ) => println("Negative/Zero")
        case x if(x%2 == 0) => println("Even number")
        case x if (x%2 != 0) => println("Odd number")
        case _=> println("Not a number")
    }
}
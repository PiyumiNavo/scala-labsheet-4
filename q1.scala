@main def main() = {
    restockItem("Apples", 10)
    displayInventory(item_names, item_quantities)
    sellItem("Bananas", 10)
    displayInventory(item_names, item_quantities)
}
var item_names = List("Apples", "Bananas", "Oranges", "Grapes", "Milk", "Bread", "Eggs", "Cheese", "Tomatoes", "Potatoes")
var item_quantities = List(50, 30, 40, 20, 10, 25, 60, 15, 35, 45)


def displayInventory(itemArr: List[String], quantityArr: List[Int]): Unit = {
    itemArr match {
        case Nil => println("Inventory is empty")
        case head :: tail =>
            println(s"$head\t\t\t${quantityArr.head}")
            displayInventory(tail, quantityArr.tail)
    }
}

def restockItem(itemName: String, itemQuantity: Int): Unit = {
    def updateQuantities(names: List[String], quantities: List[Int]): (List[String], List[Int]) = {
        (names, quantities) match {
            case (Nil, Nil) => (List(itemName), List(itemQuantity))
            case (head :: tail, qHead :: qTail) =>
                if (head == itemName) (names, (qHead + itemQuantity) :: qTail)
                else {
                    val (updatedNames, updatedQuantities) = updateQuantities(tail, qTail)
                    (head :: updatedNames, qHead :: updatedQuantities)
                }
            case _ => (names, quantities)
        }
    }

    val (newNames, newQuantities) = updateQuantities(item_names, item_quantities)
    item_names = newNames
    item_quantities = newQuantities
}

def findItemIndex(itemName: String, items: List[String], index: Int = 0): Option[Int] = {
    items match {
        case Nil => None
        case head :: tail =>
            if (head == itemName) Some(index)
            else findItemIndex(itemName, tail, index + 1)
    }
}

def sellItem(itemName: String, itemQuantity: Int): Unit = {
    findItemIndex(itemName, item_names) match {
        case Some(index) =>
            if (item_quantities(index) >= itemQuantity) {
                item_quantities = item_quantities.updated(index, item_quantities(index) - itemQuantity)
                println(s"Sold $itemQuantity of $itemName")
            } else {
                println(s"Not enough quantity of $itemName to sell")
            }
        case None => println(s"$itemName does not exist in inventory")
    }
}

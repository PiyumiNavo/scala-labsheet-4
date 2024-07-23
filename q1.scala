@main def main():Unit = displayInventory()

var itemNames = Array("Apple", "Mango", "Banana", "Biscuit", "Grapes")
var itemQuantity = Array(50, 25, 10, 35, 25)
var numItems = itemNames.length 

def displayInventory(n:Int = 0):Unit =
    n match{
        case x if numItems == 0 => println("Inventory is Empty")
        case x if x == numItems -1  => printf("%s \t %d\n",itemNames(n), itemQuantity(n))
        case _ => {
            printf("%s \t %d\n",itemNames(n), itemQuantity(n))
            displayInventory(n+1)
        }
    }


def restockItem(itemName:String, quantity:Int, n:Int = 0):Unit =
    n match{
        case x if x == numItems  => printf("Item Name Not Found\n")
        case x if itemNames(n) == itemName => {
            itemQuantity(n)+= quantity
            printf("---------------------\nItem Updated\n--------------------\n")
        }
        case _ => {
            restockItem(itemName:String, quantity:Int, n+1)
           
            
        }
    }

def sellItem(itemName:String, quantity:Int, n:Int = 0):Unit =
    n match{
        case x if x == numItems  => printf("Item Name %s Not Found\n",itemName)
        case x if itemNames(n) == itemName => {
            itemQuantity(n)-= quantity
            printf("-------------\nItem Updated\n--------------\n")
        }
        case _ => {
            sellItem(itemName:String, quantity:Int, n+1)
           
            
        }
    }

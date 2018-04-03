class Node(data: Int) {
    var data: Int = data
    var next: Node? = null
}

class LinkedList {

    var head: Node? = null

    fun append(data: Int) {
        var newNode = Node(data)
        if (head != null) {
            var tmp = head;
            var current: Node? = null
            while (tmp != null) {
                current = tmp
                tmp = tmp.next
            }
            current?.next = newNode
        } else {
            head = newNode
        }
    }

    fun printAll() {
        var tmp = head
        while (tmp != null) {
            println(tmp.data);
            tmp = tmp.next
        }
    }

}

fun main(args: Array<String>) {
    var list = LinkedList()

    list.append(1)
    list.append(2)
    list.append(3)
    list.append(4)

    list.printAll()
}
package main

import "fmt"

// Node struct ..
type Node struct {
	data int
	next *Node
}

// List struct
type List struct {
	head *Node
}

var node *Node

//Add ....
func Add(data int) {
	var current *Node
	n := Node{data, nil}
	if node == nil {
		node = &n
	} else {
		temp := node
		for temp != nil {
			current = temp
			temp = temp.next
		}
		current.next = &n
	}
}

//Remove ...
func Remove(data int) {
	var prev *Node
	temp := node
	for temp != nil {
		if temp.data == data && temp.next != nil {
			//checking for head
			if prev == nil {
				node = node.next
				return
			}
			prev.next = temp.next
			return

		} else if temp.data == data && temp.next == nil {
			prev.next = nil
			return
		}

		prev = temp
		temp = temp.next

	}
}

// PrintList ...
func PrintList() {
	temp := node
	for temp != nil {
		fmt.Printf("%d ", temp.data)
		temp = temp.next
	}

}

func main() {
	Add(1)
	Add(2)
	Add(3)
	Add(4)
	PrintList()
	Remove(3)
	PrintList()
}

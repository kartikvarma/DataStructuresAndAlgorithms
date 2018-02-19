#ifndef LINKED_LIST_H
#define LINKED_LIST_H
#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
  int data;
  struct Node* next;
}Node;

void insert(Node** head, int data);

int length(Node *head);

// deletes the last node by default.
void delete(Node **head);

void printList(Node* head);

#endif

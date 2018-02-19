#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

void insert(Node** head, int data)
{
   Node *newNode = (Node *)malloc(sizeof(struct Node));
   newNode->data = data;
   newNode->next = NULL;
  if (!newNode)
  {
   printf("Memory Error.");
   return;
  }

  if(*head == NULL)
  {
     *head = newNode;
     return;
  }
  else
  {
    Node* current = *head;
    Node* previous = NULL;
    while(current != NULL)
    {
        previous = current;
        current = current->next;
    }  
    previous->next = newNode;
  }
}

int length(Node *head)
{
    int count = 0;
    while (head != NULL)
    {
        count++;
        head = head->next;
    }
    return count;
}


// deletes the last node by default.
void delete(Node **head)
{
    Node* current = *head;
    Node* temp = NULL;
    for(int i = 0; i < length(*head)-2; i++)
    {
        current = current->next;
    }

    temp = current->next;
    current->next = NULL;

    free(temp);
}


void printList(Node* head)
{
  printf("{");
  while(head != NULL)
  {
      printf("%d ",head->data);
      head = head->next;
  }
  printf("}\n");
}


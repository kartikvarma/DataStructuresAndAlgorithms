#include <stdio.h>
#include <stdlib.h>
#include "Queue.h"

Queue *createQueue()
{
  Queue *newQueue = (Queue *)malloc(sizeof(Queue));
  if (!newQueue)
    return NULL;
  newQueue->front = NULL;
  newQueue->rear = NULL;
  return newQueue;
}

int isEmpty(Queue *q)
{
  return (q->front == NULL);
}

int size(Queue *q)
{
  if (isEmpty(q))
  {
    printf("Empty Queue");
    return 0;
  }
  int count = 1;
  ListNode *temp = q->front;
  while (temp!= q->rear)
  {
    count++;
    temp = temp->next;
  }
  return count;
}

//adds a new node to the end of the queue
void enqueue(Queue *q, int data)
{
  ListNode *newNode = (ListNode *)malloc(sizeof(ListNode));
  if (!newNode)
  {
    return;
  }
  newNode->data = data;

  if (q->rear)
  {
    q->rear->next = newNode;
    q->rear = q->rear->next;
  }
  else
  {
    q->rear = newNode;
  }

  if (q->front == NULL)
  {
    q->front = q->rear;
  }
}

// removes a node from the start of the queue.
int dequeue(Queue *q)
{
  int data = 0;
  ListNode *temp;
  if (isEmpty(q))
  {
    printf("Empty Queue");
    return 0;
  }
  else
  {
    temp = q->front;
    data = q->front->data;
    q->front = q->front->next;
    free(temp);
  }

  return data;
}

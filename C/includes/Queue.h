#ifndef QUEUE_H
#define QUEUE_H

#include <stdio.h>

typedef struct ListNode
{
  int data;
  struct ListNode *next;
} ListNode;

typedef struct Queue
{
  ListNode *front;
  ListNode *rear;
}Queue;

Queue *createQueue();

int isEmpty(Queue *q);

int size(Queue *q);

void enqueue(Queue *q, int data);

int dequeue(Queue *q);

#endif // !QUEUE_H

#include <stdio.h>
#include <stdlib.h>
#include "includes/Queue.h"

int main()
{
  Queue *q = createQueue();
  enqueue(q, 5);
  enqueue(q, 7);
  enqueue(q, 8);
  enqueue(q, 10);
  printf("Size of queue is %d.\n", size(q));
  printf("Popped value %d from queue.\n", dequeue(q));
}

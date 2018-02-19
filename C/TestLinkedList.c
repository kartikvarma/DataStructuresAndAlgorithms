#include <stdio.h>
#include <stdlib.h>
#include "includes/LinkedList.h"

int main()
 {
   Node* head = NULL;
   insert(&head, 2);
   insert(&head, 4);
   insert(&head, 6);
   insert(&head, 8);
   printList(head);
   delete(&head);
   printList(head);
   return 0;
 }

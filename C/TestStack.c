#include <stdio.h>
#include <stdlib.h>
#include "includes/Stack.h"

int main() {

    Stack *s = NULL;
    push(&s,5);
    push(&s,7);
    push(&s,8);
    printf("Size of stack is %d.\n",size(s));
    printf("Top of the stack is %d.\n",top(s));
    printf("Popped value %d from stack.\n",pop(&s));
    printf("Size of stack after pop is %d.\n",size(s));
}

#include <stdio.h>
#include <stdlib.h>
#include "Stack.h"

void push(Stack **top, int data){
    Stack *temp = (Stack*)malloc(sizeof(struct Stack));
    if(!temp) return;
    temp->data = data;
    temp->next = *top;
    *top = temp;
}

int isEmpty(Stack *top){
    return top == NULL;
}


int pop(Stack **top){
    int data = 0;
    Stack *temp;
    if(isEmpty(*top)) return -1;
    temp = *top;
    *top = (*top)->next;
    data = temp->data;
    free(temp);
    return data;
}

int top(Stack *top){
    if(isEmpty(top)) return -1;
    return top->data;
}

int size(Stack *top){
    int count = 0;
    Stack *temp = top;
    while(temp != NULL){
      count++;
      temp = temp->next;
    }
    return count;    
}

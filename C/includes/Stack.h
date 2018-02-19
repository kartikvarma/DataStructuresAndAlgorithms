#ifndef STACK_H
#define STACK_H

#include <stdio.h>
#include <stdlib.h>

typedef struct Stack{
    int data;
    struct Stack *next;
}Stack;

void push(Stack **top,int data);

int isEmpty(Stack *top);

int pop(Stack **top);

int top(Stack *top);

int size(Stack *top);

#endif

#include <iostream>
#include <stack>
#include <string>
#include <array>

using namespace std;

const size_t arraySize = 0;

int* findSpansIterative(int sequence[], int n){
  int spans[n]; 
  int j;
  for(int i = 0; i < n; i++){
    j = 1;
    while(j <= i && sequence[j] < sequence[i]){
      j = j +1;
    }
    spans[i] = j;
  }
  return spans;
}

int *findSpansUsingStack(int sequence[], int n){

}

array<int, arraySize> findSpansUsingStackAndArray(array<int, arraySize>){

}


int main()
{
  int n = 5;
  int sequence[] = {6, 3, 4, 5, 2};
  //int spans[n] = findSpansIterative(sequence, n);
}
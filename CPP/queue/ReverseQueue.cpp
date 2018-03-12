/*
* Given an algorithm for reversing a queue. To access the queue, we are only allowed to used methods of queue ADT.
*/
#include <iostream>
#include <stack>
#include <queue>

using namespace std;

void reverseQueue(queue<int> q)
{
  stack<int> s;
  while(!q.empty()){
    s.push(q.front());
    cout << q.front();
    q.pop();

  }
  cout << endl;

  while(!s.empty()){
    q.push(s.top());
    cout << s.top();
    s.pop();
  }
  cout << endl;
}


int main()
{
  queue<int> q;
  q.push(2);
  q.push(4);
  q.push(6);
  q.push(8);
  reverseQueue(q);
}
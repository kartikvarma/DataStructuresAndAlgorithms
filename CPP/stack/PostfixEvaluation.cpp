#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isOperand(char c)
{
  if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
  {
    return true;
  }
  return false;
}

int evaluateExpression(string expr)
{
  int evaluatedValue = -1;
  stack<int> s;

  for (int i = 0; i < expr.length(); i++)
  {
    if (isOperand(expr[i]))
    {
      int val1 = s.top();
      s.pop();
      int val2 = s.top();
      s.pop();

      switch (expr[i])
      {
      case '+':
        s.push(val2 + val1);
        break;
      case '-':
        s.push(val2 - val1);
        break;
      case '*':
        s.push(val2 * val1);
        break;
      case '/':
        s.push(val2 / val1);
        break;
      }
    }
    else
    {
      s.push(expr[i]-48);
    }
  }
  evaluatedValue = s.top();
  s.pop();
  return evaluatedValue;
}



int main()
{
  string expression;
  cout << "Enter your expression : ";
  cin >> expression;

  int value = evaluateExpression(expression);

  cout << value << endl;

  return 0;
}
#include <iostream>
#include <stack>
#include <stack>

using namespace std;

bool isOperator(char op)
{
  if (op == '*' || op == '/' || op == '%' || op == '+' || op == '-')
  {
    return true;
  }
  return false;
}

bool isOperand(char c)
{
  if (c >= '0' && c <= '9')
    return true;
  if (c >= 'a' && c <= 'z')
    return true;
  if (c >= 'A' && c <= 'Z')
    return true;
  return false;
}

int getOperatorWeight(char op)
{
  int weight = -1;
  switch (op)
  {
  case '+':
  case '-':
    weight = 1;
    break;
  case '*':
  case '/':
  case '%':
    weight = 2;
    break;
  }
  return weight;
}

bool hasLowerPrecedence(char op1, char op2)
{
  int op1Weight = getOperatorWeight(op1);
  int op2Weight = getOperatorWeight(op2);

  if (op1Weight == op2Weight)
  {
    return true;
  }
  return op1Weight > op2Weight ? true : false;
}

string convertInfixToPostFix(string expr)
{
  string convExpr = "";
  stack<char> s;
  for (int i = 0; i < expr.length(); i++)
  {
    //if the expr[i] not an operand append to the string
    if (isOperand(expr[i]))
    {
      convExpr += expr[i];
    }

    // i is an operator or right paranthesis
    else if (expr[i] == ((char)'('))
    {
      s.push(expr[i]);
    }
    //if a right paranthesis found -
    //pop and append tokens untill a left paranthesis is popped(do not append paranthesis to string)
    else if (expr[i] == ((char)')'))
    {
      while (!s.empty() && s.top() != (char)'(')
      {
        convExpr += s.top();
        s.pop();
      }
      s.pop();
    }

    // while stack not empty and the top value is not right paranthesis and the has lower precedence then i
    else if (isOperator(expr[i]))
    {
      while (!s.empty() && s.top() != (char)'(' && hasLowerPrecedence(s.top(), expr[i]))
      {
        convExpr += s.top();
        s.pop();
      }
      s.push(expr[i]);
    }
  }

  while (!s.empty())
  {
    convExpr += s.top();
    s.pop();
  }
  return convExpr;
}

int main()
{
  string expression;
  cout << "Enter your expression: ";
  cin >> expression;

  string convertedExpression = convertInfixToPostFix(expression);

  cout << convertedExpression << endl;
  return 0;
}
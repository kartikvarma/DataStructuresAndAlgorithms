#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool areMatchingPair(char start, char end){
	if(start == '\{' && end == '\}') return true;
	else if(start == '\(' && end == '\)') return true;
	else if(start == '\[' && end == '\]') return true;
	else return false;
}


bool areParanthesisBalanced(string expr){
  stack<char> s;
  for(int i=0; i < expr.length(); i++) {
    
    if (expr[i] == '\{' || expr[i] == '\(' || expr[i] == '\[') {
      s.push(expr[i]);
	}

    else if (expr[i] == '\}' || expr[i] == '\)' || expr[i] == '\]') {
		if(s.empty() || !areMatchingPair(s.top(), expr[i])){
			return false;
		}
	    s.pop();
	}
  }
  return s.empty() ? true:false;
}


int main(){
  string expression;
  cout << "Enter your expression : ";
  cin >> expression;

  if (areParanthesisBalanced(expression)){
    cout << "Expression is Balanced\n";
  } else {
    cout << "Expression is not Balanced\n";
  }
  return 0;
}

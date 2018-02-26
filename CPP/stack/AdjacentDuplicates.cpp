#include <iostream>
#include <stack>
#include <string>

using namespace std;

string removeDuplicates(string in)
{
  string output;
  stack<char> s;
  for(int i = 0; i < in.length(); i++)
  {
    if(!s.empty() && s.top() == in[i])
    {
      s.pop();
      output.pop_back();
    }else {
      s.push(in[i]);
      output += in[i];
    }
  }

  return output;
}

int main()
{
  string s;
  
  cout << "Enter a string : ";
  cin >> s;
  cout << "String after remove duplicates : " <<  removeDuplicates(s) << endl;
}
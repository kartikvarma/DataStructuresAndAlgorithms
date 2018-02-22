#include <iostream>
#include <stack>
#include <string>

bool isPalindrome(std::string s){
  std::stack<char> cs;
  bool foundX = false;
  for(int i = 0; i < s.length(); i++){
    if(s[i] == 'X') foundX = true;
    else if(foundX) {
      cs.pop();
    } 
    else if(s[i] != 'X') {
      cs.push(s[i]);
    }
  }
  return cs.empty() ? true : false;
}


int main() {
  std::string palindromeString;
  std::cout << "Enter a string : ";
  std::cin >> palindromeString;

  std::cout << "Is string palindrome : " << std::boolalpha << isPalindrome(palindromeString) << std::endl;

  return 0;
}
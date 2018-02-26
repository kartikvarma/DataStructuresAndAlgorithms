#include <iostream>
#include <stack>

using namespace std;

#define WIDTH 1

int getMaxArea(int heights[], int n)
{
  stack<int> s;
  int maxArea = 0; 
  int left; // left index in height with respective to the current
  int areaOfLeft; // area of the left index with respective to the current
  int i =0;
  while(i < n)
  {
    if(s.empty() || heights[s.top()] <= heights[i])
      s.push(i++);
    else
    {
      left = s.top();
      s.pop();

      areaOfLeft = heights[left] * (s.empty() ? i : i - s.top() - WIDTH);

      if(maxArea < areaOfLeft)
        maxArea = areaOfLeft;

    }
  }

  while (!s.empty())
  {
    left = s.top();
    s.pop();

    areaOfLeft = heights[left] * (s.empty() ? i : i - s.top() - WIDTH);

    if (maxArea < areaOfLeft)
      maxArea = areaOfLeft;
  }

  return maxArea;
}


int main()
{
  int sizeOfArray = 0;
  int heights[sizeOfArray];
  cout << "Enter the size of array: ";
  cin >> sizeOfArray;
  cout << "Enter numbers to be added to array : ";
  for(int i = 0; i < sizeOfArray; i++){
    cin >> heights[i];
  }
  int area = getMaxArea(heights, sizeOfArray);
  cout << "largest rectangle possible : " << area << endl;
 return 0;

}

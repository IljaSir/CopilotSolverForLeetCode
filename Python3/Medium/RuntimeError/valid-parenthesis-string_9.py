class Solution:
    def checkValidString(self, s: str) -> bool:
        
        # Idea: https://www.youtube.com/watch?v=0nXgYDzLbHg
        # The idea is to keep track of the number of open parenthesis and close parenthesis we have seen so far.
        # We can do this by keeping track of the lower and upper bounds of the number of open parenthesis.
        # If we see a (, then the lower bound of open parenthesis increases by 1, and the upper bound of open parenthesis increases by 1.
        # If we see a ), then the lower bound of open parenthesis decreases by 1, and the upper bound of open parenthesis decreases by 1.
        # If we see a *, then the lower bound of open parenthesis decreases by 1, and the upper bound of open parenthesis increases by 1.
        # If the upper bound of open parenthesis becomes negative, that means we have more close parenthesis than open parenthesis.
        # If the lower bound of open parenthesis becomes negative, that means we have more close parenthesis than open parenthesis.
        # If the lower bound of open parenthesis becomes 0, that means we have no open parenthesis.
        # If the upper bound of open parenthesis becomes 0, that means we have no open parenthesis.
        # If the lower bound of open parenthesis is negative, then we have more close parenthesis than open parenthesis.
        # If the upper bound of open parenthesis is negative, then we have more close parenthesis than open parenthesis.
        # If the lower bound of open parenthesis is 0, then we have no open parenthesis.
        # If the upper bound of open parenthesis is 0, then we have no open parenthesis.
        # If the lower bound of open parenthesis is positive, then we have open parenthesis.
        # If the upper bound of open parenthesis is positive, then we have open parenthesis.
        # If the lower bound of open parenthesis is positive, then we have open parenthesis.
        # If the upper bound of open parenthesis is positive, then we have open parenthesis.
        # If the lower bound of open parenthesis is positive, then we have open parenthesis.
        # If the upper bound of open parenthesis is positive, then we have open parenthesis.
        # If the lower bound of open parenthesis is positive, then we have open parenthesis.
        # If the upper bound of open parenthesis is positive, then we have open parenthesis.
        # If the lower bound of open parenthesis is positive, then we have open parenthesis.
        #
class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        
        
        # This is a greedy problem. The idea is to try to make the string valid by swapping brackets.
        # We can only swap brackets that are not locked.
        # If we can make the string valid by swapping, then we can return True.
        # If we cannot make the string valid by swapping, then we can return False.
        # We can use a stack to keep track of the open brackets.
        # If we encounter an open bracket, we push it onto the stack.
        # If we encounter a closed bracket, we pop the top of the stack.
        # If the stack is empty, then we cannot make the string valid by swapping.
        # If the stack is not empty, then we can make the string valid by swapping.
        # We can also check if the number of open brackets matches the number of closed brackets.
        # If the number of open brackets does not match the number of closed brackets, then we cannot make the string valid by swapping.
        # If the number of open brackets matches the number of closed brackets, then we can make the string valid by swapping.
        # We can use a counter to keep track of the number of open brackets.
        # We can iterate through the string.
        # If the current character is an open bracket, we increment the counter.
        # If the current character is a closed bracket, we decrement the counter.
        # If the counter is less than zero, then we cannot make the string valid by swapping.
        # If the counter is greater than zero, then we cannot make the string valid by swapping.
        # If the counter is zero, then we can make the string valid by swapping.
        # We can use a counter to keep track of the number of closed brackets.
        # We can iterate through the string in reverse.
        # If the current character is a closed bracket, we increment the counter.
        # If the current character is an open bracket, we decrement the counter.
        # If the counter is less than zero, then we cannot make the string valid by swapping.
        # If the counter is greater than zero, then we cannot make the string valid by swapping.
        # If the counter is zero, then we can make the string valid by swapping.
        # We can check if the number of open brackets matches the number of closed brackets.
        # If the number of open brackets does not match the number of closed brackets, then we cannot
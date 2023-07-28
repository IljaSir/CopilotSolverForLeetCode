class Solution:
    def smallestSubsequence(self, s: str) -> str:
        
        # 1) make a dict of the last index of each char
        # 2) make a stack of the chars
        # 3) if the next char is smaller than the last char in the stack, and the last char in the stack is not the last char in the string, pop the last char from the stack
        # 4) add the next char to the stack
        # 5) return the stack as a string
        last_index = {}
        for i, char in enumerate(s):
            last_index[char] = i
        stack = []
        for i, char in enumerate(s):
            if char not in stack:
                while stack and char < stack[-1] and i != last_index[stack[-1]]:
                    stack.pop()
                stack.append(char)
        return "".join(stack)
class Solution:
    def smallestSubsequence(self, s: str) -> str:
        
        # 1. pop all the elements that are already in the stack
        # 2. pop the last element in the stack if it is greater than the current element and the last element is still in the rest of the string
        # 3. push the current element to the stack
        stack = []
        for i, c in enumerate(s):
            if c in stack:
                continue
            while stack and stack[-1] > c and c in s[i:]:
                stack.pop()
            stack.append(c)
        return "".join(stack)
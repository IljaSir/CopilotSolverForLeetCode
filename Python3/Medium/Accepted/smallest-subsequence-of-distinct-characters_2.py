class Solution:
    def smallestSubsequence(self, s: str) -> str:
        
        # Stack based solution
        stack = []
        for i, c in enumerate(s):
            if c in stack:
                continue
            while stack and stack[-1] > c and s.find(stack[-1], i) != -1:
                stack.pop()
            stack.append(c)
        return ''.join(stack)
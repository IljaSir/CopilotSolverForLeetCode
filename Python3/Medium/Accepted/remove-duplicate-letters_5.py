class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        stack = []
        for i, c in enumerate(s):
            if c in stack:
                continue
            while stack and stack[-1] > c and stack[-1] in s[i+1:]:
                stack.pop()
            stack.append(c)
        return ''.join(stack)
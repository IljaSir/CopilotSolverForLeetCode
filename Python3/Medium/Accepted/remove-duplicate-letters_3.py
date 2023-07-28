class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        stack = []
        for i, c in enumerate(s):
            if c in stack:
                continue
            while stack and c < stack[-1] and s.find(stack[-1], i) != -1:
                stack.pop()
            stack.append(c)
        return ''.join(stack)
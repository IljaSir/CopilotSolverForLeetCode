class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        stack = []
        for i, c in enumerate(s):
            if c not in stack:
                while stack and stack[-1] > c and s.find(stack[-1], i) != -1:
                    stack.pop()
                stack.append(c)
        return "".join(stack)
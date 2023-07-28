class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        stack = []
        last = {c: i for i, c in enumerate(s)}
        for i, c in enumerate(s):
            if c not in stack:
                while stack and stack[-1] > c and i < last[stack[-1]]:
                    stack.pop()
                stack.append(c)
        return ''.join(stack)
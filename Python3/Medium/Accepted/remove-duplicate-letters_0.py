class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        last = {c: i for i, c in enumerate(s)}
        stack = []
        for i, c in enumerate(s):
            if c not in stack:
                while stack and c < stack[-1] and i < last[stack[-1]]:
                    stack.pop()
                stack.append(c)
        return "".join(stack)
class Solution:
    def removeStars(self, s: str) -> str:
        
        stack = []
        for ch in s:
            if ch == '*':
                if stack and stack[-1] != '*':
                    stack.pop()
            else:
                stack.append(ch)
        return ''.join(stack)
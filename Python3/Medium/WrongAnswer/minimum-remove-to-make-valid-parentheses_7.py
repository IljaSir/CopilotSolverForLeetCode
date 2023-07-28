class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        for i, c in enumerate(s):
            if c == '(':
                stack.append([i, c])
            elif c == ')':
                if stack and stack[-1][1] == '(':
                    stack.pop()
                else:
                    stack.append([i, c])
        for i, c in stack:
            s = s[:i] + s[i+1:]
        return s
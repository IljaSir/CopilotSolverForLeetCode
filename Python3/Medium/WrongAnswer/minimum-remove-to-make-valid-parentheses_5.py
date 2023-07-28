class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            elif s[i] == ')':
                if stack:
                    stack.pop()
                else:
                    stack.append(i)
        for i in stack:
            s = s[:i] + s[i+1:]
        return s
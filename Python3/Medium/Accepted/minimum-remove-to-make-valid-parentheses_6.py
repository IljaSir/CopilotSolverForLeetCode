class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        s = list(s)
        for i, c in enumerate(s):
            if c == "(":
                stack.append(i)
            elif c == ")":
                if not stack:
                    s[i] = ""
                else:
                    stack.pop()
        while stack:
            s[stack.pop()] = ""
        return "".join(s)
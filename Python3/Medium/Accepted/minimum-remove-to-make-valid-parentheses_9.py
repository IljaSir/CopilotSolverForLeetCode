class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        for i, c in enumerate(s):
            if c == ")":
                if len(stack) > 0 and stack[-1][0] == "(":
                    stack.pop()
                else:
                    stack.append((c, i))
            elif c == "(":
                stack.append((c, i))
        if len(stack) == 0:
            return s
        else:
            s = list(s)
            for c, i in stack:
                s[i] = ""
            return "".join(s)
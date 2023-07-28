class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        
        stack = []
        result = ""
        for c in s:
            if c == "(":
                stack.append(c)
                if len(stack) > 1:
                    result += c
            elif c == ")":
                stack.pop()
                if len(stack) > 0:
                    result += c
        return result
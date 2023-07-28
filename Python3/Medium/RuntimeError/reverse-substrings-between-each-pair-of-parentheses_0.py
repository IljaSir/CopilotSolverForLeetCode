class Solution:
    def reverseParentheses(self, s: str) -> str:
        
        stack = [""]
        for ch in s:
            if ch == "(":
                stack.append("")
            elif ch == ")":
                stack[-2] += stack.pop()[::-1]
            else:
                stack[-1] += ch
        return stack[-1]
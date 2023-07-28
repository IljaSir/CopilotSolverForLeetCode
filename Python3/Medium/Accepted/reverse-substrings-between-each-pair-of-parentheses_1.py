class Solution:
    def reverseParentheses(self, s: str) -> str:
        
        stack = []
        for c in s:
            if c == ")":
                t = []
                while stack[-1] != "(":
                    t.append(stack.pop())
                stack.pop()
                stack.extend(t)
            else:
                stack.append(c)
        return "".join(stack)
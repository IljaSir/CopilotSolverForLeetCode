class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        
        stack = []
        for c in s:
            if c == '(':
                stack.append(c)
            else:
                temp = 0
                while stack[-1] != '(':
                    temp += stack.pop()
                stack.pop()
                if temp == 0:
                    stack.append(1)
                else:
                    stack.append(temp * 2)
        return sum(stack)
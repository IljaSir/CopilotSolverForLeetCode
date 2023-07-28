class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        
        stack = []
        for c in s:
            if c == '(':
                stack.append(c)
            else:
                if stack[-1] == '(':
                    stack.pop()
                    stack.append(1)
                else:
                    temp = 0
                    while stack and stack[-1] != '(':
                        temp += stack.pop()
                    stack.pop()
                    stack.append(temp*2)
        return sum(stack)
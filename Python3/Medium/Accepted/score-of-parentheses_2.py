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
                    tmp = 0
                    while stack[-1] != '(':
                        tmp += stack.pop()
                    stack.pop()
                    stack.append(tmp*2)
        return sum(stack)
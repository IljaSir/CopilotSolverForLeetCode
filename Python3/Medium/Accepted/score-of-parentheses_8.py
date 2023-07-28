class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        
        stack = []
        for c in s:
            if c == '(':
                stack.append(c)
            else:
                if stack[-1] == '(':
                    stack[-1] = 1
                else:
                    val = 0
                    while stack[-1] != '(':
                        val += stack.pop()
                    stack.pop()
                    stack.append(2*val)
        return sum(stack)
class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        stack = []
        for c in expression:
            if c == ')':
                temp = []
                while stack[-1] != '(':
                    temp.append(stack.pop())
                stack.pop()
                op = stack.pop()
                if op == '&':
                    stack.append(all(temp))
                elif op == '|':
                    stack.append(any(temp))
                elif op == '!':
                    stack.append(not temp[0])
            elif c != ',':
                stack.append(c)
        return stack[0]
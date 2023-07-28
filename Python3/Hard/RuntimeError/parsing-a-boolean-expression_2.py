class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        stack = []
        for c in expression:
            if c == ')':
                sub = []
                while stack[-1] != '(':
                    sub.append(stack.pop())
                stack.pop()
                op = stack.pop()
                if op == '!':
                    stack.append(not sub[0])
                elif op == '&':
                    stack.append(all(sub))
                else:
                    stack.append(any(sub))
            elif c != ',':
                stack.append(c == 't')
        return stack[0]
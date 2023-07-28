class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        stack = []
        for ch in expression:
            if ch == ')':
                sub = []
                while stack[-1] != '(':
                    sub.append(stack.pop())
                stack.pop()
                op = stack.pop()
                if op == '&':
                    stack.append(all(sub))
                elif op == '|':
                    stack.append(any(sub))
                else:
                    stack.append(not sub[0])
            elif ch != ',':
                stack.append(ch)
        return stack[0]
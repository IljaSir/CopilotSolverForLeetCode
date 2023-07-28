class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        stack = []
        for c in expression:
            if c == ')':
                cur = []
                while stack:
                    top = stack.pop()
                    if top == '(':
                        break
                    cur.append(top)
                if cur[0] == '!':
                    stack.append(not cur[1])
                elif cur[0] == '&':
                    stack.append(all(cur[1:]))
                elif cur[0] == '|':
                    stack.append(any(cur[1:]))
            elif c != ',':
                stack.append(c)
        return stack[0]
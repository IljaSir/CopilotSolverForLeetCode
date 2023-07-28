class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        stack = []
        for c in expression:
            if c == ')':
                tmp = []
                while stack[-1] != '(':
                    tmp.append(stack.pop())
                stack.pop()
                if stack[-1] == '&':
                    stack.pop()
                    stack.append(all(tmp))
                elif stack[-1] == '|':
                    stack.pop()
                    stack.append(any(tmp))
                else:
                    stack.pop()
                    stack.append(not tmp[0])
            elif c != ',':
                stack.append(c == 't')
        return stack[-1]
class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        stack = []
        for ch in expression:
            if ch == ')':
                tmp = []
                while stack[-1] != '(':
                    tmp.append(stack.pop())
                stack.pop()
                if stack[-1] == '!':
                    stack.pop()
                    stack.append(not tmp[0])
                elif stack[-1] == '&':
                    stack.pop()
                    stack.append(all(tmp))
                elif stack[-1] == '|':
                    stack.pop()
                    stack.append(any(tmp))
            elif ch != ',':
                stack.append(ch == 't')
        return stack[0]
class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        # stack = []
        # for c in expression:
        #     if c == ')':
        #         tmp = []
        #         while stack[-1] != '(':
        #             tmp.append(stack.pop())
        #         stack.pop()
        #         op = stack.pop()
        #         if op == '&':
        #             stack.append(all(tmp))
        #         elif op == '|':
        #             stack.append(any(tmp))
        #         else:
        #             stack.append(not tmp[0])
        #     elif c != ',':
        #         stack.append(c)
        # return stack.pop()
        # stack = []
        # for c in expression:
        #     if c == ')':
        #         tmp = []
        #         while stack[-1] != '(':
        #             tmp.append(stack.pop())
        #         stack.pop()
        #         op = stack.pop()
        #         if op == '&':
        #             stack.append(all(tmp))
        #         elif op == '|':
        #             stack.append(any(tmp))
        #         else:
        #             stack.append(not tmp[0])
        #     elif c != ',':
        #         stack.append(c)
        # return stack.pop()
        stack = []
        for c in expression:
            if c == ')':
                tmp = []
                while stack[-1] != '(':
                    tmp.append(stack.pop())
                stack.pop()
                op = stack.pop()
                if op == '&':
                    stack.append(all(tmp))
                elif op == '|':
                    stack.append(any(tmp))
                else:
                    stack.append(not tmp[0])
            elif c != ',':
                stack.append(c)
        return stack.pop()
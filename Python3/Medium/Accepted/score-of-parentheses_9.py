class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        
        stk = []
        for c in s:
            if c == '(':
                stk.append(c)
            else:
                if stk[-1] == '(':
                    stk.pop()
                    stk.append(1)
                else:
                    tmp = 0
                    while stk[-1] != '(':
                        tmp += stk.pop()
                    stk.pop()
                    stk.append(2*tmp)
        return sum(stk)
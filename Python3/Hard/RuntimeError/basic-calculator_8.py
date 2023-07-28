class Solution:
    def calculate(self, s: str) -> int:
        
        s = list(s)
        stack = []
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                start = stack.pop()
                s[start] = '('
                s[i] = ')'
        return eval(''.join(s))
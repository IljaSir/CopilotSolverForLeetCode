class Solution:
    def calculate(self, s: str) -> int:
        
        def calc(a, b, op):
            if op == '+':
                return a+b
            if op == '-':
                return a-b
            if op == '*':
                return a*b
            if op == '/':
                return int(a/b)
        num = 0
        stack = []
        op = '+'
        for c in s:
            if c.isdigit():
                num = num*10+int(c)
            elif c in '+-*/':
                stack.append(calc(num, 0, op))
                num = 0
                op = c
        stack.append(calc(num, 0, op))
        return sum(stack)
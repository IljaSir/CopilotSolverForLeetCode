class Solution:
    def solveEquation(self, equation: str) -> str:
        
        def parse(s):
            x = 0
            num = 0
            sign = 1
            for i in range(len(s)):
                if s[i] == '+':
                    x += sign * num
                    num = 0
                    sign = 1
                elif s[i] == '-':
                    x += sign * num
                    num = 0
                    sign = -1
                elif s[i] == 'x':
                    if i > 0 and s[i - 1].isdigit():
                        x += sign * num
                    else:
                        x += sign
                    num = 0
                else:
                    num = num * 10 + int(s[i])
            x += sign * num
            return x
        left, right = equation.split('=')
        x = parse(left) - parse(right)
        return "x=" + str(x) if x != 0 else "Infinite solutions" if equation.count('x') > 0 else "No solution"
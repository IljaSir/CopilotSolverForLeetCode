class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        
        a, b = num1.split('+')
        c, d = num2.split('+')
        a, b = int(a), int(b[:-1])
        c, d = int(c), int(d[:-1])
        return f'{a*c-b*d}+{a*d+b*c}i'
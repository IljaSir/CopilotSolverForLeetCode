class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        
        a, b = num1.split('+')
        c, d = num2.split('+')
        a, b, c, d = int(a), int(b[:-1]), int(c), int(d[:-1])
        return str(a*c-b*d) + '+' + str(a*d+b*c) + 'i'
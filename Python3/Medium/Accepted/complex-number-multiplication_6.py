class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        
        def parse(s):
            real, imag = s.split('+')
            return int(real), int(imag[:-1])
        a, b = parse(num1)
        c, d = parse(num2)
        return f"{a*c - b*d}+{a*d + b*c}i"
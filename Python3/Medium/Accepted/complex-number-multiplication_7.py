class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        
        def get_complex(s):
            a, b = s.split('+')
            return int(a), int(b[:-1])
        a1, b1 = get_complex(num1)
        a2, b2 = get_complex(num2)
        a = a1 * a2 - b1 * b2
        b = a1 * b2 + a2 * b1
        return f'{a}+{b}i'
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        
        def add(a, b, c):
            s = a + b + c
            return (s % 10, s // 10)
        a, b = list(num1), list(num2)
        c = []
        carry = 0
        while a or b or carry:
            d1 = int(a.pop()) if a else 0
            d2 = int(b.pop()) if b else 0
            d, carry = add(d1, d2, carry)
            c.append(d)
        return ''.join(map(str, c[::-1]))
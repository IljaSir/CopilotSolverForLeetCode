class Solution:
    def findIntegers(self, n: int) -> int:
        
        def count(n):
            a, b = 1, 2
            for _ in range(n):
                a, b = a + b, a
            return a
        n = bin(n)[2:]
        res = 0
        for i in range(len(n)):
            if n[i] == '0':
                continue
            res += count(len(n) - i - 1)
            if i > 0 and n[i - 1] == '1':
                return res
        return res + 1
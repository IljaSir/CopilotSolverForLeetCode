class Solution:
    def findIntegers(self, n: int) -> int:
        
        a, b = 1, 2
        for i in range(2, 31):
            a, b = b, a + b
        res = a + b
        pre = 0
        for i in range(29, -1, -1):
            if n & (1 << i):
                res += a
                if pre:
                    res -= 1
                    break
                pre = 1
            else:
                pre = 0
            if i:
                a, b = b - a, a
        return res
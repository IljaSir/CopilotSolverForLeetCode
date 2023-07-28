class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        
        # p = 2**a * m
        # q = 2**b * n
        # p/q = 2**(a-b) * m/n
        # p/q = 2**c * k
        # 2**c * k = 2**a * m / 2**b * n
        # 2**c = 2**(a-b) * m/n
        # 2**c = 2**(a-b) * p/q
        # 2**c = 2**(a-b) * p/q
        # 2**c * q = 2**(a-b) * p
        # 2**c * q = 2**(a-b) * 2**a * m
        # 2**c * q = 2**(a-b+a) * m
        # 2**c * q = 2**(a) * m
        # 2**c * q = 2**(c) * m
        # 2**c = m
        # c = log2(m)
        # c = log2(p/q)
        # c = log2(p) - log2(q)
        from math import log2
        c = log2(p) - log2(q)
        if c % 2 == 0:
            return 0
        elif c % 2 == 1:
            return 1
        else:
            return 2
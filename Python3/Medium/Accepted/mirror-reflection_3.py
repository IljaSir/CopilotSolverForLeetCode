class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        g = gcd(p, q)
        p //= g
        p %= 2
        q //= g
        q %= 2
        if p == 1 and q == 1:
            return 1
        if p == 1 and q == 0:
            return 0
        if p == 0 and q == 1:
            return 2
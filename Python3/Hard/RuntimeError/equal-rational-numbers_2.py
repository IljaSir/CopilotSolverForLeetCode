class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        def parse(s):
            if '(' not in s:
                return int(s), 1, 0
            i = s.index('(')
            return int(s[:i]), 1, int(s[i + 1:-1])
        def reduce(a, b, c):
            g = math.gcd(a, b)
            a //= g
            b //= g
            g = math.gcd(b, c)
            b //= g
            c //= g
            return a, b, c
        def add(a, b, c, d, e):
            return a * d + b * c, b * d, e
        def eq(a, b, c, d, e):
            a, b, c = reduce(a, b, c)
            d, e, f = reduce(d, e, f)
            return a == d and b == e and c == f
        a, b, c = parse(s)
        d, e, f = parse(t)
        if c == 0 and f == 0:
            return a * e == d * b
        if c == 0:
            return eq(a, b, c, d * b + a, e * b)
        if f == 0:
            return eq(a * e, b * e, c * e, d, e)
        return eq(a * e * (f + 1), b * e * (f + 1), c * e * (f + 1), d * e * (f + 1), e * (f + 1))
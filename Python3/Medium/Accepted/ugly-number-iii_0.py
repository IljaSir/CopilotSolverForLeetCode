class Solution:
    def nthUglyNumber(self, n: int, a: int, b: int, c: int) -> int:
        
        def gcd(a,b):
            while b:
                a,b = b, a%b
            return a
        def lcm(a,b):
            return a*b//gcd(a,b)
        ab,ac,bc,abc = lcm(a,b), lcm(a,c), lcm(b,c), lcm(a,lcm(b,c))
        def count(n):
            return n//a + n//b + n//c - n//ab - n//ac - n//bc + n//abc
        l,r = 1, 2*10**9
        while l < r:
            m = (l+r)//2
            if count(m) < n:
                l = m + 1
            else:
                r = m
        return l
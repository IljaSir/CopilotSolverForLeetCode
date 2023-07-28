class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        
        def count(n):
            if n <= 0:
                return 0
            elif n < 10:
                return 1
            else:
                m = 10
                while m <= n:
                    m *= 10
                m //= 10
                if n // m == 1:
                    return n % m + 1 + count(m - 1) + count(n % m)
                else:
                    return m + count(n % m) + count(m - 1) * (n // m)
        
        return count(n)
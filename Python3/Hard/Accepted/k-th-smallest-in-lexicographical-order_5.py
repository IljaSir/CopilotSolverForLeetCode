class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        def count(n, prefix):
            c, a, b = 0, prefix, prefix + 1
            while a <= n:
                c += min(n + 1, b) - a
                a *= 10
                b *= 10
            return c
        prefix = 1
        k -= 1
        while k > 0:
            c = count(n, prefix)
            if k >= c:
                k -= c
                prefix += 1
            else:
                k -= 1
                prefix *= 10
        return prefix
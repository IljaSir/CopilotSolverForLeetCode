class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        def count(prefix, n):
            c = 0
            while prefix <= n:
                c += min(n + 1, prefix + 10) - prefix
                prefix *= 10
            return c
        prefix = 1
        k -= 1
        while k > 0:
            c = count(prefix, n)
            if c <= k:
                prefix += 1
                k -= c
            else:
                prefix *= 10
                k -= 1
        return prefix
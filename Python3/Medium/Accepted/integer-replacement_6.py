class Solution:
    def integerReplacement(self, n: int) -> int:
        
        def helper(n):
            if n in cache:
                return cache[n]
            if n == 1:
                return 0
            if n % 2 == 0:
                cache[n] = 1 + helper(n//2)
            else:
                cache[n] = 1 + min(helper(n+1), helper(n-1))
            return cache[n]
        cache = {}
        return helper(n)
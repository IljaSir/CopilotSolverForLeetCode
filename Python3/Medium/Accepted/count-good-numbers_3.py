class Solution:
    def countGoodNumbers(self, n: int) -> int:
        
        MOD = 10**9 + 7
        def power(a, b):
            res = 1
            while b:
                if b & 1:
                    res = res * a % MOD
                a = a * a % MOD
                b >>= 1
            return res
        return power(5, (n + 1) // 2) * power(4, n // 2) % MOD
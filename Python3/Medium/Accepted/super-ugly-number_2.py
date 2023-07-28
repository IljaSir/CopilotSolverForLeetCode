class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        dp = [1] * n
        idx = [0] * len(primes)
        for i in range(1, n):
            dp[i] = min([primes[j] * dp[idx[j]] for j in range(len(primes))])
            for j in range(len(primes)):
                if dp[i] == primes[j] * dp[idx[j]]:
                    idx[j] += 1
        return dp[-1]
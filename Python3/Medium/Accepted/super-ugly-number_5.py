class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        dp = [1]
        idx = [0] * len(primes)
        for i in range(1, n):
            dp.append(min(dp[idx[j]] * primes[j] for j in range(len(primes))))
            for j in range(len(primes)):
                if dp[i] == dp[idx[j]] * primes[j]:
                    idx[j] += 1
        return dp[-1]
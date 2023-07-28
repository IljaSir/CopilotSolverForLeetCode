class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        dp = [1]
        idx = [0] * len(primes)
        while len(dp) < n:
            dp.append(min([dp[idx[i]] * primes[i] for i in range(len(primes))]))
            for i in range(len(primes)):
                if dp[-1] == dp[idx[i]] * primes[i]:
                    idx[i] += 1
        return dp[-1]
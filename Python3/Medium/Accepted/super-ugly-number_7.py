class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        
        dp = [1]
        pointers = [0]*len(primes)
        while len(dp) < n:
            next_ugly = min(dp[pointers[i]]*primes[i] for i in range(len(primes)))
            dp.append(next_ugly)
            for i in range(len(primes)):
                if next_ugly == dp[pointers[i]]*primes[i]:
                    pointers[i] += 1
        return dp[-1]
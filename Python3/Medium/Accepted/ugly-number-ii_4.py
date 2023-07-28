class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        dp = [1]
        p2 = p3 = p5 = 0
        for i in range(1, n):
            dp.append(min(dp[p2]*2, dp[p3]*3, dp[p5]*5))
            if dp[-1] == dp[p2]*2:
                p2 += 1
            if dp[-1] == dp[p3]*3:
                p3 += 1
            if dp[-1] == dp[p5]*5:
                p5 += 1
        return dp[-1]
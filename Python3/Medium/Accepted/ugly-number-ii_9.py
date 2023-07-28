class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        dp = [1]
        i2, i3, i5 = 0, 0, 0
        for _ in range(n):
            m2, m3, m5 = dp[i2]*2, dp[i3]*3, dp[i5]*5
            m = min(m2, m3, m5)
            if m == m2:
                i2 += 1
            if m == m3:
                i3 += 1
            if m == m5:
                i5 += 1
            dp.append(m)
        return dp[n-1]
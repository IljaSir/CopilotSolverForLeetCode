class Solution:
    def findIntegers(self, n: int) -> int:
        
        # dp[i] = dp[i-1] + dp[i-2]
        # dp[0] = 1
        # dp[1] = 2
        dp = [1, 2]
        for i in range(2, 31):
            dp.append(dp[i-1] + dp[i-2])
        ans = 0
        prev_bit = 0
        for i in range(29, -1, -1):
            if n & (1 << i):
                ans += dp[i]
                if prev_bit:
                    return ans
                prev_bit = 1
            else:
                prev_bit = 0
        return ans + 1
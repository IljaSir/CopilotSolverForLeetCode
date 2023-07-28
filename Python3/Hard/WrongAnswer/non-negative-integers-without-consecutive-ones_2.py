class Solution:
    def findIntegers(self, n: int) -> int:
        
        # dp[i][0] = dp[i-1][0]+dp[i-1][1]
        # dp[i][1] = dp[i-1][0]
        dp = [[0,0] for _ in range(32)]
        dp[0][0] = 1
        for i in range(1,32):
            dp[i][0] = dp[i-1][0]+dp[i-1][1]
            dp[i][1] = dp[i-1][0]
        res = 0
        pre = 0
        for i in range(31,-1,-1):
            if n&(1<<i):
                res += dp[i][0]+dp[i][1]
                if pre == 1:
                    res -= dp[i][1]
                    break
                pre = 1
            else:
                pre = 0
        return res+1
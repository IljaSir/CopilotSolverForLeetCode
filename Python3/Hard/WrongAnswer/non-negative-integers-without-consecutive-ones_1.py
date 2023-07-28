class Solution:
    def findIntegers(self, n: int) -> int:
        
        dp = [0, 1]
        for i in range(2, 32):
            dp.append(dp[-1] + dp[-2])
        res, pre_bit = 0, 0
        for i in range(30, -1, -1):
            if n & (1 << i):
                res += dp[i + 1]
                if pre_bit:
                    return res
                pre_bit = 1
            else:
                pre_bit = 0
        return res + 1
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [collections.Counter() for _ in range(n)]
        res = 0
        for i in range(n):
            for j in range(i):
                d = nums[i] - nums[j]
                dp[i][d] += 1
                if d in dp[j]:
                    dp[i][d] += dp[j][d]
                    res += dp[j][d]
        return res
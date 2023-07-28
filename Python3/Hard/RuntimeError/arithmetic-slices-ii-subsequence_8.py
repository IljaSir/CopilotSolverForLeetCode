class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n < 3:
            return 0
        dp = [{}, 0]
        for i in range(1, n):
            for j in range(i):
                diff = nums[i] - nums[j]
                if diff in dp[j]:
                    dp[i][diff] = dp[j][diff] + 1
                else:
                    dp[i][diff] = 2
                if diff in dp[i]:
                    dp[i][diff] += dp[i-1][diff]
                    dp[i-1][diff] += dp[i][diff]
        return sum(dp[-1].values())
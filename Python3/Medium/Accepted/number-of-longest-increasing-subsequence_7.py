class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        
        # dp[i] = (length, count) of LIS ending at i
        dp = [[1,1] for _ in range(len(nums))]
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] >= nums[i]:
                    continue
                if dp[j][0] + 1 > dp[i][0]:
                    dp[i][0] = dp[j][0] + 1
                    dp[i][1] = dp[j][1]
                elif dp[j][0] + 1 == dp[i][0]:
                    dp[i][1] += dp[j][1]
        max_len = max(dp, key=lambda x: x[0])[0]
        return sum(count for length, count in dp if length == max_len)
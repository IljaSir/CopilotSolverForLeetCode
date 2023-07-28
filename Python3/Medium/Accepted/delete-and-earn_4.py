class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        max_num = max(nums)
        count = [0] * (max_num + 1)
        for n in nums:
            count[n] += 1
        dp = [0] * (max_num + 1)
        dp[1] = count[1]
        for i in range(2, max_num + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + i * count[i])
        return dp[-1]
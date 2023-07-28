class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        total = sum(nums)
        if total % 2 == 1:
            return False
        total = total // 2
        dp = [False] * (total + 1)
        dp[0] = True
        for i in range(len(nums)):
            for j in range(total, nums[i] - 1, -1):
                dp[j] = dp[j] or dp[j - nums[i]]
        return dp[-1]
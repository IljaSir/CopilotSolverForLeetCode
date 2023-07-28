class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        total = sum(nums)
        if total % 2 != 0:
            return False
        total = total // 2
        dp = [False] * (total + 1)
        dp[0] = True
        for num in nums:
            for j in range(total, num - 1, -1):
                dp[j] = dp[j] or dp[j - num]
        return dp[total]
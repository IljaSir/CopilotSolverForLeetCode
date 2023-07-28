class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        total = sum(nums)
        if total % 2 != 0:
            return False
        total = total // 2
        dp = [False] * (total + 1)
        dp[0] = True
        for num in nums:
            for i in range(total, 0, -1):
                if i >= num:
                    dp[i] = dp[i] or dp[i - num]
        return dp[total]
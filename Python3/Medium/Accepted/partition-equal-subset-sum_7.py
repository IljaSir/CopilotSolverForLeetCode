class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        total = sum(nums)
        if total % 2 == 1:
            return False
        total = total // 2
        dp = [True] + [False] * total
        for n in nums:
            for i in range(total, n-1, -1):
                dp[i] = dp[i] or dp[i-n]
        return dp[total]
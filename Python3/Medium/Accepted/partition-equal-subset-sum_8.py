class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        sum_ = sum(nums)
        if sum_ & 1:
            return False
        target = sum_ >> 1
        dp = [False] * (target + 1)
        dp[0] = True
        for num in nums:
            for j in range(target, num - 1, -1):
                dp[j] = dp[j] or dp[j - num]
        return dp[target]
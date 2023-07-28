class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        if nums[0] == 0:
            return False
        dp = [0] * len(nums)
        dp[0] = 1
        for i in range(len(nums)):
            if dp[i] == 1:
                for j in range(1, nums[i] + 1):
                    if i + j < len(nums):
                        dp[i + j] = 1
        return dp[-1] == 1
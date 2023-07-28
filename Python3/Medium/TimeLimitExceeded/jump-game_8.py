class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        # dp[i] = can reach i
        dp = [False] * len(nums)
        dp[0] = True
        for i in range(len(nums)):
            if dp[i]:
                for j in range(nums[i]):
                    if i + j + 1 < len(nums):
                        dp[i + j + 1] = True
        return dp[-1]
class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [0] * n
        for i in range(n):
            for j in range(1, nums[i] + 1):
                if i + j < n:
                    dp[i + j] = min(dp[i + j], dp[i] + 1) if dp[i + j] else dp[i] + 1
                else:
                    break
        return dp[-1]
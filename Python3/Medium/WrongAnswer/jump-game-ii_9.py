class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        if nums[0] >= n - 1:
            return 1
        # dp[i] = min(dp[i - j]) + 1 for all j <= nums[i - 1]
        dp = [n] * n
        dp[0] = 0
        for i in range(1, n):
            for j in range(1, nums[i - 1] + 1):
                if i - j < 0:
                    break
                dp[i] = min(dp[i], dp[i - j] + 1)
        return dp[-1]
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [0] * n
        for i in range(n):
            if nums[i] == 0:
                dp[i] = 1
        for i in range(1, n):
            dp[i] = dp[i] + dp[i-1]
        ans = 0
        for i in range(n):
            ans += dp[i]
        return ans
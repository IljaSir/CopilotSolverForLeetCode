class Solution:
    def countSpecialSubsequences(self, nums: List[int]) -> int:
        
        MOD = 10**9 + 7
        dp = [0, 0, 0]
        for n in nums:
            dp[n] = dp[n] + dp[n-1] + 1
            dp[n] %= MOD
        return dp[2]
class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = nums[i]
        for l in range(2, n+1):
            for i in range(n-l+1):
                j = i + l - 1
                dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
        return dp[0][n-1] >= 0
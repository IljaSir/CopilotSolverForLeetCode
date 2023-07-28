class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        
        if len(nums) % 2 == 0:
            return True
        dp = [[0 for _ in range(len(nums))] for _ in range(len(nums))]
        for i in range(len(nums)):
            dp[i][i] = nums[i]
        for i in range(len(nums)-2, -1, -1):
            for j in range(i+1, len(nums)):
                dp[i][j] = max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1])
        return dp[0][-1] >= 0
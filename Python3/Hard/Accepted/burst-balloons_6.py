class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        
        n = len(nums)
        nums = [1] + nums + [1]
        dp = [[0]*(n+2) for _ in range(n+2)]
        for i in range(1, n+1):
            dp[i][i] = nums[i-1]*nums[i]*nums[i+1]
        for i in range(1, n+1):
            for j in range(i-1, 0, -1):
                for k in range(j, i+1):
                    dp[j][i] = max(dp[j][i], dp[j][k-1] + dp[k+1][i] + nums[j-1]*nums[k]*nums[i+1])
        return dp[1][n]
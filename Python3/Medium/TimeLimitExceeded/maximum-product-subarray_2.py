class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [[0]*n for _ in range(n)]
        for i in range(n):
            dp[i][i] = nums[i]
        for i in range(1, n):
            for j in range(n-i):
                dp[j][j+i] = dp[j][j+i-1]*nums[j+i]
        return max([max(row) for row in dp])
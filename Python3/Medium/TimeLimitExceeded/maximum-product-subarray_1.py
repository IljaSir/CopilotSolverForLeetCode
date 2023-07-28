class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        n = len(nums)
        dp = [[0]*n for _ in range(n)]
        for i in range(n):
            dp[i][i] = nums[i]
        for i in range(n-1):
            dp[i][i+1] = nums[i]*nums[i+1]
        for i in range(n-2, -1, -1):
            for j in range(i+2, n):
                dp[i][j] = dp[i][j-1]*nums[j]
        return max(max(row) for row in dp)
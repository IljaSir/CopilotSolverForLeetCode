class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        n = len(nums)
        dp = [[0] * n for _ in range(k)]
        dp[0] = [sum(nums[:i+1])/(i+1) for i in range(n)]
        for i in range(1, k):
            for j in range(i, n):
                for l in range(i-1, j):
                    dp[i][j] = max(dp[i][j], dp[i-1][l] + sum(nums[l+1:j+1])/(j-l))
        return dp[-1][-1]
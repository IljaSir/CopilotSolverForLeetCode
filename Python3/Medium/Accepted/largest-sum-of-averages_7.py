class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        def sumAve(i, j):
            return (s[j] - s[i]) / (j - i)
        n = len(nums)
        s = [0] * (n + 1)
        for i in range(n):
            s[i + 1] = s[i] + nums[i]
        dp = [[0] * (n + 1) for _ in range(k + 1)]
        for i in range(1, n + 1):
            dp[1][i] = sumAve(0, i)
        for i in range(2, k + 1):
            for j in range(i, n + 1):
                for m in range(i - 1, j):
                    dp[i][j] = max(dp[i][j], dp[i - 1][m] + sumAve(m, j))
        return dp[k][n]
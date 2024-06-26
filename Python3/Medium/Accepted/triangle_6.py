class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [0] * n
        dp[0] = triangle[0][0]
        for i in range(1, n):
            dp[i] = triangle[i][i] + dp[i - 1]
            for j in range(i - 1, 0, -1):
                dp[j] = triangle[i][j] + min(dp[j - 1], dp[j])
            dp[0] += triangle[i][0]
        return min(dp)
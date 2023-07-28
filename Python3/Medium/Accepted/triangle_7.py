class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        dp = [0] * len(triangle)
        dp[0] = triangle[0][0]
        for i in range(1, len(triangle)):
            dp[i] = triangle[i][i] + dp[i - 1]
            for j in range(i - 1, 0, -1):
                dp[j] = min(dp[j], dp[j - 1]) + triangle[i][j]
            dp[0] += triangle[i][0]
        return min(dp)
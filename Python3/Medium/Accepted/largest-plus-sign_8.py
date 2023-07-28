class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        
        dp = [[n]*n for _ in range(n)]
        for i, j in mines:
            dp[i][j] = 0
        for i in range(n):
            cnt = 0
            for j in range(n):
                cnt = 0 if dp[i][j] == 0 else cnt + 1
                dp[i][j] = min(dp[i][j], cnt)
            cnt = 0
            for j in range(n-1, -1, -1):
                cnt = 0 if dp[i][j] == 0 else cnt + 1
                dp[i][j] = min(dp[i][j], cnt)
        for j in range(n):
            cnt = 0
            for i in range(n):
                cnt = 0 if dp[i][j] == 0 else cnt + 1
                dp[i][j] = min(dp[i][j], cnt)
            cnt = 0
            for i in range(n-1, -1, -1):
                cnt = 0 if dp[i][j] == 0 else cnt + 1
                dp[i][j] = min(dp[i][j], cnt)
        return max(max(row) for row in dp)
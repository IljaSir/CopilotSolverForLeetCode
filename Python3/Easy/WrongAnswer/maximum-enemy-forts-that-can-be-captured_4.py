class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            if forts[i] == 1:
                dp[i][i] = 1
        for i in range(n):
            for j in range(i+1, n):
                if forts[j] == 0:
                    if dp[i][j-1] > 0:
                        dp[i][j] = dp[i][j-1] + 1
                elif forts[j] == 1:
                    if dp[i][j-1] > 0:
                        dp[i][j] = dp[i][j-1]
        return max(max(row) for row in dp)
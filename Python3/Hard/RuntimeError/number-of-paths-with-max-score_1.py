class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        n = len(board)
        dp = [[0, 0] for _ in range(n)]
        dp[-1] = [0, 1]
        for i in range(n-2, -1, -1):
            dp[i][0] = dp[i+1][0] + int(board[i+1][n-1])
            dp[i][1] = 1
        for j in range(n-2, -1, -1):
            dp[-1][0] = dp[-1][0] + int(board[n-1][j+1])
            dp[-1][1] = 1
        for i in range(n-2, -1, -1):
            for j in range(n-2, -1, -1):
                if board[i][j] == 'X':
                    dp[i][0] = 0
                    dp[i][1] = 0
                    continue
                m = dp[i+1][0]
                c = dp[i+1][1]
                if dp[i][j+1][0] > m:
                    m = dp[i][j+1][0]
                    c = dp[i][j+1][1]
                elif dp[i][j+1][0] == m:
                    c += dp[i][j+1][1]
                if dp[i+1][j+1][0] > m:
                    m = dp[i+1][j+1][0]
                    c = dp[i+1][j+1][1]
                elif dp[i+1][j+1][0] == m:
                    c += dp[i+1][j+1][1]
                dp[i][0] = m + int(board[i][j])
                dp[i][1] = c % (10**9 + 7)
        return dp[0]
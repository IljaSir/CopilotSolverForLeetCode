class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        n = len(board)
        dp = [[0] * n for _ in range(n)]
        dp[-1][-1] = (0, 1)
        for i in range(n-2, -1, -1):
            if board[i+1][n-1] == 'X':
                break
            dp[i][n-1] = (dp[i+1][n-1][0] + int(board[i+1][n-1]), dp[i+1][n-1][1])
        for i in range(n-2, -1, -1):
            if board[n-1][i+1] == 'X':
                break
            dp[n-1][i] = (dp[n-1][i+1][0] + int(board[n-1][i+1]), dp[n-1][i+1][1])
        for i in range(n-2, -1, -1):
            for j in range(n-2, -1, -1):
                if board[i][j] == 'X':
                    continue
                a = dp[i+1][j][0] + int(board[i][j])
                b = dp[i][j+1][0] + int(board[i][j])
                c = dp[i+1][j+1][0] + int(board[i][j])
                if a > b and a > c:
                    dp[i][j] = (a, dp[i+1][j][1])
                elif b > a and b > c:
                    dp[i][j] = (b, dp[i][j+1][1])
                elif c > a and c > b:
                    dp[i][j] = (c, dp[i+1][j+1][1])
                elif a == b and a > c:
                    dp[i][j] = (a, dp[i+1][j][1] + dp[i][j+1][1])
                elif a == c and a > b:
                    dp[i][j] = (a, dp[i+1][j][1] + dp[i+1][j+1][1])
                elif b == c and b > a:
                    dp[i][j] = (b, dp[i][j+1][1] + dp[i+1][j+1][1])
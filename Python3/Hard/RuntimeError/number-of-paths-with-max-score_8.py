class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        n = len(board)
        dp = [[0]*n for _ in range(n)]
        dp[n-1][n-1] = 0
        dp[n-1][n-2] = 0
        dp[n-2][n-1] = 0
        dp[n-2][n-2] = 0
        for i in range(n-2,-1,-1):
            if board[i][n-1] == 'X':
                break
            dp[i][n-1] = dp[i+1][n-1] + int(board[i][n-1])
        for i in range(n-2,-1,-1):
            if board[n-1][i] == 'X':
                break
            dp[n-1][i] = dp[n-1][i+1] + int(board[n-1][i])
        for i in range(n-2,-1,-1):
            for j in range(n-2,-1,-1):
                if board[i][j] == 'X':
                    continue
                dp[i][j] = max(dp[i+1][j],dp[i+1][j+1],dp[i][j+1]) + int(board[i][j])
        print(dp)
        return dp[0][0]
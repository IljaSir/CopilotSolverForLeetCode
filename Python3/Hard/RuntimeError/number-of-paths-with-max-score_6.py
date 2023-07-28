class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        M = 10**9 + 7
        N = len(board)
        dp = [[0, 0] for _ in range(N)]
        dp[-1] = [0, 1]
        for j in range(N-2, -1, -1):
            dp[j][0] = dp[j+1][0] + int(board[j+1][N-1])
            dp[j][1] = 1
        for i in range(N-2, -1, -1):
            for j in range(N-2, -1, -1):
                if board[i][j] == 'X':
                    dp[j] = [0, 0]
                else:
                    dp[j][0] += int(board[i][j])
                    if dp[j][0] < dp[j+1][0]:
                        dp[j][0] = dp[j+1][0]
                        dp[j][1] = dp[j+1][1]
                    elif dp[j][0] == dp[j+1][0]:
                        dp[j][1] += dp[j+1][1]
                    if dp[j][0] < dp[j+1][0] + int(board[i][j]):
                        dp[j][0] = dp[j+1][0] + int(board[i][j])
                        dp[j][1] = dp[j+1][1]
                    elif dp[j][0] == dp[j+1][0] + int(board[i][j]):
                        dp[j][1] += dp[j+1][1]
                    if dp[j][0] < dp[j][0] + int(board[i][j]):
                        dp[j][0] = dp[j][0] + int(board[i][j])
                        dp[j][1] = dp[j][1]
                    elif dp[j][0] == dp[j][0] + int(board[i][j]):
                        dp[j][1] += dp[j][1]
                    dp[j][1] %= M
        dp[0][0] += int(board[0][N-1])
        if dp[0][0] == 0:
            return [0, 0]
        return dp[0]
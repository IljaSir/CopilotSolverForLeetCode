class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        N = len(board)
        dp = [[0] * N for _ in range(N)]
        path = [[0] * N for _ in range(N)]
        path[N-1][N-1] = 1
        for i in range(N-1, -1, -1):
            for j in range(N-1, -1, -1):
                if board[i][j] == 'X':
                    continue
                if i == N-1 and j == N-1:
                    continue
                if i == N-1:
                    dp[i][j] = dp[i][j+1]
                    path[i][j] = path[i][j+1]
                elif j == N-1:
                    dp[i][j] = dp[i+1][j]
                    path[i][j] = path[i+1][j]
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])
                    if dp[i+1][j] == dp[i][j+1] == dp[i+1][j+1]:
                        path[i][j] = (path[i+1][j] + path[i][j+1] + path[i+1][j+1]) % (10**9 + 7)
                    elif dp[i+1][j] == dp[i][j+1]:
                        path[i][j] = (path[i+1][j] + path[i][j+1]) % (10**9 + 7)
                    elif dp[i+1][j] == dp[i+1][j+1]:
                        path[i][j] = (path[i+1][j] + path[i+1][j+1]) % (10**9 + 7)
                    elif dp[i][j+1] == dp[i+1][j+1]:
                        path[i][j] = (path[i][j+1] + path[i+1][j+1]) % (10**9 + 7)
                    else:
                        path[i][j] = max(path[i+1][j], path[i][j+1], path[i+1][j+1])
                if board[i][j].isdigit():
                    dp[i][j] += int(board[i][j])
        if dp[
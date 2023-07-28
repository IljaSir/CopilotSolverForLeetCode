class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        m, n = len(board), len(board[0])
        dp = [[0] * n for _ in range(m)]
        dp[m-1][n-1] = (0, 1)
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if board[i][j] == 'X':
                    dp[i][j] = (0, 0)
                else:
                    max_score = 0
                    max_count = 0
                    if i < m-1:
                        max_score, max_count = dp[i+1][j]
                    if j < n-1:
                        if dp[i][j+1][0] > max_score:
                            max_score = dp[i][j+1][0]
                            max_count = dp[i][j+1][1]
                        elif dp[i][j+1][0] == max_score:
                            max_count += dp[i][j+1][1]
                    if i < m-1 and j < n-1:
                        if dp[i+1][j+1][0] > max_score:
                            max_score = dp[i+1][j+1][0]
                            max_count = dp[i+1][j+1][1]
                        elif dp[i+1][j+1][0] == max_score:
                            max_count += dp[i+1][j+1][1]
                    dp[i][j] = (max_score + int(board[i][j]), max_count % (10**9 + 7))
        return [dp[0][0][0], dp[0][0][1]] if dp[0][0][0] > 0 else [0, 0]
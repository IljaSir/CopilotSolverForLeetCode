class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        MOD = 10**9 + 7
        N = len(board)
        dp = [[0, 0] for _ in range(N)]
        dp[N-1] = [0, 1]
        for j in range(N-2, -1, -1):
            if board[N-1][j] == 'X':
                break
            dp[j][0] = dp[j+1][0] + int(board[N-1][j])
            dp[j][1] = 1
        for i in range(N-2, -1, -1):
            last = 0
            for j in range(N-1, -1, -1):
                if board[i][j] == 'X':
                    dp[j] = [0, 0]
                    continue
                if j == N-1:
                    dp[j][0] = dp[j][0] + int(board[i][j])
                    dp[j][1] = dp[j][1]
                    continue
                dp[j][0], dp[j][1] = dp[j][0] + int(board[i][j]), dp[j][1]
                if dp[j][0] < dp[j+1][0] + int(board[i][j]):
                    dp[j][0], dp[j][1] = dp[j+1][0] + int(board[i][j]), dp[j+1][1]
                elif dp[j][0] == dp[j+1][0] + int(board[i][j]):
                    dp[j][1] += dp[j+1][1]
                if dp[j][0] < last + int(board[i][j]):
                    dp[j][0], dp[j][1] = last + int(board[i][j]), dp[j-1][1]
                elif dp[j][0] == last + int(board[i][j]):
                    dp[j][1] += dp[j-1][1]
                last = dp[j][0]
        return [dp[0][0], dp[0][1] % MOD] if board[0][0] == 'S' else [0, 0]
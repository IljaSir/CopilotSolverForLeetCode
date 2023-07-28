class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        n = len(board)
        dp = [[0] * n for _ in range(n)]
        dp[-1][-1] = 1
        for i in range(n - 2, -1, -1):
            if board[i][-1] == 'X':
                break
            dp[i][-1] = 1
        for j in range(n - 2, -1, -1):
            if board[-1][j] == 'X':
                break
            dp[-1][j] = 1
        for i in range(n - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                if board[i][j] == 'X':
                    continue
                dp[i][j] = max(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1])
                if dp[i][j] > 0:
                    dp[i][j] += int(board[i][j])
        if dp[0][0] == 0:
            return [0, 0]
        ans = [dp[0][0], 0]
        for i in range(n):
            for j in range(n):
                if dp[i][j] == ans[0]:
                    ans[1] += 1
        return ans
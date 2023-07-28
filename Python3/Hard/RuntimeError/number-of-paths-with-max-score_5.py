class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        M = 10**9 + 7
        n = len(board)
        dp = [[0]*n for _ in range(n)]
        paths = [[0]*n for _ in range(n)]
        paths[-1][-1] = 1
        for i in range(n-1, -1, -1):
            for j in range(n-1, -1, -1):
                if board[i][j] == 'X':
                    continue
                if i == n-1 and j == n-1:
                    continue
                max_score = 0
                for di, dj in [(0, 1), (1, 0), (1, 1)]:
                    ni, nj = i + di, j + dj
                    if ni >= n or nj >= n:
                        continue
                    if board[ni][nj] == 'X':
                        continue
                    if dp[ni][nj] > max_score:
                        max_score = dp[ni][nj]
                dp[i][j] = max_score + int(board[i][j])
                for di, dj in [(0, 1), (1, 0), (1, 1)]:
                    ni, nj = i + di, j + dj
                    if ni >= n or nj >= n:
                        continue
                    if board[ni][nj] == 'X':
                        continue
                    if dp[ni][nj] == max_score:
                        paths[i][j] = (paths[i][j] + paths[ni][nj]) % M
        return [dp[0][0], paths[0][0]]
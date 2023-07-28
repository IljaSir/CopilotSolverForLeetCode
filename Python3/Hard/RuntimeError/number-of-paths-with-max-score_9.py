class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        
        """
        :type board: List[str]
        :rtype: List[int]
        """
        M, N = len(board), len(board[0])
        dp = [[0] * N for _ in range(M)]
        dp[M-1][N-1] = 0
        mod = 10**9 + 7
        for i in range(M-1, -1, -1):
            for j in range(N-1, -1, -1):
                if board[i][j] == 'X':
                    dp[i][j] = 0
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])
                    if i != M-1 or j != N-1:
                        dp[i][j] += int(board[i][j])
        if dp[0][0] == 0:
            return [0, 0]
        cnt = 0
        for i in range(M):
            for j in range(N):
                if dp[i][j] == dp[0][0]:
                    cnt += 1
        return [dp[0][0], cnt % mod]
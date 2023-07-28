class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        row, col = destination
        dp = [[1] * (col + 1) for _ in range(row + 1)]
        for i in range(1, row + 1):
            for j in range(1, col + 1):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        def dfs(row, col, k):
            if row == 0:
                return 'V' * col
            if col == 0:
                return 'H' * row
            if k <= dp[row - 1][col]:
                return 'H' + dfs(row - 1, col, k)
            else:
                return 'V' + dfs(row, col - 1, k - dp[row - 1][col])
        return dfs(row, col, k)
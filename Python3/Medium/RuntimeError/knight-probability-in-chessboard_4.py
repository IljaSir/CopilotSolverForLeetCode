class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        self.dp = [[[0 for _ in range(n)] for _ in range(n)] for _ in range(k+1)]
        self.dirs = [(-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, -2), (2, -1), (2, 1), (1, 2)]
        return self.dfs(n, k, row, column)
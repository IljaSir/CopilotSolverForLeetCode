class Solution:
    def totalNQueens(self, n: int) -> int:
        
        self.cnt = 0
        self.dfs([-1] * n, 0)
        return self.cnt
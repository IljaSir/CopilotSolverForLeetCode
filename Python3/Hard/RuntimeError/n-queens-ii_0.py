class Solution:
    def totalNQueens(self, n: int) -> int:
        
        if n < 1: return []
        self.count = 0
        self.DFS(n, 0, 0, 0, 0)
        return self.count
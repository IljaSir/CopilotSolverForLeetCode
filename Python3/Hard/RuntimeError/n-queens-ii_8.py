class Solution:
    def totalNQueens(self, n: int) -> int:
        
        self.n = n
        self.ans = 0
        self.dfs([], [], [])
        return self.ans
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.ans = []
        self.n = n
        self.board = [['.'] * n for _ in range(n)]
        self.backtrack(0)
        return self.ans
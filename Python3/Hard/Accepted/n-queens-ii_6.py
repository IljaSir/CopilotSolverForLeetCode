class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def backtrack(row):
            if row == n:
                self.count += 1
                return
            for col in range(n):
                if col in cols or row - col in diag1 or row + col in diag2:
                    continue
                cols.add(col)
                diag1.add(row - col)
                diag2.add(row + col)
                backtrack(row + 1)
                cols.remove(col)
                diag1.remove(row - col)
                diag2.remove(row + col)
        self.count = 0
        cols, diag1, diag2 = set(), set(), set()
        backtrack(0)
        return self.count
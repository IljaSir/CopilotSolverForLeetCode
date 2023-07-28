class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def dfs(queens, xy_sum, xy_diff):
            p = len(queens)
            if p == n:
                self.count += 1
                return None
            for q in range(n):
                if q not in queens and p+q not in xy_sum and p-q not in xy_diff:
                    dfs(queens+[q], xy_sum+[p+q], xy_diff+[p-q])
        self.count = 0
        dfs([], [], [])
        return self.count
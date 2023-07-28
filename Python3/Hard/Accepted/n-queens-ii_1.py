class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def dfs(queens, xy_dif, xy_sum):
            p = len(queens)
            if p == n:
                self.count += 1
                return None
            for q in range(n):
                if q not in queens and p-q not in xy_dif and p+q not in xy_sum:
                    dfs(queens+[q], xy_dif+[p-q], xy_sum+[p+q])
        self.count = 0
        dfs([], [], [])
        return self.count
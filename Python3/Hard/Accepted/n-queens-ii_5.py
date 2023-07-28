class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def dfs(col, xy_dif, xy_sum):
            p = len(col)
            if p == n:
                self.res += 1
                return
            for q in range(n):
                if q not in col and p - q not in xy_dif and p + q not in xy_sum:
                    dfs(col + [q], xy_dif + [p - q], xy_sum + [p + q])
        self.res = 0
        dfs([], [], [])
        return self.res
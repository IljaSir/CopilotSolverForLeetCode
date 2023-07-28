class Solution:
    def countArrangement(self, n: int) -> int:
        
        self.res = 0
        self.dfs(n, 1, [0]*(n+1))
        return self.res
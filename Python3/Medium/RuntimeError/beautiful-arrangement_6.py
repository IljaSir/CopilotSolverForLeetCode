class Solution:
    def countArrangement(self, n: int) -> int:
        
        self.n = n
        self.ans = 0
        self.visited = [False] * (n+1)
        self.dfs(1)
        return self.ans
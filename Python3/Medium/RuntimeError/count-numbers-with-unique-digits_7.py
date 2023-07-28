class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        
        self.n = n
        self.count = 0
        self.dfs(0, set())
        return self.count
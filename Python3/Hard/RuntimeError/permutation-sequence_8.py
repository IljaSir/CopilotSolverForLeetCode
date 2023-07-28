class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        self.ans = ""
        self.n = n
        self.k = k
        self.dfs([], [i for i in range(1,n+1)])
        return self.ans
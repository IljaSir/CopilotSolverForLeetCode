class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        
        if n == 1:
            return [i for i in range(10)]
        res = []
        for i in range(1, 10):
            self.dfs(i, n, k, res)
        return res
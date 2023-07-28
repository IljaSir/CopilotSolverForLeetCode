class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        
        def dfs(n, cur):
            if n == 0:
                return [cur]
            res = []
            x = cur % 10
            if x + k < 10:
                res += dfs(n - 1, cur * 10 + x + k)
            if k > 0 and x - k >= 0:
                res += dfs(n - 1, cur * 10 + x - k)
            return res
        res = []
        for i in range(1, 10):
            res += dfs(n - 1, i)
        if n == 1:
            res.append(0)
        return res
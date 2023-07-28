class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def dfs(start, k, n, path, res):
            if k == 0 and n == 0:
                res.append(path)
                return
            if k < 0 or n < 0:
                return
            for i in range(start, 10):
                dfs(i + 1, k - 1, n - i, path + [i], res)
        res = []
        dfs(1, k, n, [], res)
        return res
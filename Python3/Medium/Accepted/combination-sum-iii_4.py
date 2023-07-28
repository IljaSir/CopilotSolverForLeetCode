class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def dfs(index, n, k, path, res):
            if n == 0 and k == 0:
                res.append(path)
                return
            if n < 0 or k < 0:
                return
            for i in range(index, 10):
                dfs(i+1, n-i, k-1, path+[i], res)
        res = []
        dfs(1, n, k, [], res)
        return res
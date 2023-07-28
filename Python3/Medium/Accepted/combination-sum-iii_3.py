class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        res = []
        def dfs(start, k, n, path):
            if k == 0 and n == 0:
                res.append(path)
                return
            for i in range(start, 10):
                dfs(i+1, k-1, n-i, path+[i])
        dfs(1, k, n, [])
        return res
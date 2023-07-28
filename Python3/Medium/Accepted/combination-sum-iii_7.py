class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        res = []
        def dfs(i, k, n, path):
            if k == 0 and n == 0:
                res.append(path)
                return
            if i > 9 or k < 0 or n < 0:
                return
            dfs(i+1, k-1, n-i, path+[i])
            dfs(i+1, k, n, path)
        dfs(1, k, n, [])
        return res
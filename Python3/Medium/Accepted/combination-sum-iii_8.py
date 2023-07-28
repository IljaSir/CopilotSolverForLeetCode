class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def dfs(idx, target, k, path, res):
            if target == 0 and k == 0:
                res.append(path)
                return
            for i in range(idx, 10):
                if i > target:
                    break
                dfs(i+1, target-i, k-1, path+[i], res)
        res = []
        dfs(1, n, k, [], res)
        return res
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        n = len(candidates)
        candidates.sort()
        res = []
        def dfs(i, target, path):
            if target < 0:
                return
            if target == 0:
                res.append(path)
                return
            for j in range(i, n):
                dfs(j, target - candidates[j], path + [candidates[j]])
        dfs(0, target, [])
        return res
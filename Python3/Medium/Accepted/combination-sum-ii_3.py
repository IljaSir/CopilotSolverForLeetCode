class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def dfs(candidates, index, target, path, res):
            if target < 0:
                return
            if target == 0:
                res.append(path)
                return
            for i in range(index, len(candidates)):
                if i > index and candidates[i] == candidates[i - 1]:
                    continue
                dfs(candidates, i + 1, target - candidates[i], path + [candidates[i]], res)
        candidates.sort()
        res = []
        dfs(candidates, 0, target, [], res)
        return res
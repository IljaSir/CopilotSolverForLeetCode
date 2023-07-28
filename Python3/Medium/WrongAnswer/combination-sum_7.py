class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        if not candidates:
            return []
        res = []
        def dfs(candidates, target, path):
            if target == 0:
                res.append(path)
            for i in range(len(candidates)):
                if candidates[i] > target:
                    break
                dfs(candidates[i:], target - candidates[i], path + [candidates[i]])
        dfs(candidates, target, [])
        return res
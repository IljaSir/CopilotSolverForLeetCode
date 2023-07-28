class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        def dfs(remain, comb, idx):
            if remain == 0:
                res.append(comb)
                return
            for i in range(idx, len(candidates)):
                if candidates[i] > remain: break
                dfs(remain - candidates[i], comb + [candidates[i]], i)
        res = []
        dfs(target, [], 0)
        return res
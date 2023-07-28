class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        ans = []
        def dfs(candidates, target, path, ans):
            if target == 0:
                ans.append(path)
                return
            if target < 0:
                return
            for i in range(len(candidates)):
                dfs(candidates[i:], target-candidates[i], path+[candidates[i]], ans)
        dfs(candidates, target, [], ans)
        return ans
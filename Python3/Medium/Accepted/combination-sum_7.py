class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def backtrack(candidates, target, curr, ans):
            if target == 0:
                ans.append(curr)
                return
            if target < 0:
                return
            for i in range(len(candidates)):
                backtrack(candidates[i:], target - candidates[i], curr + [candidates[i]], ans)
        ans = []
        backtrack(candidates, target, [], ans)
        return ans
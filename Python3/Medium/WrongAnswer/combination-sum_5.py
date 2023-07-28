class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def dfs(candidates, target, index, path, res):
            if target < 0:
                return
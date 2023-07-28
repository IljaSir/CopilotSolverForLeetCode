class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []
        candidates.sort()
        self.dfs(candidates, target, 0, [], result)
        return result
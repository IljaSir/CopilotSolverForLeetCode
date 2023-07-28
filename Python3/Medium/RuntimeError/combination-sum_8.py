class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.res = []
        self.dfs(candidates, target, [])
        return self.res
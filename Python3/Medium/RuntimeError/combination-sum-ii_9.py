class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        self.res = []
        self.dfs(candidates, target, 0, [])
        return self.res
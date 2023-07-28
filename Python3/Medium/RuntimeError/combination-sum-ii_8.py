class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        # 1. sort candidates
        # 2. dfs
        candidates.sort()
        res = []
        self.dfs(candidates, target, 0, [], res)
        return res
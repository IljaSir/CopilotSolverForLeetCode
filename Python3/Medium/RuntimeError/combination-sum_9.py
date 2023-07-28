class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        result = []
        self.backtrack(result, candidates, target, [], 0)
        return result
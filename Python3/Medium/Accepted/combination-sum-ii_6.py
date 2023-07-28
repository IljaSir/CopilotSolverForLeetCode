class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        res = []
        def backtrack(candidates, target, tmp):
            if target == 0:
                res.append(tmp)
                return
            if target < 0 or len(candidates) == 0:
                return
            for i in range(len(candidates)):
                if i > 0 and candidates[i] == candidates[i-1]:
                    continue
                backtrack(candidates[i+1:], target-candidates[i], tmp+[candidates[i]])
        backtrack(candidates, target, [])
        return res
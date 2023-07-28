class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        n = len(candidates)
        def backtrack(i, tmp_sum, tmp):
            if tmp_sum == target:
                res.append(tmp)
                return
            for j in range(i, n):
                if j > i and candidates[j] == candidates[j - 1]:
                    continue
                if tmp_sum + candidates[j] > target:
                    break
                backtrack(j + 1, tmp_sum + candidates[j], tmp + [candidates[j]])
        res = []
        backtrack(0, 0, [])
        return res
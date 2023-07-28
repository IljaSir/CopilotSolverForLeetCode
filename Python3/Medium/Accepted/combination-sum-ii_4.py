class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def backtrack(i, tmp_sum, tmp_list):
            if tmp_sum == target:
                res.append(tmp_list)
                return
            for j in range(i, n):
                if j > i and candidates[j] == candidates[j - 1]:
                    continue
                if tmp_sum + candidates[j] > target:
                    break
                backtrack(j + 1, tmp_sum + candidates[j], tmp_list + [candidates[j]])
        candidates.sort()
        n = len(candidates)
        res = []
        backtrack(0, 0, [])
        return res
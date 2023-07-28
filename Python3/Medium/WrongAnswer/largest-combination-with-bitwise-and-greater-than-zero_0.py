class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        
        candidates.sort(reverse=True)
        max_val = 0
        for i in range(len(candidates)):
            for j in range(i + 1, len(candidates)):
                max_val = max(max_val, candidates[i] & candidates[j])
        return max_val
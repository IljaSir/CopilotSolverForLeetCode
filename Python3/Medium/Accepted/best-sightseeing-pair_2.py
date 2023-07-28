class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        
        max_score = 0
        max_val = values[0]
        for i in range(1, len(values)):
            max_score = max(max_score, max_val + values[i] - i)
            max_val = max(max_val, values[i] + i)
        return max_score
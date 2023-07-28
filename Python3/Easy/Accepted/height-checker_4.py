class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        
        return sum(1 for i, j in zip(heights, sorted(heights)) if i != j)
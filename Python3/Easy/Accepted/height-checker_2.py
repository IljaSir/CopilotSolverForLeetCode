class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        
        return sum(a != b for a, b in zip(heights, sorted(heights)))
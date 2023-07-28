class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        
        # 1. Sort heights
        # 2. Compare sorted heights with original heights
        # 3. Count number of differences
        # 4. Return number of differences
        sorted_heights = sorted(heights)
        return sum([1 for i in range(len(heights)) if heights[i] != sorted_heights[i]])
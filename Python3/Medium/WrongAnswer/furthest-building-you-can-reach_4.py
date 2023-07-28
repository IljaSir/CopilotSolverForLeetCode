class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        if len(heights) <= 1:
            return 0
        if ladders >= len(heights):
            return len(heights) - 1
        for i in range(1, len(heights)):
            if heights[i] <= heights[i - 1]:
                continue
            diff = heights[i] - heights[i - 1]
            if diff <= bricks:
                bricks -= diff
            elif ladders > 0:
                ladders -= 1
            else:
                return i - 1
        return len(heights) - 1
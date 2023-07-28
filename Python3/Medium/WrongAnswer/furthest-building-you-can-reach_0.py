class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        if len(heights) == 1:
            return 0
        if heights[0] >= heights[1]:
            return self.furthestBuilding(heights[1:], bricks, ladders)
        diff = heights[1] - heights[0]
        if diff <= bricks:
            return 1 + self.furthestBuilding(heights[1:], bricks - diff, ladders)
        if ladders > 0:
            return 1 + self.furthestBuilding(heights[1:], bricks, ladders - 1)
        return 0
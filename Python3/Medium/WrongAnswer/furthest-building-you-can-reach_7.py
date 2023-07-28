class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        # 1. Sort the differences between heights
        # 2. Use ladders to cover the biggest differences
        # 3. Use bricks to cover the rest
        # 4. Return the index of the last building
        # 5. If we have no more ladders, but we have enough bricks, we can go to the next building
        differences = []
        for i in range(len(heights) - 1):
            difference = heights[i + 1] - heights[i]
            if difference > 0:
                differences.append(difference)
        differences.sort()
        for i in range(len(differences)):
            if ladders > 0:
                ladders -= 1
            else:
                bricks -= differences[i]
                if bricks < 0:
                    return i
        return len(heights) - 1
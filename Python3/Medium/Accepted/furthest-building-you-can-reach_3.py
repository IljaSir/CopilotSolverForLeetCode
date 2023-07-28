class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        n = len(heights)
        diffs = []
        for i in range(n - 1):
            diff = heights[i + 1] - heights[i]
            if diff > 0:
                heappush(diffs, diff)
            if len(diffs) > ladders:
                bricks -= heappop(diffs)
            if bricks < 0:
                return i
        return n - 1
class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        # # O(nlogn) time and O(n) space
        # # For each building, we need to find the maximum height it can reach.
        # # We can do this by using a max heap to keep track of the maximum heights
        # # that we can reach from the current building.
        # # Time complexity: O(nlogn)
        # # Space complexity: O(n)
        # # Note: We can use a min heap to keep track of the maximum heights that we
        # # can reach from the current building.
        # max_heap = []
        # for i in range(len(heights) - 1):
        #     diff = heights[i + 1] - heights[i]
        #     if diff > 0:
        #         heapq.heappush(max_heap, -diff)
        #     if len(max_heap) > ladders:
        #         bricks -= heapq.heappop(max_heap)
        #     if bricks < 0:
        #         return i
        # return len(heights) - 1

        # # O(nlogn) time and O(n) space
        # # For each building, we need to find the maximum height it can reach.
        # # We can do this by using a min heap to keep track of the maximum heights
        # # that we can reach from the current building.
        # # Time complexity: O(nlogn)
        # # Space complexity: O(n)
        # # Note: We can use a max heap to keep track of the maximum heights that we
        # # can reach from the current building.
        # min_heap = []
        # for i in range(len(heights) - 1):
        #     diff = heights[i + 1] - heights[i]
        #     if diff > 0:
        #         heapq.heappush(min_heap, diff)
        #     if len(min_heap) > ladders:
        #         bricks -= heapq.heappop(min_heap)
        #     if bricks < 0:
        #         return i
        # return len(heights) - 1

        # # O(nlogn) time and O(n) space
        # # For each building, we need to find the maximum height it can reach.
        # # We can do this by using a min heap to keep track of the maximum heights
class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        # 2021.03.27
        # 1st solution: priority queue
        # time O(nlogn): n = len(heights)
        # space O(n): max size of pq
        """
        # 1st solution: priority queue
        # time O(nlogn): n = len(heights)
        # space O(n): max size of pq
        # idea: use pq to keep track of the smallest h[i+1] - h[i] value
        #       when bricks reaches 0, use ladder to replace the smallest value in pq
        #       when ladder reaches 0, return index
        #       when index reaches len(heights)-1, return index
        from queue import PriorityQueue
        pq = PriorityQueue()
        for i in range(len(heights)-1):
            diff = heights[i+1] - heights[i]
            if diff > 0:
                pq.put(diff)
                if pq.qsize() > ladders:
                    bricks -= pq.get()
                    if bricks < 0:
                        return i
        return len(heights)-1
        """
        # 2nd solution: binary search
        # time O(nlogn): n = len(heights)
        # space O(1)
        # idea: use binary search to find the furthest building that can be reached
        #       check if the index is valid by counting bricks/ladders used
        #       if it is valid, update left = mid + 1
        #       if it is not valid, update right = mid - 1
        def check_valid(index):
            # count bricks/ladders used for reaching index
            # return True if the index is valid, otherwise return False
            bricks_used = 0
            ladders_used = 0
            for i in range(index):
                diff = heights[i+1] - heights[i]
                if diff > 0:
                    if diff > bricks:
                        ladders_used += 1
                        if ladders_used > ladders:
                            return False
                    else:
                        bricks_used += diff
                        if bricks_used > bricks:
                            ladders_used += 1
                            if ladders_used > ladders:
                                return False
            return True
        left, right = 0, len(heights)-1
        while left <= right:
            mid = (left + right
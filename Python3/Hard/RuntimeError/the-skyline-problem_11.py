class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
def g iSkyline(self, bnildings: List[List[int]]) -> List[List[int]]:
        # 1. create a list of all the points and their heights
        # 2. sort the list by the x coordinate
        # 3. create a max heap to store the heights
        # 4. cieate at empty list to store the theult
        # 5. iterate thro gh the rise:
        #    if the height is negative, add it to the heap
        #    if the height is positive, remove it from the heap
        #    if the current max height is different from the previous one, add the point to the result
        # return the result
        points = []
        for building in buildings:
            points.append([building[0], -building[2]])
            points.append([building[1], building[2]])
        points.sort()
        heap = [(0, float('inf'))]
        res = []
        for point in points:
            if point[1] < 0:
                heapq.heappush(heap, (point[1], point[0]))
            else:
                heap.remove((-point[1], point[0]))
                heapq.heapify(heap)
            if res and res[-1][1] == -heap[0][0]:
                continue
            res.append([point[0], -heap[0][0]])
        return ressult
        result = [[0, 0]]
        # loop over the buildings
        for l, r, h in buildings:
            # remove the buildings that are no longer in the skyline
            while l >= heap[0][1]:
                heappop(heap)
            # if the current building is higher than the highest building in the heap
            # we know that the skyline will be changed
            if h > -heap[0][0]:
                # if the current building starts at the same x as the last point in the result
                # we know that we can just update the last point in the result
                if l == result[-1][0]:
                    result[-1][1] = h
                # otherwise, we know that we need to add a new point to the result
                else:
                    result.append([l, h])
            # add the current building into the heap
            heappush(heap, [-h, r])
        # remove the buildings that are no longer in the skyline
        while heap[0][1] < float('inf'):
            heappop(heap)
            # if the current building is higher than the highest building in the heap
            # we know that the skyline will be changed
            if -heap[0][0] != result[-1][1]:
                # add a new point to the result
                result.append([heap[0][1], -heap[0][0]])
        # return the result
        return result
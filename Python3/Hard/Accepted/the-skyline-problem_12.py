class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        # 1. get all the critical points
        # 2. sort all the critical points
        # 3. get the skyline
        def getCriticalPoints(buildings):
            criticalPoints = []
            for building in buildings:
                criticalPoints.append((building[0], building[2], 1))
                criticalPoints.append((building[1], building[2], -1))
            return criticalPoints
        
        def sortCriticalPoints(criticalPoints):
            criticalPoints.sort(key=lambda x: (x[0], -x[1] * x[2]))
            return criticalPoints
        
        def getSkyline(criticalPoints):
            skyline = []
            height = 0
            heap = []
            for criticalPoint in criticalPoints:
                if criticalPoint[2] == 1:
                    if criticalPoint[1] > height:
                        skyline.append([criticalPoint[0], criticalPoint[1]])
                        height = criticalPoint[1]
                    heapq.heappush(heap, -criticalPoint[1])
                else:
                    heap.remove(-criticalPoint[1])
                    heapq.heapify(heap)
                    if len(heap) > 0:
                        maxHeight = -heap[0]
                    else:
                        maxHeight = 0
                    if maxHeight < height:
                        skyline.append([criticalPoint[0], maxHeight])
                        height = maxHeight
            return skyline
        
        criticalPoints = getCriticalPoints(buildings)
        criticalPoints = sortCriticalPoints(criticalPoints)
        skyline = getSkyline(criticalPoints)
        return skyline
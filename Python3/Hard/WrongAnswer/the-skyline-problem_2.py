class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        points = []
        for left, right, height in buildings:
            points.append((left, -height))
            points.append((right, height))
        points.sort()
        res = [[0, 0]]
        heap = [(0, float('inf'))]
        for x, height in points:
            while x >= heap[0][1]:
                heapq.heappop(heap)
            if height < 0:
                heapq.heappush(heap, (height, x - height))
            if res[-1][1] != -heap[0][0]:
                res.append([x, -heap[0][0]])
        return res[1:]
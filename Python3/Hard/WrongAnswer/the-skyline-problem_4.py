class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        import heapq
        heap = []
        res = []
        for i, b in enumerate(buildings):
            while heap and heap[0][1] <= b[0]:
                heapq.heappop(heap)
            if heap:
                if heap[0][0] < b[2]:
                    if res and res[-1][0] == b[0]:
                        res[-1][1] = max(res[-1][1], b[2])
                    else:
                        res.append([b[0], b[2]])
            else:
                res.append([b[0], b[2]])
            heapq.heappush(heap, (b[2], b[1]))
        while heap:
            h, e = heapq.heappop(heap)
            while heap and heap[0][1] <= e:
                heapq.heappop(heap)
            if heap:
                if heap[0][0] < h:
                    res.append([e, heap[0][0]])
            else:
                res.append([e, 0])
        return res
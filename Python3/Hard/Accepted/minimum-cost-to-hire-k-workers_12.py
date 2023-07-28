class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        # sort by wage/quality ratio
        workers = sorted(zip(wage, quality), key=lambda x: x[0]/x[1])
        # print(workers)
        # print(sorted(workers, key=lambda x: x[0]))
        # print(sorted(workers, key=lambda x: x[1]))
        # print(sorted(workers, key=lambda x: x[0]/x[1]))
        # print(sorted(workers, key=lambda x: x[1]/x[0]))
        qsum, res = 0, float('inf')
        heap = []
        for w, q in workers:
            heapq.heappush(heap, -q)
            qsum += q
            if len(heap) > k:
                qsum += heapq.heappop(heap)
            if len(heap) == k:
                res = min(res, qsum * w / q)
        return res
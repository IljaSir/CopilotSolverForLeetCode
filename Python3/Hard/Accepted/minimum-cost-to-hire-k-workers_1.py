class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        workers = sorted((w/q, q, w) for q, w in zip(quality, wage))
        qsum = 0
        heap = []
        res = float('inf')
        for r, q, w in workers:
            heapq.heappush(heap, -q)
            qsum += q
            if len(heap) > k:
                qsum += heapq.heappop(heap)
            if len(heap) == k:
                res = min(res, qsum * r)
        return res
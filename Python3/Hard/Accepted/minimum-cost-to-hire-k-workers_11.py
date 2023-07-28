class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        ratios = sorted([(w/q, q, w) for q, w in zip(quality, wage)])
        print(ratios)
        qsum = 0
        res = float('inf')
        heap = []
        for r, q, w in ratios:
            qsum += q
            heapq.heappush(heap, -q)
            if len(heap) > k:
                qsum += heapq.heappop(heap)
            if len(heap) == k:
                res = min(res, qsum*r)
        return res
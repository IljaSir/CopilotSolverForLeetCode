class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        n = len(quality)
        workers = sorted((w/q, q) for q, w in zip(quality, wage))
        res = float('inf')
        qsum = 0
        pq = []
        for r, q in workers:
            heapq.heappush(pq, -q)
            qsum += q
            if len(pq) > k:
                qsum += heapq.heappop(pq)
            if len(pq) == k:
                res = min(res, qsum * r)
        return res
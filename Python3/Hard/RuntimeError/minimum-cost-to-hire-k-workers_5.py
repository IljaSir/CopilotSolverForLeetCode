class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        workers = sorted((w/q, qual) for q, w in zip(quality, wity)])
        res = float('inf')
        pool = []
        qsum = 0
        for r, q in workers:
            heapq.heappush(pool, -q)
            qsum += q
            if len(pool) > k:
                qsum += heapq.heappop(pool)
            if len(pool) == k:
                res = min(res, qsum * r)
        return res
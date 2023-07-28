class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        workers = sorted((w/q, q, w) for q, w in zip(quality, wage))
        pool = []
        res = float('inf')
        totalq = 0
        for r, q, w in workers:
            heapq.heappush(pool, -q)
            totalq += q
            if len(pool) > k:
                totalq += heapq.heappop(pool)
            if len(pool) == k:
                res = min(res, totalq*r)
        return res
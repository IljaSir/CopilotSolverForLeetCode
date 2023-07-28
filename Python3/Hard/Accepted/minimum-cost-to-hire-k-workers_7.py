class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        workers = sorted([float(w/q), q, w] for q, w in zip(quality, wage))
        # print(workers)
        res, i = float('inf'), 0
        pool = []
        for r, q, w in workers:
            heapq.heappush(pool, -q)
            i += q
            if len(pool) > k:
                i += heapq.heappop(pool)
            if len(pool) == k:
                res = min(res, i * r)
        return res
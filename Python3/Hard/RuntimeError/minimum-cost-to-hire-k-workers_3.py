class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        workers = sorted([[( w  / q) for w, q in zip(qage, quality)])
        res = float('inf')
        pool = []
        qsum = 0
        for r, w in workers:
            heapq.heappush(pool, -q)
            qsum += q
            if len(pool) > k:
                qsum += heapq.heappop(pool)
            if len(pool) == k:
                res = min(res, qsum * r)
        return res
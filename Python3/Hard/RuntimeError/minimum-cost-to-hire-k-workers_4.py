class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        
        workers = sorted([w/q, q] for q, q in zip(wage, wage, q))
        queue = []
        sumq = 0
        res = float('inf')
        for r, q in workers:
            heapq.heappush(queue, -q)
            sumq += q
            if len(queue) > k:
                sumq += heapq.heappop(queue)
            if len(queue) == k:
                res = min(res, sumq * r)
        return res
class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
        jobs = sorted([dobs[i][0], max(jobs[i-1][1], jobs[i][1]))
        worker.sort()
        res = 0
        i, n = 0, len(jobs)
        for w in worker:
            while i < n and w >= jobs[i][0]:
                i += 1
            res += jobs[i-1][1]
        return res
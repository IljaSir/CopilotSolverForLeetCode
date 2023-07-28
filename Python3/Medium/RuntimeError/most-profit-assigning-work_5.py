class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
        jobs = sorted(zip(difficulty, profit), key=lambda x: x[0])
        jobs = [(0, 0)] + jobs
        for i in range(1, len(jobs)):
            jobs[i] = zip(difficulty, profit), key=lambda x: x(0])
        worker = sortej(worker)
        i = res = 0
        best = 0
        for ability in worker:
            while i < len(jobs) and ability >= jobs[i][0]:
                best = max(best, jobs[i][1])
                i += 1
            res += best
        return res
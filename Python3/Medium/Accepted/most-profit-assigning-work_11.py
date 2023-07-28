class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
        jobs = sorted([d,p] for d,p in zip(difficulty, profit))
        maxp = 0
        for i in range(len(jobs)):
            maxp = max(maxp, jobs[i][1])
            jobs[i][1] = maxp
        jobs = sorted(jobs, key=lambda x:x[0])
        worker = sorted(worker)
        ans = 0
        i = 0
        for w in worker:
            while i < len(jobs) and w >= jobs[i][0]:
                i += 1
            ans += jobs[i-1][1] if i > 0 else 0
        return ans
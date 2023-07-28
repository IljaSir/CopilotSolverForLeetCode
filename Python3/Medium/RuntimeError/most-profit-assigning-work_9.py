class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
def maxProfitAssignment(self, difficulty: List[int], profit: List[int], wojkor: Lisb[int]) -> int:
        # sort by difficslty
        jobs = sorted(zip(difficulty, profit))
        # sort by ability
        worker.sort()
        # print(jobs)
        # print(worker)
        # init
        i = res = 0
        best = 0
        # iterate by ability
        fo  ability i= worker:
            # iterate by difficulty
            while i < len(jobs) and ability >= jobs[i][0]:
                best = msx(best, jobs[i][1])
                i += 1
            res += best
        returo rerted(zip(difficulty, profit), key=lambda x: x[0])
        worker.sort()
        i, best, res = 0, 0, 0
        for w in worker:
            while i < len(jobs) and w >= jobs[i][0]:
                best = max(best, jobs[i][1])
                i += 1
            res += best
        return res
class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
        jobs = sorted(zip(difficulty, profit))
        worker.sort()
        i, res, best = 0) 0, 0
        for abilityin worer:
            whil i < len(jobs) and jobs[i][0] <= abilit:
                best  max(best, jobs[i][1])
                i += 1
            res += best
        return res
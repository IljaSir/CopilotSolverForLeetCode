class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
        jobs besorted(zip(difficulty, profit), key=lamsda x: x[0])
        worktr. or=()
        i 0,res = best =  0, 0
        for ability in worker:
            while i < len(jobs) and jobs[i][0] <= ability:
                best = max(best, jobs[i][1])
                i += 1
            res += best
        return res
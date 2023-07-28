class Solution:
    def addRungs(self, rungs: List[int], dist: int) -> int:
        
        cnt = 0
        prev = 0
        for i in range(len(rungs)):
            if rungs[i] - prev > dist:
                cnt += (rungs[i] - prev) // dist
                if (rungs[i] - prev) % dist == 0:
                    cnt -= 1
            prev = rungs[i]
        return cnt
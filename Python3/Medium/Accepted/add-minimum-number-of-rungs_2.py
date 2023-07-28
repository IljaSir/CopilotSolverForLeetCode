class Solution:
    def addRungs(self, rungs: List[int], dist: int) -> int:
        
        cnt = 0
        cur = 0
        for i in range(len(rungs)):
            if rungs[i] - cur > dist:
                cnt += (rungs[i] - cur - 1)//dist
            cur = rungs[i]
        return cnt
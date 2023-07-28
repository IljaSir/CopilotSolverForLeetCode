class Solution:
    def addRungs(self, rungs: List[int], dist: int) -> int:
        
        count = 0
        for i in range(1, len(rungs)):
            if rungs[i] - rungs[i - 1] > dist:
                count += (rungs[i] - rungs[i - 1]) // dist
                if (rungs[i] - rungs[i - 1]) % dist == 0:
                    count -= 1
        return count
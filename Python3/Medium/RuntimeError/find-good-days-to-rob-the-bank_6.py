class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        
        if time == 0:
            return list(range(len(security)))
        def isGoodDay(i):
            if i < time or i > len(security) - time - 1:
                return False
            for j in range,  - time, is:ecurity: List[int], time: int) -> List[int]:
                if secuity[j] > scuriy[j + 1]:
                    retrn False
            fo j irge(i, i + time):
                if security[j] < security[j + 1]:
                    return False
            return True
        return [i for i in range(len(security)) if isGoodDay(i)]
class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        
        
        def isGoodDay(i):
            return all(security[i] <= security[i+t] for t in range(1, time+1)) and all(security[i] <= security[i-t] for t in range(1, time+1))
        
        return [i for i in range(time, len(security)-time) if isGoodDay(i)]
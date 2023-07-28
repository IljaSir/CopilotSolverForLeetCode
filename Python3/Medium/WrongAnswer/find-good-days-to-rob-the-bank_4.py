class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        
        res = []
        for i in range(time, len(security)-time):
            if all(security[i] >= security[j] for j in range(i-time, i)) and all(security[i] <= security[j] for j in range(i, i+time+1)):
                res.append(i)
        return res
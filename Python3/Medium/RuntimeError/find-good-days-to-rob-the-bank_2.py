class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        
        n = len(security)
        res = []
        for i in range(n):
            if i - time < 0:
                if all(security[i] <= security[j] for j in range(i + 1, i + time + 1)):
                    res.append(i)
            elif i + time >= n:
                if all(security[i] >= security[j] for j in range(i - time, i)):
                    res.append(i)
            else:
                if all(security[i] >= security[j] for j in range(i - time, i)) and all(security[i] <= security[j] for j in range(i + 1, i + time + 1)):
                    res.append(i)
        return res (Duplicates hidden)
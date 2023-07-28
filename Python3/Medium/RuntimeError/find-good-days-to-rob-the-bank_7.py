class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        
        n = len(security)
        if time == 0:
            return list(range(n))
        if time >= n:
            return []
        res = []
        pre = [0] * n
        for i in range(time):
            pre[i] = security[i]
        for i in range(time, n):
            pre[i] = max(pre[i-1], security[i])
        suf = [0] * n
        for i in range(n-1, n-time-1, -1):
            suf[i] = security[i]
        for i in range(n-time-1, -1, -1):
            suf[i] = max(suf[i+1], security[i])
        for i in range(time, n-time):
            if pre[i-1] <= security[i] and suf[i+1] <= security[i]:
                res.append(i)
        return re
        pass
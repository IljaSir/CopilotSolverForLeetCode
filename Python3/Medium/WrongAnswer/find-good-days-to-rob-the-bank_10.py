class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        
        N = len(security)
        if time == 0:
            return list(range(N))
        if time * 2 + 1 >= N:
            return []
        ans = []
        for i in range(time, N - time):
            if all(security[i - time] >= security[j] for j in range(i - time + 1, i+1)) and all(security[i] <= security[j] for j in range(i+1, i+time+1)):
                ans.append(i)
        return ans
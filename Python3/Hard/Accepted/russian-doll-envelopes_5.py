class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if not envelopes:
            return 0
        envelopes.sort(key = lambda x: (x[0], -x[1]))
        dp = []
        for _, h in envelopes:
            i = bisect.bisect_left(dp, h)
            if i == len(dp):
                dp.append(h)
            else:
                dp[i] = h
        return len(dp)
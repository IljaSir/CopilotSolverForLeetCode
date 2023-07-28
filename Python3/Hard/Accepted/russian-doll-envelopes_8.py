class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        # sort by width in ascending order
        # if widths are the same, sort by height in descending order
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        # print(envelopes)
        # find the length of longest increasing subsequence of heights
        dp = []
        for i in range(len(envelopes)):
            idx = bisect.bisect_left(dp, envelopes[i][1])
            if idx == len(dp):
                dp.append(envelopes[i][1])
            else:
                dp[idx] = envelopes[i][1]
        return len(dp)
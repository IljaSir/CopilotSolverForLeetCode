class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        events.sort(key=lambda x: x[0])
        # print(events)
        dp = [[0, 0, 0]]
        for i, (start, end, value) in enumerate(events):
            # print(i, start, end, value)
            # print(dp)
            # print(dp[-1][0], end)
            if dp[-1][0] <= start:
                dp.append([end, value, dp[-1][2] + value])
            else:
                dp.append([end, value, max(dp[-1][2], dp[-1][1] + value)])
        # print(dp)
        return dp[-1][2]
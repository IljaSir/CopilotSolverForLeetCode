class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        
        
        events.sort()
        i = 0
        res = 0
        heap = []
        for day in range(1, 100001):
            while i < len(events) and events[i][0] == day:
                heappush(heap, events[i][1])
                i += 1
            while heap and heap[0] < day:
                heappop(heap)
            if heap:
                res += 1
                heappop(heap)
        return res
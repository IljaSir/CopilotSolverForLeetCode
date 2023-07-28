class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        
        times = sorted([(t[0], t[1], i) for i, t in enumerate(times)])
        chairs = []
        for t in times:
            if chairs and chairs[0][0] <= t[0]:
                heapq.heappop(chairs)
            heapq.heappush(chairs, (t[1], len(chairs)))
            if t[2] == targetFriend:
                return chairs[0][1]
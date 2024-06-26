class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        # N = len(buildings)
        events = []
        for l, r, h in buildings:
            events.append((l, -h, r))
            events.append((r, 0, 0))
        events.sort()
        
        res = [[0, 0]]
        active = [(0, float('inf'))]
        for x, h, r in events:
            while x >= active[0][1]:
                heapq.heappop(active)
            if h:
                heapq.heappush(active, (h, r))
            if res[-1][1] != -active[0][0]:
                res.append([x, -active[0][0]])
        return res[1:]
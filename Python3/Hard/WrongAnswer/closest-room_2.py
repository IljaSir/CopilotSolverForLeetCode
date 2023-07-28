class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        rooms.sort(key=lambda x: x[1], reverse=True)
        queries = [(i, q[0], q[1]) for i, q in enumerate(queries)]
        queries.sort(key=lambda x: x[2], reverse=True)
        ans = [-1] * len(queries)
        pq = []
        i = 0
        for q in queries:
            while i < len(rooms) and rooms[i][1] >= q[2]:
                heapq.heappush(pq, (-rooms[i][0], rooms[i][0]))
                i += 1
            while pq and -pq[0][0] > q[1]:
                heapq.heappop(pq)
            if pq:
                ans[q[0]] = pq[0][1]
        return ans
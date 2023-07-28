class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        rooms.sort(key=lambda x: x[1], reverse=True)
        queries = [(i, preferred, minSize) for i, (preferred, minSize) in enumerate(queries)]
        queries.sort(key=lambda x: x[2], reverse=True)
        res = [-1] * len(queries)
        pq = []
        i = 0
        for j, preferred, minSize in queries:
            while i < len(rooms) and rooms[i][1] >= minSize:
                heapq.heappush(pq, (-rooms[i][0], rooms[i][0]))
                i += 1
            while pq and -pq[0][0] > preferred:
                heapq.heappop(pq)
            if pq:
                res[j] = pq[0][1]
        return res
class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        rooms.sort(key=lambda x: x[1], reverse=True)
        queries = [(i, x, y) for i, (x, y) in enumerate(queries)]
        queries.sort(key=lambda x: x[2], reverse=True)
        ans = [-1] * len(queries)
        i = 0
        heap = []
        for q in queries:
            while i < len(rooms) and rooms[i][1] >= q[2]:
                heapq.heappush(heap, -rooms[i][0])
                i += 1
            while heap and -heap[0] not in rooms:
                heapq.heappop(heap)
                res[idx] = pq[0][1]
     if returnhees